package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Q407 {
    public int trapRainWater(int[][] heightMap) {
        //
        int m =  heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> q = new PriorityQueue();
        boolean vis[][] = new boolean[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0||i==m-1||j==n-1){
                    vis[i][j]=true;
                    q.offer(new int[]{i,j,heightMap[i][j]});
                }
            }
        }
        int res =0;
        int direct[][] = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        while (!q.isEmpty()){

            int nums[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int newx = nums[0]+direct[i][0];
                int newy = nums[1]+direct[i][1];
                if(newx>=0&&newy>=0&&newx<m&&newy<n&&!vis[newx][newx]){
                     if(heightMap[newx][newy]<nums[2]){
                         res+=heightMap[newx][newy]-nums[2];
                     }
                     q.offer(new int[]{newx,newy,Math.max(heightMap[newx][newy],nums[2])});
                     vis[newx][newy] =true;
                }
            }
        }
        return  res;


    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
            int res[] =new int[queries.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (int i = 0; i < queries.length; i++) {
            queue.offer(new int[]{i,queries[i]});
        }
        PriorityQueue<int[]> queue1 =new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for (int i = 0; i <items.length ; i++) {
            queue1.offer(items[i]);
        }
        PriorityQueue<Integer> max=  new PriorityQueue<>((a,b)->b-a);
        while (!queue.isEmpty()){
            int a[] = queue.poll();
            while (!queue1.isEmpty()&&queue1.peek()[0]<=a[1]){
                int b[]= queue1.poll();
                max.offer(b[1]);
            }
            if(max.isEmpty())
            res[a[0]] =0;
            else res[a[0]]=max.peek();

        }
        return  res;

    }
}
