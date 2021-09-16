package leetcode;

import java.util.*;

/**
 * @Classname SlidingWindowMedian480
 * @Description:
 * @Date 2021/2/3 11:45
 * @Created by qiujunlin
 */

class DualHeap {
    // 大根堆，维护较小的一半元素
    private PriorityQueue<Integer> small;
    // 小根堆，维护较大的一半元素
    private PriorityQueue<Integer> large;
    // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
    private Map<Integer, Integer> delayed;
    private int k;
    // small 和 large 当前包含的元素个数，需要扣除被「延迟删除」的元素
    private int smallSize, largeSize;

    public DualHeap(int k) {
        this.small = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        this.large = new PriorityQueue<Integer>();
        this.delayed = new HashMap<Integer, Integer>();
        this.k = k;
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian() {
        return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
    }

    //在进行插入的时候，
    public void insert(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            smallSize++;
            small.offer(num);
        } else {
            largeSize++;
            large.offer(num);
        }
        makeBalance();

    }

    public void erase(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (num <= small.peek()) {
            smallSize--;
            if (num == small.peek()) {
               prune(small);
            }
        } else {
            largeSize--;
            if (num == large.peek()) {
                prune(large);
            }
        }
    }

    // 不断地弹出 heap 的堆顶元素，并且更新哈希表
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && delayed.containsKey(heap.peek())) {
            int temp = heap.poll();
            delayed.put(temp, delayed.get(temp) - 1);
            if (delayed.get(temp) == 0) {
                delayed.remove(temp);
            }
        }
    }

    // 调整 small 和 large 中的元素个数，使得二者的元素个数满足要求
    private void makeBalance() {
        if (smallSize - largeSize >= 2) {
            int temp = small.poll();
            smallSize--;
            large.offer(temp);
            largeSize++;
            prune(small);
        } else if (smallSize < largeSize) {
            int temp = large.poll();
            smallSize ++;
            largeSize--;
            large.offer(temp);
            prune(large);
        }

    }
}

public class SlidingWindowMedian480 {
    public static void main(String[] args) {
        Collections.reverseOrder();
    }


}
