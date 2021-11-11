package leetcode;

import java.util.Arrays;

public class Q629 {
    public int kInversePairs(int n, int k) {
        //   dp[i-1][j-(k-1)] k = (0,i-1)
        int mod =1000000007;
        long dp[][] = new long[n+1][k+1];
        long sum[][] =  new long[n+1][k+1];
        dp[1][0] = 1;
        Arrays.fill(sum[1],1);
        for(int i=2;i<=n;i++){
            for(int  j = 0;j<=k;j++){
                dp[i][j] = i>j ? sum[i-1][j]:sum[i-1][j] - sum[i-1][j-(i-1)-1];
                sum[i][j] = j==0?dp[i][j] :  sum[i][j-1]+dp[i][j];
                dp[i][j] %=mod;
                sum[i][j] %=mod;
            }
        }
        CommonUtils.printMartrix(dp);
        CommonUtils.printMartrix(sum);
        return (int)dp[n][k];


    }

    public static void main(String[] args) {
        new Q629().kInversePairs(3,1);
    }
}
