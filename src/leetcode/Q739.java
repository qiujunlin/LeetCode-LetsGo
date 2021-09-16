package leetcode;

import java.util.*;

/**
 * @Classname Q739
 * @Description:
 * @Date 2021/5/10 21:45
 * @Created by qiujunlin
 */
public class Q739 {
    public int[] dailyTemperatures(int[] T) {
         int res[] = new int[T.length];
         Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!deque.isEmpty()&&T[deque.peekLast()]<T[i]){
                res[T[deque.pollLast()]] = i-deque.pollLast();
            }
            deque.offerLast(i);
        }
        while (!deque.isEmpty()){
            res[deque.pollLast()]=0;
        }
        return  res;

    }
}
