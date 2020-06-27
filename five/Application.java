package homework.five;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] ar1 = new float[h];
        float[] ar2 = new float[h];
        Arrays.fill(arr, 1);
        timerOne(arr);
        timerTwo(arr, ar1, ar2, h);
    }

    public synchronized static void timerOne(float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public synchronized static void timerTwo(float[] arr, float[] ar1, float[] ar2, int h){
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, ar1, 0, h);
        System.arraycopy(arr, h, ar2, 0, h);
        new Thread(new TimerTwo(ar1, h));
        new Thread(new TimerTwo(ar2, h));
        System.arraycopy(ar1, 0, arr, 0, h);
        System.arraycopy(ar2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }
}
