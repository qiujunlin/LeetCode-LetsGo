package template.mianshi;

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
