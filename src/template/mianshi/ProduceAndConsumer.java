package template.mianshi;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProduceAndConsumer {
  static   LinkedBlockingDeque<Integer> queue =new LinkedBlockingDeque<>();
    static class Produce implements  Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    queue.put(1);
                    System.out.println("生产一条消息");
               //     Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
  static   class Consumer implements  Runnable{
        int s;
        public  Consumer(int s){
            this.s =s;
        }
        @Override
        public void run() {
            while (true){
                try {
                    queue.take();
                    System.out.println(s + "消费一条消息");
                   // Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Produce()).start();
        for (int i = 0; i <100 ; i++) {
            new Thread(new Consumer(i)).start();
        }


    }


}



/**
 * 生产者和消费者，wait()和notify()的实现
 * @author ZGJ
 * @date 2017年6月22日
 */
 class Test1 {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}


/**
 * 使用semaphore信号量实现
 * @author ZGJ
 * @date 2017年6月29日
 */
 class Test4 {
    private static Integer count = 0;
    //创建三个信号量
    final Semaphore notFull = new Semaphore(10);
    final Semaphore notEmpty = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        new Thread(test4.new Producer()).start();
        new Thread(test4.new Consumer()).start();
        new Thread(test4.new Producer()).start();
        new Thread(test4.new Consumer()).start();
        new Thread(test4.new Producer()).start();
        new Thread(test4.new Consumer()).start();
        new Thread(test4.new Producer()).start();
        new Thread(test4.new Consumer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    notFull.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notEmpty.release();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notFull.release();
                }
            }
        }
    }
}