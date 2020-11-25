package dp;

import java.util.*;

/**
 * @Classname CoinChange322
 * @Description:
 * @Date 2020/11/20 11:03
 * @Created by qiujunlin
 */
public class CoinChange322 {
    int dp[];
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount+1];
        return dfs(coins,amount);
        //return [amount];
    }
    int dfs(int []coins,int amount){
        //返回条件
        if(amount==0) return 0;
        if(amount<0) return -1;
        if(dp[amount]!=0) return dp[amount];
        int  min=Integer.MAX_VALUE;
        for(int a:coins){
            int res=dfs(coins,amount-a);
            if(res==-1) continue;
            min=Math.min(min,res+1);
        }
        dp[amount]=min==Integer.MAX_VALUE?-1:min;
        return dp[amount];
    }
  //  int dp[];
    public int coinChange2(int[] coins, int amount) {
        dp=new int[amount+1];
        //     return dfs(coins,amount);
        //return [amount];
        for(int i=1;i<amount+1;i++)dp[i]=Integer.MAX_VALUE-1;
        dp[0]=0;
        for(int i=1;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]<0) continue;
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount]==Integer.MAX_VALUE-1?-1:dp[amount];
    }

}
