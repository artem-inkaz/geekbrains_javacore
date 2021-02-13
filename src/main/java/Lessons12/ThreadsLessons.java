package Lessons12;

import java.util.Arrays;

public class ThreadsLessons {
    static final int SIZE = 10;
    static final int HALF = SIZE / 2;
    private static float[] arr = new float[SIZE];
    private static float[] arr2 = new float[HALF];
    private static float[] arr3 = new float[HALF];
    private static float[] arr4 = new float[SIZE];

    static int a = 0;
    static int b = 0;
    static int c = 0;

    public static void main(String[] args) {
        Thread method1 = new MyThread("SUPERTHREAD #1");
        Thread method2 = new MyThread2("SUPERTHREAD #2");
        Thread method3 = new MyThread3("SUPERTHREAD #3");
        Thread method4 = new MyThread4("SUPERTHREAD #4");
//        System.out.println("Hello " + Thread.currentThread().getName());
        // start() запускает отдельный поток и в нем запускает run()
        long a_start_1 = System.currentTimeMillis();
        method1.start();
//        method1.run();

        //стартует поток #2 только после того, как поток #1 закончит свое выполнение
        try {
            method1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // печатаем массив
        System.out.println(Arrays.toString(arr));
        long a_end_1 = System.currentTimeMillis();
        System.out.println("Время выполнения поток #1 " + ((a_end_1-a_start_1))+ " ms");
        // делим исходный массив
        arrCopy(arr);
        //----------------------------------поток #2 ------------------------------------------
        long a_start_2 = System.currentTimeMillis();
        method2.start();

        try {
            method2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // печатаем массив
        System.out.println(Arrays.toString(arr));
        long a_end_2 = System.currentTimeMillis();
        System.out.println("Время выполнения поток #2 " + ((a_end_2-a_start_2))+ " ms");
        //----------------------------------поток #3 ------------------------------------------
        long a_start_3 = System.currentTimeMillis();
        method3.start();

        try {
            method3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // печатаем массив
        System.out.println(Arrays.toString(arr2));
        long a_end_3 = System.currentTimeMillis();
        System.out.println("Время выполнения поток #3 " + ((a_end_3-a_start_3))+ " ms");
        //----------------------------------поток #4 ------------------------------------------
        long a_start_4 = System.currentTimeMillis();
        method4.start();

        try {
            method4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // печатаем массив
        System.out.println(Arrays.toString(arr3));
        long a_end_4 = System.currentTimeMillis();
        System.out.println("Время выполнения поток #4 " + ((a_end_4-a_start_4))+ " ms");
        //----------------------------------------------------------------------------
        // склеиваем массив
        unionArray(arr2,arr3);

    }

    private static void increments() {
        Runnable r = ThreadsLessons::increment;
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }

    static synchronized void increment() {
            for (int i = 0; i < 1000_000; i++) {
                a = a + 1;
                b = b + 1;
                c = c + 1;
            }
            System.out.printf("a = %d, b = %d, c = %d\n", a, b, c);
        }

    private static void threadStop(){

        Thread tstop = new Thread(()->{
//           while (true){
               while (!Thread.currentThread().isInterrupted()){

               try {
                   Thread.sleep(300);
                   System.out.println("print print");
               } catch (InterruptedException e) {
//                   e.printStackTrace();
                   Thread.currentThread().interrupt();
               }
           }
            System.out.println("Thread stoped");
        });
        tstop.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tstop.interrupt();
    }

    private static void threadExample() {
        Thread methodRunnable = new Thread(new MyRunnable());
        methodRunnable.start();

        Thread unnameThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello unnameThread " + Thread.currentThread().getName());
            }
        });
        unnameThread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello unnameThread2 " + Thread.currentThread().getName());
            }
        }).start();
    }
    // Homework task#1 filling 1
    static class MyThread extends Thread {

        public MyThread() {
            super();
        }
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run(){
            System.out.println("Поток #1 начал работу:::" + Thread.currentThread().getName());
 //           long a = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
//                System.out.println(i);
//                try {
//                    Thread.sleep(1);
//                    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    arr[i] = 1.0f;
//                    System.out.println(arr[i]);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("Поток #1 завершил работу:::" + Thread.currentThread().getName());
        }
    }
    // countig Math formula
    static class MyThread2 extends Thread {

        public MyThread2() {
            super();
        }
        public MyThread2(String name) {
            super(name);
        }

        @Override
        public void run(){
            System.out.println("Поток #2 начал работу:::" + Thread.currentThread().getName());
            //           long a = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
//                System.out.println(i);
//                try {
//                    Thread.sleep(1);
                    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                arr[i] = 1.0f;
//                    System.out.println(arr[i]);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("Поток #2 завершил работу:::" + Thread.currentThread().getName());
//            System.out.println(Arrays.toString(arr));
        }
    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("Hello MyRunnable" + Thread.currentThread().getName());
        }
    }

    private static void arrCopy(float[] array) {
        System.out.println("Массив разделенный на две части");
                                                            //array.length/2
//        float[] arr1 = Arrays.copyOfRange(array, 0, HALF);
//        System.out.println(Arrays.toString(arr1));
//        float[] arr2 = Arrays.copyOfRange(array, HALF, array.length);
//        System.out.println(Arrays.toString(arr2));

        arr2 = Arrays.copyOfRange(array, 0, HALF);
        System.out.println(Arrays.toString(arr2));

        arr3 = Arrays.copyOfRange(array, HALF, array.length);
        System.out.println(Arrays.toString(arr3));

    }

    // countig Math formula
    static class MyThread3 extends Thread {
        public MyThread3() {
            super();
        }
        public MyThread3(String name) {
            super(name);
        }
        @Override
        public void run(){
            System.out.println("Поток #3 начал работу:::" + Thread.currentThread().getName());
            for (int i = 0; i < HALF; i++) {
                arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Поток #3 завершил работу:::" + Thread.currentThread().getName());
        }
    }
    // countig Math formula
    static class MyThread4 extends Thread {
        public MyThread4() {
            super();
        }
        public MyThread4(String name) {
            super(name);
        }
        @Override
        public void run(){
            System.out.println("Поток #4 начал работу:::" + Thread.currentThread().getName());
            for (int i = 0; i < HALF; i++) {
                arr3[i] = (float)(arr3[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Поток #4 завершил работу:::" + Thread.currentThread().getName());
//            System.out.println(Arrays.toString(arr));
        }
    }

    private static void unionArray(float[] array,float[] array2){
        System.arraycopy(array, 0, arr4, 0, HALF);
        System.arraycopy(array2, 0, arr4, HALF, HALF);
        System.out.println(Arrays.toString(arr4));
    }

}
