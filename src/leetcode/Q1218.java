package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q1218 {
    public int longestSubsequence(int[] arr, int difference) {
        //HashMap<Integer,HashMap<Integer,Integer>>  map =new HashMap<>();
        HashMap<Integer,Integer> map =new HashMap<>();
        int dp[] =new int[arr.length];
        Arrays.fill(dp,1);
       // ArrayList<Integer> list =new ArrayList<>();
        for (int i = 1; i <arr.length ; i++) {
                //if()
                if(!map.containsKey(i-difference)){
                    map.put(arr[i],1);
                }else{
                    map.put(arr[i],map.get(i-difference)+1);
                }
        }
        int res =0;
        for(int a:map.keySet()) res =Math.max(res,map.get(a));
        return  res;
    }
}
