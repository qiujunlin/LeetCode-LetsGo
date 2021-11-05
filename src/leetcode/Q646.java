package leetcode;

import java.util.Arrays;

public class Q646 {
    public int findLongestChain(int[][] pairs) {
        //
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int dp[] = new int[pairs.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j <i ; j++) {
                if(pairs[i][0]>pairs[j][1]) {
                    dp[i] =Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res =0;for(int a:dp ) res =Math.max(res,a);
        return  res;

    }
}
