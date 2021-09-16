package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Q901 {
    Deque<int[]> deque = new LinkedList<>();
    int index =0;
    public int next(int price) {
        while (!deque.isEmpty()&&deque.peekLast()[1]<=price){
            deque.peekLast();
        }
        int res =1;
        if(deque.isEmpty()) res =index;
        else  res =index-deque.peekLast()[0];
        deque.offer(new int[]{index,price});
        index++;
        return  res;
    }
}
