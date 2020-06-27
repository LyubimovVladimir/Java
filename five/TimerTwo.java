package homework.five;

public class TimerTwo implements Runnable {
    private float[] arX;
    private int h;

    public TimerTwo(float[] arX, int h) {
        this.arX = arX;
        this.h = h;
    }

    @Override
    public void run() {
        for (int i = 0; i < h; i++) {
            arX[i] = (float) (arX[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
