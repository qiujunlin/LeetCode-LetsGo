package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q630 {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        Arrays.sort(courses,(a,b)->b[1]-a[1]);
        for (int i = 0; i <courses.length ; i++) {
             int t  = courses[i][0]; int end = courses[i][1];
            if(sum+t<=end){
                queue.offer(t);
                sum +=  t;
            }else{
                if(!queue.isEmpty()&& queue.peek()>t){
                    int max  = queue.poll();
                    queue.offer(t);
                    sum  = sum  -(max - t);
                }
            }
        }
        return  queue.size();
    }
}
