package leetcode;

public class Q1269 {
    long mod =1000000007;
    public int numWays(int steps, int arrLen) {
       long dp[][]  = new long[steps][arrLen];
       int max  = Math.min(steps,arrLen);
       for(int i=0;i<steps;i++){
           for(int j = 0;j<max;j++){
               dp[i][j] = dp[i][j]+dp[i-1][j];
               if(j-1>=0) dp[i][j]+=dp[i-1][j-1];
               if(j+1<max)dp[i][j] +=dp[i-1][j+1];
           }
       }
       return  (int)(dp[steps-1][max-1]%1000000007);
    }
   long   dfs(int index,int steps,int arrlen){
        if(index<0) return 0;
        if(index>=arrlen) return 0;
        if(index==0&&steps==0){
            return  1;
        }
        long sum =0;
        for(int i =-1;i<=1;i++){
         sum+=   dfs(index+i,steps-1,arrlen);
        }
        return  sum;
    }
}
