package Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ZeroEvenOdd {
    private int n;
    private BlockingQueue<Integer> a = new LinkedBlockingQueue<>(1);
    private BlockingQueue<Integer> b = new LinkedBlockingQueue<>(1);
    private BlockingQueue<Integer> c = new LinkedBlockingQueue<>(1);
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.a.add(1);
    }
    public void zero() throws InterruptedException {
        for(int i=1;i<=n;i++){
            a.take();
            System.out.println(0);
            if(i%2==0){
                b.put(1);
            }else{
                c.put(1);
            }
        }
    }

    public void even() throws InterruptedException {
        for(int i=2;i<=n;i++){
            if((i&1)==0){
                b.take();
                System.out.print(i);
                a.put(1);        }
        }
    }

    public void odd() throws InterruptedException {
        for(int i=1;i<=n;i++){
            if((i&1)==1){
                c.take();
                System.out.print(i);
                a.put(1);
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd =new ZeroEvenOdd(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}