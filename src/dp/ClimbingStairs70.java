package dp;

import java.util.*;

/**
 * @Classname ClimbingStairs70
 * @Description:
 * @Date 2020/11/29 10:29
 * @Created by qiujunlin
 */
public class ClimbingStairs70 {
    public int climbStairs(int n) {
        //if(n==0) return 1;
        //if(n==1) return 1;
        //  return climbStairs(n-1)+climbStairs(n-2);
        if(n==0) return 1;
        int dp[]= new int[n+1];
        dp[1]=1;
        dp[0]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
