package Array;

import java.util.ArrayList;
import java.util.HashMap;

public class Q1713 {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i],i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
           if(map.containsKey(arr[i])){
               list.add(map.get(arr[i]));
           }
        }
        int arr2[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr2[i] =list.get(i);
        }
        int longest  = lengthOfLIS(arr2);
        return   target.length-longest;

    }
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
