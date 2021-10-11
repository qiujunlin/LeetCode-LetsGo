package leetcode;

import java.util.Arrays;

public class Q322 {
    public int coinChange(int[] coins, int amount) {
            int dp[] = new int[amount+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] =1;
            for (int i = 0; i <coins.length ; i++) {
                for (int j = 0; j <amount ; j++) {
                    if(j>=coins[i]){
                        dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                    }
                }
            }
            return  dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

}
