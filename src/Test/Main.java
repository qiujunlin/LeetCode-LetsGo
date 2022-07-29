package Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static class Node{
        private int a;
        String b;
        private  int get(){
            System.out.println(11);
            return  1;
        }

        @Override
        public boolean equals(Object obj) {
            Node a = (Node)obj;
       ///     String.
            return  this.a == a.a && this.b.equals(a.b);
        }
    }

        //初始化ReentrantLock
    /**
     * @author liuhuifang
     * @date 2022/5/26 11:31
     *
     */

    public static void main(String[] args) throws InterruptedException {
      //Random random =new Random();
      //int a =random.nextInt(100);
       class  N{
           String s ;
           public  String get(){
               return s+"1";
           }
       }
       N  n =new N();
        System.out.println(n.get());




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







