package Contest.week.T220;

import java.util.*;

/**
 * @Classname MaximumErasureValue5630
 * @Description:
 * @Date 2020/12/20 20:22
 * @Created by qiujunlin
 */
public class MaximumErasureValue5630 {
    public int maximumUniqueSubarray(int[] nums) {
        int pre[]= new int[nums.length];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        int left=0;
        //int right=0;
        int max=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                left=Math.max(left,map.get(nums[i])+1);
            }
            max= Math.max(max,pre[i]-pre[left]+nums[left]);
            map.put(nums[i],i);
        }
        return max;
    }
    int sum(int left,int right,int[] nums){
        int res=0;
        for(int i=left;i<=right;i++){
            res+=nums[i];
        }
        return res;
    }
}
