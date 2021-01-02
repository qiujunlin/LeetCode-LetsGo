package Array;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2021/1/2
 */
public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        res[0] = queue.peek()[0];
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) queue.poll();
            res[index++] = queue.peek()[0];
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int left=0;int right=0;
        int res[]= new int[nums.length-k+1];
        int index=0;
        for(int i=0;i<k;i++){
            while(queue.size()!=0&&nums[queue.getLast()]<nums[i]){
                queue.removeLast();
            }
            queue.offer(i);
        }
        res[index++]=nums[queue.peek()];
        for(int i=k;i<nums.length;i++){
            while(queue.size()!=0&&nums[queue.getLast()]<nums[i]){
                queue.removeLast();
            }
            queue.offer(i);
            while(queue.peek()<=i-k){
                queue.removeFirst();
            }
            res[index++]=nums[queue.peek()];
        }
        return res;
    }
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();

    }
}
