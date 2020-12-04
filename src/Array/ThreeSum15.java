package Array;

import java.util.*;

/**
 * @Classname ThreeSum15
 * @Description:
 * @Date 2020/11/17 19:30
 * @Created by qiujunlin
 */
public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){

            int j=i+1,k=nums.length-1;
            if(nums[i]>0) break;
            if(i>=1&&nums[i]==nums[i-1]) continue;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    while(j<k&&nums[j+1]==nums[j])
                        j++;
                    while(j<k&&nums[k]==nums[k-1])
                        k--;
                    j++;
                    k--;
                }
                else if(nums[j]+nums[k]+nums[i]>0){
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
            }
        }
        return res;
    }
}
