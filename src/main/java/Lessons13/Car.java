package Lessons13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;

    private static final Lock lock = new ReentrantLock();
    private static final CyclicBarrier cb = new CyclicBarrier(5);
    private static final CountDownLatch cdl = new CountDownLatch(4);

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public static CountDownLatch getCdl() {
        return cdl;
    }
    public static CyclicBarrier getCb() {
        return cb;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            Thread.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            try {
               Thread.sleep(200);
//                cb.await();
            } catch (InterruptedException  e) {
                e.printStackTrace();
            }
        }
        if (lock.tryLock()) System.out.println(this.name + " WINNER!!!");
        cdl.countDown();

    }

    @Override
    public String toString() {
        return "Car{" +
                "race=" + race +
                ", speed=" + speed +
                ", name='" + name + '\'' +
                '}';
    }


}
