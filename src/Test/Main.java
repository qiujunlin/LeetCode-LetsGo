package Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

        //初始化ReentrantLock
    /**
     * @author liuhuifang
     * @date 2022/5/26 11:31
     */

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore =new Semaphore(2);
       // System.out.println( semaphore.);
        HashMap<Integer,Integer> map =new HashMap<>();

//        Long start1 = System.currentTimeMillis();
//        CountDownLatch latch = new CountDownLatch(5);
//        for(int i = 0; i<5; i++){
//            new Thread(new Test(latch, i)).start();
//        }
//        latch.await();
//        try {
//            System.out.println("count");
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("last");

    }

    static class Test implements Runnable{
        private CountDownLatch latch;
        Test(CountDownLatch latch, int i){
            this.latch = latch;
        }
        @Override
        public void run() {

            latch.countDown();
            try {
                System.out.println("count");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("count final");
        }
    }

}







