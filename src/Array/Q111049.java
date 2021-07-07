package Array;

import java.util.*;
/**
 * @Classname Q111049
 * @Description:
 * @Date 2021/6/8 0:07
 * @Created by qiujunlin
 */
public class Q111049 {
    public int lastStoneWeightII(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
        for(int a:stones){
            queue.add(a);
        }
        while (queue.size()>0){
            int n = queue.poll();
            int b =queue.poll();
            if(n-b>0){
                queue.offer(n-b);
            }
        }
        return  queue.size()==0?0:queue.poll();
    }
}
