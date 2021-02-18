package Lessons13;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static Race race = new Race(new Road(60), new Tunnel(100), new Road(40));
    public static Car[] cars = new Car[CARS_COUNT];

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНЬЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(100), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
//            new Thread(cars[i]).start();
        }
        for (Car car : cars) {
            new Thread(car).start();
        }

        try {
            Car.getCb().await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНЬЕ >>> Гонка началась!!!");
            Car.getCdl().await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНЬЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static void example() throws BrokenBarrierException, InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНЬЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(100), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT-1);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            new Thread(cars[i]).start();
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
//            cb.await();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНЬЕ >>> Гонка началась!!!");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНЬЕ >>> Гонка закончилась!!!");
    }

    //гонка по одному
    private static void readyAndGo2()  {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНЬЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(100), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        final int[] f = {0};
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            final int w = i;
            cars[i].run();
        }
    }

    public static void readyAndGo() {
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        final int[] f = {0};
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            final int w = i;
            int finalI = i;
            new Thread(() -> {
                try {
                    System.out.println("Участник " + w + " готовится");
                    sleep(500 + (int) (800 * Math.random()));
                    System.out.println("Участник " + w + " готов");
                    cb.await();
                    ++f[0];
                    if (f[0] == 1) System.out.println("ВАЖНОЕ ОБЪЯВЛЕНЬЕ >>> Гонка началась!!!");
                    System.out.println("Участник " + w + " начал");
//                    cars[finalI].getRace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        continueStage();
    }

    public static void continueStage(){
        for (int i = 0; i < cars.length; i++) {
//            new Thread(cars[i]).start();
//            cars[i].getRace().toString();
//            race.getStages();
        }
    }
}
