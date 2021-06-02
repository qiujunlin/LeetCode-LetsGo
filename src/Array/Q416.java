package Array;

import java.util.Arrays;

public class Q416 {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int n:nums)sum+=n;
        if(sum%2!=0) return  false;
        boolean dp[] =new boolean   [sum/2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=sum/2;j>=nums[i];j--){
                dp[j] =Math.max(dp[j-nums[i]],dp[j]);
            }
        }
        return  dp

    }
}
