package Array;

import java.util.PriorityQueue;

public class Q1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1;i<heights.length;i++){
            if(heights[i]>heights[i-1]){
                queue.offer(heights[i]-heights[i-1]);
                if(queue.size()>ladders){
                   int min  =  queue.poll();
                   bricks-=min;
                   if(bricks<0) return i-1;
                }
            }
        }
        return  0;
    }
}
