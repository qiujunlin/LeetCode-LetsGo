package Contest;

import java.util.*;

public class W297 {
    public static void main(String[] args) {
       int a[] =new int[2];
       int i=0;
       a[i++] =1;
        System.out.println(a[1]);
    }
    class Node extends LinkedHashMap<Integer,Integer>{
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return super.removeEldestEntry(eldest);
        }
    }
    public double calculateTax(int[][] brackets, int income) {
        int i=0;
        int pre =0;
        double res =0;
        while (i<brackets.length){
            int a[] = brackets[i];
            if(income>a[0]){
                double c  = a[0]-pre;
                res += a[1]*c /100;
            }else{
                double c = income-a[0];
                res+= a[1]*c/100;
                return res;
            }
            pre =a[1];
        }
        return  res;

    }
    int[][] grid;;
    int[][] moveCost;
   HashMap<String,Integer>  m=new HashMap<>();
    public int minPathCost2(int[][] grid, int[][] moveCost) {
   this.grid=grid;
   this.moveCost =moveCost;
   int min=Integer.MAX_VALUE;

   int sum =0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                sum+=grid[i][j];
            }
        }
        sum+= 100*grid.length;
        for (int i = 0; i <grid[0].length ; i++) {
            min =Math.min(dfs(0,i,grid[0][i]),min);
        }
        return  min;
    }
   int  dfs(int i,int j,int sum){
        if(i==grid.length-1){
            return sum;
        }
        String s =String.valueOf(i)+"_"+String.valueOf(j)+"_"+String.valueOf(sum);
        if(m.get(s)!=null) return  m.get(s);
        int min  =Integer.MAX_VALUE;
        for (int k = 0; k <grid[0].length ; k++) {
            min =Math.min(min, dfs(i+1,k,sum+moveCost[grid[i][j]][k]+grid[i+1][k]));
        }
        m.put(s,min);
        return min;
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m  = grid.length;
        int n =grid[0].length;
        int dp[][] =new int[m][n];
        for (int i = 0; i <n ; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i <m ; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for (int i = 1; i <grid.length ; i++) {
            for (int j = 0; j <n ; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j] =Math.min(dp[i-1][k]+dp[i][j]+moveCost[grid[i-1][k]][j],dp[i][j]);
                }
            }
        }
        int min =Integer.MAX_VALUE;
        for (int i = 0; i <n ; i++) {
            min =Math.min(dp[m-1][i],min);
        }
        return  min;

    }
    public int distributeCookies(int[] cookies, int k) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <cookies.length ; i++) {
            min =Math.min(min,cookies[i]);
        }
        int res = cookies.length-k-1;
        int len =cookies.length;
        for (int i = 0; i <(1<<len); i++) {
            int sum =0;
            boolean vis[] = new boolean[len];
            for (int j = 0; j <len ; j++) {
                if(((i>>j)&1)==1){
                    sum+=cookies[j];
                 vis[j]=true;
                }
            }
            int c =0;
            int d =0;
            for (int j = 0; j < cookies.length; j++) {
                if(!vis[j]){
                    if(c+cookies[i]>sum) {
                        c =cookies[i];d++;
                    }else{
                        c+=cookies[i];
                    }
                }
            }
            if(c>0)d++;
            if(d<k-1) min =Math.min(min,sum);
        }
        return  min;

    }

}
