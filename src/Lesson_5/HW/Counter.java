package Lesson_5.HW;

public class Counter {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    static float[] array = new float[SIZE];

    public static void main(String[] args) {

        method1();
        method2();
    }

    private static void fillArray(float[] arr){
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
    }

    public static void method1() {
        fillArray(array);

        long time = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("array[size/2]: " + array[HALF]);
        System.out.println("Time of one-thread method: " + (System.currentTimeMillis() - time));
    }

    private static void divideArray(float[] a1, float[] a2) {
        System.arraycopy(array, 0, a1, 0, HALF);
        System.arraycopy(array, HALF, a2, 0, HALF);
    }

    private static void restoreArray(float[] a1, float[] a2) {
        System.arraycopy(a1, 0, array, 0, HALF);
        System.arraycopy(a2, 0, array, HALF, HALF);
    }

    public static void countValues(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + HALF) / 5) *
                    Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
        }
    }

    public static void method2() {
        fillArray(array);

        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        long time = System.currentTimeMillis();
        divideArray(a1, a2);

        Thread t1 = new Thread(()->{
            countValues(a1);
        });

        Thread t2 = new Thread(()->{
            countValues(a2);
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        restoreArray(a1, a2);
        System.out.println("array[size/2]: " + array[HALF]);
        System.out.println("Time of two-thread method: " + (System.currentTimeMillis() - time));
    }
}
