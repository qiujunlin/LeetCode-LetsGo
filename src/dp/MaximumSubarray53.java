package dp;

import java.util.*;

/**
 * @Classname MaximumSubarray53
 * @Description:
 * @Date 2020/11/25 9:09
 * @Created by qiujunlin
 */
public class MaximumSubarray53 {
    int max=Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {

        for(int i=0;i<=nums.length-1;i++){
            int sum=0;
            for(int len=0;len<=nums.length-1&&len+i<nums.length;len++){
                sum=sum+nums[i+len];
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}
