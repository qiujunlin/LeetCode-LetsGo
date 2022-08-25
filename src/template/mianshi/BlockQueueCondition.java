package template.mianshi;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueueCondition {

    private List<Integer>list = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition emptyLock = lock.newCondition();
    private Condition fullLock = lock.newCondition();

    //list的默认长度
    private final static int DEFAULT_QUEUQE_SIZE = 10;
    private int size;

    public BlockQueueCondition(){
        this.size = DEFAULT_QUEUQE_SIZE;
    }
    public BlockQueueCondition(int size){
        this.size = size;
    }

    /**
     * 使用while循环，来并发异常，await存放在lock中
     * @param num  要插入的数据
     *
     * 插入数据的方法
     */
    public void myPut(int num){
        try {
            lock.lock();
            while (list.size() >= size){
                System.out.println("队列已满");
                fullLock.await();
            }
            list.add(num);
            emptyLock.signal();
        }catch (Exception e){
            emptyLock.signal();
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    /**
     * 使用while循环，来并发异常，await存放在lock中
     * 获取数据的方法
     */
    public Object myTake(){
        try {
            lock.lock();
            while (list.size() <= 0){
                System.out.println("队列为空");
                emptyLock.await();
            }
            Integer integer = list.remove(0);
            fullLock.signal();
            return integer;
        }catch (Exception e){
            fullLock.signal();
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockQueueCondition myque = new BlockQueueCondition(2);
        myque.myPut(2);
        myque.myPut(3);
        System.out.println(myque.myTake());//输出2
        System.out.println(myque.myTake());//输出3
        System.out.println(myque.myTake());//输出队列为空并且阻塞

        myque.myPut(3);
    }
}

