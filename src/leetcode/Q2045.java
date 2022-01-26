package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q2045 {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // bfs
        // 1 2 3 4
        ArrayList<Integer>[]  edge = new ArrayList[n];
        for (int i = 0; i <edge.length ; i++) {
             edge[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
             edge[edges[i][0]].add(edges[i][1]);
             edge[edges[i][1]].add(edges[i][0]);
        }
        int min[][]=  new int[n+1][2];
        for (int i = 0; i < min.length; i++) {
            Arrays.fill(min[i],Integer.MAX_VALUE);
        }
        Deque<int[] > deque =new LinkedList<>();

        deque.offer(new int[]{1,0});
        while (!deque.isEmpty()){
            int temp[] = deque.poll();
            int step = temp[1];
            for(int a: edge[temp[0]]){
                  if(step+1<min[a][0]){
                      min[a][0] =step+1;
                      deque.offer(new int[]{a,step+1});
                  }else if(step+1>min[a][0]&&step+1<min[a][1]){
                      min[a][1] =step+1;
                      deque.offer(new int[]{a,step+1});
                  }
            }
        }
        int res =0;
        for (int i = 0; i < min[n][1]; i++) {
             if(res%(change*2)>=change){
                 res =res+(2*change-res%(change*2));
             }
             res = res+time;
        }
        return  res;







    }
}
