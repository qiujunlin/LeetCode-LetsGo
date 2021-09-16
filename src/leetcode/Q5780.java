package leetcode;

import java.util.*;

/**
 * @Classname Q5780
 * @Description:
 * @Date 2021/4/4 23:03
 * @Created by qiujunlin
 */
public class Q5780 {
    int mod = (int) (1e9+7);
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0;i<nums.length;i++){
            int sum = nums[i]-reverse(nums[i]);
            res=(res+map.getOrDefault(sum,0))%mod;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return  res;
    }

    int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }
}

