package leetcode;

import Test.Main2;

import java.util.*;

public class Main {

    public int numOfWays(int n) {
        //
        ArrayList<Integer> l =new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(i!=j&&j!=k){
                        l.add(i*9+j*3+k);
                    }
                }
            }
        }
        int size = l.size();
        boolean judge[][] = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            int num1 = l.get(i);
            int  a1 = num1/9; int b1 = num1/3%3;int c1 = num1%3;
            for (int j = 0; j <size ; j++) {
                int num2 =l.get(j);
                int  a2= num2/9; int b2 = num2/3%3;int c2 = num2%3;
                if(a1!=a2&&b1!=b2&&c1!=c2){
                    judge[i][j] = true;
                }
            }
        }
        int mod= 1000000007;
        int dp[][] =    new int[n+1][size];
        for (int i = 0; i <size ; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j <size ; j++) {
                for (int k = 0; k < size; k++) {
                    if(j!=k&&judge[j][k]){
                        dp[i][j] = (dp[i][j] + dp[i-1][k])%mod;
                    }
                }
            }
        }
        int res =0;
        for (int i = 0; i <size ; i++) {
            res =(res+ dp[n][i])%mod;
        }
        return  res;


    }
    public int colorTheGrid(int m, int n) {
        //
        ArrayList<Integer> l =new ArrayList<>();
        int size = l.size();
        boolean judge[][] = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            int num1 =l.get(i);
            for (int j = 0; j <size ; j++) {
                int num2 =l.get(j);
                boolean issame =true;
                int c =5;
                while (c>0){
                    if(num1%3==num2%3) {
                        issame =false;break;
                    }
                    num1 =num2/2;num2=num2/3;
                }
                if(issame) judge[i][j] =true;
            }
        }
        int mod= 1000000007;
        int dp[][] =    new int[n+1][size];
        for (int i = 0; i <size ; i++) {
              dp[1][i] = 1;
        }
        for (int i = 2; i <=n ; i++) {// 列
            for (int j = 0; j <size ; j++) { //种类
                for (int k = 0; k < size; k++) { //  遍历种类
                    if(j!=k&&judge[j][k]){
                        dp[i][j] = (dp[i][j] + dp[i-1][k])%mod;
                    }
                }
            }
        }
        int res =0;
        for (int i = 0; i <size ; i++) {
            res =(res+ dp[n][i])%mod;
        }
        return  res;



    }
    void  dfs(int i,int num,ArrayList<Integer> l,int pre){
         if(i==5) {l.add(num);return;}
         for (int j = 0; j < 3; j++) {
              if(pre==j) continue;
              int n =  num*3 +j;
              dfs(i+1,n,l,j);
         }
    }
    public String longestDupSubstring(String s) {
          int len =s.length();
          long hash[] =new long[len+1];
          long p = 13;
          long par[] = new long[len+1];
        for (int i = 0; i <len ; i++) {
            par[i+1] =  par[i]*p ;
            hash[i+1] = hash[i]*p +  s.charAt(i)-'a';
        }
        int l  = 0;
        int r = s.length()-1;
        String res = "";
        while (l<r){
            int mid  = (l+r+1)/2;
            String t =check(mid,s,hash,par);
            if(t.length()==0){
                l = mid;
            }else{
                res = t;
                r =mid-1;
            }
        }
        return  res;

    }

    private String check(int mid, String s, long[] hash, long par[]) {
        HashSet<Long> set =new HashSet<>();
        for (int i = 0; i <s.length() ; i++) {
            int r = i+mid-1;
            if(r>=s.length()) return  "";
            long ha =  hash[r]-hash[i]*par[r-i+1];
            if(set.contains(ha))  return  s.substring(i,r+1);
            else set.add(ha);
        }
        return  "";
    }
    public int shortestPathLength(int[][] graph) {
        Queue<int[]>  q =new LinkedList<>();
       //ArrayList<Integer>  l[] = new ArrayList[graph]
        for (int i = 0; i <graph.length ; i++) {
           int num =  1<<i;//  {i,len.num}
           q.offer(new int[]{i,0,num});
        }
        int min  =Integer.MAX_VALUE;

        while (!q.isEmpty()){
            int a[] = q.poll();
            if (a[1]==(1<<graph.length)-1){
                min =Math.min(a[1],min);
                continue;
            }
            if(a[1]>min)continue;
            for(int n : graph[a[0]]){
                int num = a[2];
                num|= 1<<n;
                q.offer(new int[]{n,a[1]+1,num});
            }
        }
        return min;

    }
    public int shortestSubarray(int[] nums, int k) {
        TreeMap<Integer,ArrayList<Integer>> map =new TreeMap<>();
        int sum =0;
        map.computeIfAbsent(0,(key)->new ArrayList<>()).add(-1);
        int min =nums.length+1;
        for (int i = 0; i < nums.length; i++) {
             sum += nums[i];
             map.computeIfAbsent(sum,(a)->new ArrayList<>()).add(i);
             int cha =  sum-k;
                 Integer temp =map.floorKey(cha);
             if(temp!=null){
                 for(int a :  map.get(temp)){
                     min =Math.min(i-a,min);
                 }
             }
        }
        return  min ==nums.length+1? -1:min;

    }
    public long subArrayRanges(int[] nums) {
        long res =0;
        for (int i = 0; i <nums.length ; i++) {
             int max =nums[i];
             int min =nums[i];
            for (int j = i+1; j <nums.length ; j++) {
                max =Math.max(nums[j],max);
                min =Math.min(nums[j],min);
                res += max-min;
            }

        }
        return  res;

    }

    public static void main(String[] args) {
        int a[] ={1,5,11,5};
        out:while (true){
            break  out;
        }


    }

}
