package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
          int len  = nums.length;
          Arrays.sort(nums);
          int dp[] = new int[len+1];
        Arrays.fill(dp,1);
          int pre [] = new int[len];
          Arrays.fill(dp,-1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <i ; j++) {
                 if(nums[i]%nums[j]==0) {
                     if(dp[i]<dp[j]+1){
                         dp[i] =dp[j]+1;
                         pre[i] = j;
                     }
                 }
            }
        }
        int max =0;int maxindex =0;
        for (int i = 0; i <len ; i++) {
            if(dp[i]>max){
                max =dp[i];
                maxindex =  i;
            }
        }
        ArrayList<Integer> res =new ArrayList<>();
        while (maxindex!=-1){
            res.add(nums[maxindex]);
            maxindex =  pre[maxindex];
        }
        return  res;

    }
}

