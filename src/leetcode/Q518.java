package leetcode;

import java.util.Arrays;

public class Q518 {
    public int change(int amount, int[] coins) {

   int dp[] = new int[amount+1];
        dp[0] =1;
        for (int i = 0; i <coins.length ; i++) {
            for (int j = 0; j <=amount ; j++) {
                if(amount>=coins[i]){
                    dp[j] +=dp[j-coins[i]];
                }
            }
        }
        return  dp[amount];
    }
}
