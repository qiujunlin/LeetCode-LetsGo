package Array;

import java.util.*;

/**
 * @Classname Q1035
 * @Description:
 * @Date 2021/5/21 20:24
 * @Created by qiujunlin
 */
public class Q1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int dp[][] = new int[len1+1][len2+1];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(nums1[i]==nums2[j])
                    dp[i+1][j+1] = dp[i][j]+1;
                else dp[i+1][j+1] =Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }
 return dp[len1][len2];
    }
}
