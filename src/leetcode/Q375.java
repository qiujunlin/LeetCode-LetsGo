package leetcode;

public class Q375 {
    public int getMoneyAmount(int n) {
        /**  初始化 dp[i][i]=0 只有一个的情况下 ，不需要花钱
           dp[i][j]   = min(  max(dp[i][k-1],dp[i][k],dp[i][k+1]))

         **/
       int dp[][]  = new int[n+1][n+1];
        for (int len = 2; len <=n  ; len++) {
            for (int i = 1; i <= n ; i++) {
                int max =0;
                for (int k = i+1; k < len+i-1; k++) {
                     max =Math.max(dp[i][k-1],dp[k+1][len+i-1])+k;
                }
                dp[i][i+len-1] =Math.min(dp[i+1][i+len-1]+i,dp[i][i+len-2]+i+len-1);
                dp[i][i+len-1] =Math.min(dp[i][i+len-1],max);
            }
        }
        return  dp[1][n];
    }

}
