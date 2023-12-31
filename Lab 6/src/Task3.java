public class Task3 {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        fillArray(arr, size);

        long startTime = System.currentTimeMillis();
        calculateArrayValues(arr, size);
        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded execution time: " + (endTime - startTime) + " ms");

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        startTime = System.currentTimeMillis();
        splitAndCalculate(arr, arr1, arr2);
        endTime = System.currentTimeMillis();
        System.out.println("Multi-threaded execution time: " + (endTime - startTime) + " ms");
        System.out.println(arr1.length);
        System.out.println(arr2.length);
        System.out.println(arr.length);
    }


    private static void fillArray(float[] arr, int len) {
        for (int i = 0; i < len; i++) {
            arr[i] = 1.0f;
        }
    }

    private static void calculateArrayValues(float[] arr, int len) {
        for (int i = 0; i < len; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void splitAndCalculate(float[] arr, float[] arr1, float[] arr2) {

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread thread1 = new Thread(() -> calculateArrayValues(arr1, h));
        Thread thread2 = new Thread(() -> calculateArrayValues(arr2, h));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
    }
}