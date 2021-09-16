package leetcode;

import java.util.*;

public class Q121 {
    public int maxProfit(int[] prices) {
        //Queue
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int min =Integer.MAX_VALUE;
        int res =0;
        for (int i = 0; i < prices.length; i++) {
            res =Math.max(prices[i]-min,res);
            min = Math.min(min,prices[i]);
        }
        return  res;
    }

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(2);
        System.out.println(deque.peek());
    }

}
