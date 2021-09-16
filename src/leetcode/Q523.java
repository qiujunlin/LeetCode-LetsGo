package leetcode;

import java.util.HashMap;

public class Q523   {
    public boolean checkSubarraySum(int[] nums, int k) {
        //HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
       // int pre[] = new  int[len+1];
        int pre  =0;
        //set.add(0);
        map.put(0,-1);
        for(int i=0;i<len;i++){
            pre = nums[i]+pre;
            int count =  pre/k;
            for(int j=1;j<=count;j++){
                if(map.containsKey(pre-count*k)){
                    if(i-map.get(pre-count*k)>=2) return  true;
                }
            }
            map.put(pre,i);

        }
        return  false;

    }
}
