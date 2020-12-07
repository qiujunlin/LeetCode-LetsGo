package dp;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/7
 */
public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        int dp[]= new int[nums.length+1];
        dp[0]=1;
        int max=1;
        for(int  i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
}
