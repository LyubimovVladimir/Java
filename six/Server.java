package homework.six;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Socket socket;

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String str = in.readUTF();
//                Scanner sc = new Scanner(System.in);
                if (str.equals("/end")) {
                    break;
                }
                out.writeUTF("Клиент: " + str + "\n");
//                if(!sc.toString().isEmpty()){
//                    out.writeUTF("Сервер: " + sc.toString());
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

