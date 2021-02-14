package Array;

import java.util.*;

/**
 * @Classname Q1584
 * @Description:
 * @Date 2021/2/13 18:16
 * @Created by qiujunlin
 */
public class Q1584 {
    public static void main(String[] args) {
        int a = 1000000007;
        long b = Integer.MAX_VALUE;
        long c  =a*a;
        System.out.println(c);
    }
    public int minCostConnectPoints(int[][] points) {
        Union1  u = new Union1(points.length);
        PriorityQueue<int []> que = new  PriorityQueue<>(((o1, o2) -> o1[0]-o2[0]));
        for(int i  = 0 ;i<points.length;i++){
            for(int j = i+1;j<points.length;j++){
                int a[] = points[i];
                int b[] = points[j];
                int len = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
                que.offer(new int[]{len,i,j});
            }
        }
        int res  = 0;
        while(!que.isEmpty()){
           int a[] = que.poll();
           if(u.isconnect(a[1],a[2])) continue;
           u.merge(a[1],a[2]);
           res +=  a[0];
           if(u.count==1) return  res;
        }
        return  res;
    }
}
class Union1{
    int parent[];
    int count;
    int rank[];
    public  Union1(int len){
        parent = new int[len];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        count  = len;
        rank = new int[len];
    }
    public  boolean isconnect(int x ,int y ){
        return  find(x) == find(y);
    }
    public  void merge(int x,int y){
        int fx = find(x);
        int fy = find(y);
        if(fx != fy) {
            if(rank[fx]>rank[fy]){
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            count--;
        }
        if(rank[fx] == rank[fy]) rank[fx]++;
        parent[fx] = fy;
    }
    public int find(int x){
        return x == parent[x]?x : (parent[x] = find(parent[x]));
    }

}