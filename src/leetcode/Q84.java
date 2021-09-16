package leetcode;

import java.util.*;

/**
 * @Classname Q84
 * @Description:
 * @Date 2021/3/17 16:31
 * @Created by qiujunlin
 */
public class Q84 {
    public int largestRectangleArea(int[] heights) {
        //使用单调栈的解法
        //思路 枚举高 寻找左右两侧 第一个小于当前高度的值  咩有的话 就是全部值
        Deque<Integer> deque = new LinkedList<>();
        int left[] = new int[heights.length];
        Arrays.fill(left, -1);
        int right[] = new int[heights.length];
        Arrays.fill(right, heights.length);
        //寻找左边
        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[deque.peekLast()] > heights[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty()) {
                left[i] = deque.peekLast();
            }
            deque.offer(i);
        }
        //寻找右边
        deque.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peekLast()] > heights[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty()) {
                right[i] = deque.peekLast();
            }
            deque.offer(i);
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int len = right[i] - left[i] - 1;
            max = Math.max(len * heights[i], max);
        }
        return max;


    }
}

