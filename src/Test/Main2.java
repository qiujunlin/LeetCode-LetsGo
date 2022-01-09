package Test;


import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


public class Main2 {

    public static AtomicInteger race = new AtomicInteger(0) ;

    private static final int THREADS_COUNT = 20;

    //private static CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);

    public static void increase() {
        race.getAndIncrement();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
              //      countDownLatch.countDown();
                }
            });
            threads[i].start();
        }
        //countDownLatch.await();
        System.out.println(race);
    }


}
