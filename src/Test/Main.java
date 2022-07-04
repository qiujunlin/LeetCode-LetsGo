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
    class LFUCache {
        class Node{
            int key;int val;int age;
            public Node(int key,int val){this.key =key;this.val =val;}

        }
        HashMap<Integer,Node> map =new HashMap();
        HashMap<Integer,LinkedList<Node>> map2 =new HashMap();
        int cap ;
        int  minlevel = 0;
        public LFUCache(int capacity) {
            this.cap =capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)) {
                Node n = map.get(key);
                LinkedList l = map2.get(n.age);
                l.remove(n);
                n.age++;
                map2.computeIfAbsent(n.age,(k)->new LinkedList()).addLast(n);
                if(minlevel==n.age-1&&l.size()==0) minlevel = n.age;

            }else{
                return -1;
            }

        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node  n = map.get(key);
                LinkedList l = map2.get(n.age);
                l.remove(n);
                n.age++;
                n.val =value;
                map2.compteIfAbsent(n.age,(k)->new LinkedList()).addLast(n);
                if(minlevel==n.age-1&&l.size()==0) minlevel = n.age;
            }else{
                if(map.size()==cap){
                    Node  node = map2.get(minlevel).removeFirst();
                    map.remove(node.key);
                }
                Node n =new Node(key,value);
                map2.compteIfAbsent(n.age,(k)->new LinkedList()).addLast(n);
                minlevel = 0;
            }


        }
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
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







