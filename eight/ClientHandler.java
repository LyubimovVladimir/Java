package homework.eight;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;
    private float entryTime;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        entryTime = System.currentTimeMillis();
                        while(System.currentTimeMillis() - entryTime <= 120000) {
                            doAuth();
                        }
                        readMessage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        closeConnection();
                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Error occurred during client handler initialization");
        }
    }

    public String getName() {
        return name;
    }

    public void doAuth() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth")) {
                String[] parts = str.split("\\s");
                String nickname = server.getAuthService().getNickByLoginAndPass(parts[1], parts[2]);
                if (nickname != null) {
                    if (server.isNickFree(nickname)) {
                        sendMessage("/authok " + nickname);
                        name = nickname;
                        Server.broadcastMessage(name + " comes in chat");
                        server.subscribe(this);
                    } else {
                        sendMessage(String.format("Nickname[%s] is already in use", nickname));
                    }
                } else {
                    sendMessage("Incorrect login and/or password");
                }
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessage() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/")) {
                if (str.equals("/end")) {
                    break;
                }
                if (str.startsWith("/w ")) {
                    String[] tokens = str.split("\\s");
                    String nick = tokens[1];
                    String msg = str.substring(4 + nick.length());
                    Server.sendMsgToClient(this, nick, msg);
                }
                continue;
            }
            Server.broadcastMessage(name + ": " + str);
        }
    }

    public void closeConnection() {
        server.unsubscribe(this);
        Server.broadcastMessage(name + " left chat");

        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
