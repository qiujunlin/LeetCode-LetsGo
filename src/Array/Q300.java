package Array;

import java.util.ArrayList;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int index  =0;
        for (int i = 0; i < nums.length; i++) {
            if(index==0||nums[i]>dp[index-1]){
                dp[index] = nums[i];
                index++;
            }else{
                int insert = search(0,index-1,dp,nums[i]);
                dp[insert] = nums[i];
            }
        }
        return  index;
    }

    private int search(int i, int i1, int[] dp, int num) {
      int  l = i,r  = i1;
      while (l<r){
          int mid = (l+r)/2;
          if(dp[mid]<num){
              l =mid+1;
          }else{
              r =mid;
          }
      }
      return  l;
    }
}
