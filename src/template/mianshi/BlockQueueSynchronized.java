package template.mianshi;

import java.util.ArrayDeque;


interface BlockingQueue<E> {
    /**
     * 往队列尾部添加一个元素，当队列满时阻塞当前线程
     *
     * @param e
     */
    void put(E e);

    /**
     * 从队列首部取走一个元素，当队列为空时阻塞当前线程
     *
     * @return
     */
    E get();

    // 返回队列中元素的数量
    int size();
}

public class BlockQueueSynchronized<E> implements BlockingQueue<E> {
    private final static int DEFAULT_MAX_COUNT = 10;
    private final int maxCount;

    private final ArrayDeque<E> blockingQueue;

    public BlockQueueSynchronized() {
        this(DEFAULT_MAX_COUNT);
    }

    public BlockQueueSynchronized(int size) {
        blockingQueue = new ArrayDeque<>(size);
        maxCount = size;
    }

    @Override
    public void put(E e) {
        synchronized (blockingQueue) {
            while (blockingQueue.size() == maxCount) {
                try {
                    System.out.println("队列满了，等待消费者消费数据后再开始生产数据");
                    blockingQueue.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            blockingQueue.add(e);
            blockingQueue.notifyAll();
        }
    }

    @Override
    public E get() {
        synchronized (blockingQueue) {
            while (blockingQueue.size() == 0) {
                try {
                    System.out.println("队列中暂时还没数据，等待生产者生产数据");
                    blockingQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            blockingQueue.notifyAll();
            return blockingQueue.removeFirst();
        }
    }

    @Override
    public int size() {
        return blockingQueue.size();
    }

}

