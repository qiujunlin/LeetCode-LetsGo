package Array;

import java.util.Arrays;

public class Q1643 {
    public String kthSmallestPath(int[] destination, int k) {
        char arr[] = new char[destination[0]+destination[1]];
        for (int i = 0; i < destination[0]; i++) {
           arr[i] ='H';
        }
        for (int i = destination[0]; i <destination[0]+destination[1] ; i++) {
            arr[i] ='V';
        }
       int count  = getTime(destination);
        for (int i = 0; i < k/count-1; i++) {
            nextPermutation(arr);
        }
        StringBuffer s  = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
        }
        return  s.toString();

    }

    private int getTime(int[] destination) {
        int i  = destination[0];
        int j  = destination[1];
        int dp[][]=  new int[i][j];
        dp[0][0] =1;
        for (int k = 1; k < i; k++) {
             dp[k][0] =1;
        }
        for (int k = 0; k < j; k++) {
            dp[0][k] =1;
        }
        for (int k = 1; k < i; k++) {
            for (int l = 0; l <j ; l++) {
                dp[k][l] = dp[k-1][l]+dp[k][l-1];
            }
        }
        return  dp[i][j];

    }
        public void nextPermutation(char[] nums) {
            //
            int  i  = nums.length-1;
            while(i-1>=0&&nums[i]<=nums[i-1]) i--;
            int j  =  i-1;
            int k  =nums.length-1;
            if(j>=0){
                while(nums[k]<=nums[j]) k--;
                char temp  = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
            }
            Arrays.sort(nums,i,nums.length);

        }

}
