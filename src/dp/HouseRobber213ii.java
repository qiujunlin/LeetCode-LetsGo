package dp;

import java.util.*;

/**
 * @Classname HouseRobber213ii
 * @Description:
 * @Date 2020/11/29 11:19
 * @Created by qiujunlin
 */
public class HouseRobber213ii {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);      return Math.max(max(Arrays.copyOfRange(nums,0,nums.length-1)),max(Arrays.copyOfRange(nums,1,nums.length)));

    }

    int  max(int[] nums){
        int dp[]= new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
