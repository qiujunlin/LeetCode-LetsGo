package interview;

import java.util.*;

public class Main {
    public static void main(String[] args) {


    }
    public int swimInWater(int[][] grid) {
        int len  = grid.length;
        int length  = len*len;
        int nums[] = new int[length];
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j < len; j++) {
                 nums[grid[i][j]]  =  i*len +j;
            }
        }
        Union u =new Union(len);
        int dir[][] = {{0,1},{0,-1},{-1,0},{1,0}};
        for (int i = 0; i <length ; i++) {
            int n  = nums[i];
            int x = n/len;int y  =  n%len;
            for(int a[] :dir){
                 int newx = x+a[0];
                 int newy = y+a[1];
                 if(newx>=0&&newy>=0&&newx<len&&newy<len){
                     u.merge(n,newx*len+newy);
                 }
                 if(u.isconnected(0,length-1)) return  i;
            }
        }
        return  0;
    }
    public class Union {
        private  int parent[];
        int count  =0 ;
        public Union(int n ){
            this.count = n ;
            this.parent =  new int[n];
            for (int  i =0;i<n;i++) {
                this.parent[i] = i;
            }
        }
        public  void merge(int x,int y){
            int newx = find(x);
            int newy = find(y);
            if(newx==newy) return;
            else{
                parent[newx] = newy;
                count--;
            }
        }
        public int find(int x){
            return  x==parent[x]?(x):(parent[x] = find(parent[x]));
        }
        public boolean isconnected(int x,int y){
            return  find(x) ==find(y);
        }
    }

}
