package leetcode;

import java.util.HashMap;

public class Q2025 {
    public int waysToPartition(int[] nums, int k) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int presum[] = new int[nums.length+1];
        for (int i = 0; i <nums.length ; i++) {
            presum[i+1] = presum[i] +nums[i];
            map2.put(presum[i+1],map2.getOrDefault(presum[i+1],0)+1);
        }
        int total = presum[nums.length];
        int res  = 0;
        if(total%2==0) res = map2.get(total/2);
        for (int i = 0; i <nums.length ; i++) {
            int a = presum[i+1];
            int cha =  k-nums[i];
            int to = total+cha;
            if(to%2==0) {
                res = Math.max(res, map1.getOrDefault(to/2,0)+map2.getOrDefault(to/2-k,0));
            }
            map1.put(a,map1.getOrDefault(a,0)+1);
            map2.put(a,map2.get(a)-1);
            if(map2.get(a)==0) map2.remove(a);
        }
        return  res;
    }
}
