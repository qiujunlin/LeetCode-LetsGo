package leetcode;

import java.util.PriorityQueue;

public class Q1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]>  queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        queue.offer(new int[]{apples[0],days[0]});
        for (int i = 1; i <apples.length ; i++) {
            //if(queue.peek())
            while (!queue.isEmpty() && queue.peek()[1] < i) {
                queue.poll();
            }
            if (apples[i] != 0)
                queue.offer(new int[]{apples[i], i + days[i]});
            if (queue.isEmpty()) return i;
            int temp[] = queue.peek();
            temp[0]--;
            if (temp[0] == 0) queue.poll();


        }
        int res  = apples.length;
        while (true){
            while (!queue.isEmpty() && queue.peek()[1] < res) {
                queue.poll();
            }
            if (queue.isEmpty()) return res;
            int temp[] = queue.peek();
            temp[0]--;
            if (temp[0] == 0) queue.poll();
            res++;
        }
        //while ()
       // return

    }
}
