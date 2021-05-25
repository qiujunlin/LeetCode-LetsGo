package Array;

import java.util.*;

/**
 * @Classname Q1787
 * @Description:
 * @Date 2021/5/25 19:55
 * @Created by qiujunlin
 */
public class Q1787 {
    public int minChanges(int[] nums, int k) {
        int max = 1024;
        int dp[][] = new int[k][max];
        int pre[] = new int[k];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Arrays.fill(pre, Integer.MAX_VALUE);
        for (int i = 0; i < k; i++) {
            int cnt =0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j =i;j<nums.length;j+=k){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            cnt ++;
            }
            if(i==0){
               for(int xor =0;xor<max;xor++){
                   dp[i][xor] = Math.min(dp[i][xor],cnt - map.getOrDefault(xor, 0));
                   pre[i] =Math.min(pre[0],dp[i][xor]);
               }
            }else{
                for(int xor =0;xor<max;xor++){
                    dp[i][xor] = pre[i - 1] + cnt;
                    for(int a:map.keySet()) {
                        dp[i][xor] =Math.min(dp[i][xor], dp[i - 1][xor ^ a] + cnt - map.get(a));
                    }
                    pre[i] =Math.min(dp[i][xor],pre[i]);
                }

            }


        }
        return  dp[k-1][0];
    }
}
