package leetcode;

import java.util.*;

/**
 * @Classname FourPathSum18
 * @Description:
 * @Date 2020/11/17 21:18
 * @Created by qiujunlin
 */
public class  FourPathSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++){
            //if(nums[i]>target) break;
            if(i>=1&&nums[i]==nums[i-1]) continue;
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
            if(max1<target){
                continue;
            }

            for(int h=i+1;h<nums.length;h++){
                // if(nums[i]+nums[h]<target) break;
                if(h>i+1&&nums[h]==nums[h-1]) continue;
                int j=h+1,k=nums.length-1;
                while(j<k){
                    if(nums[i]+nums[j]+nums[k]+nums[h]==target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[h]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        // if(k<nums.length-1&&nums[j-1]==nums[j]&&nums[k]==nums[k+1])continue;
                        res.add(list);
                        while(j<k&&nums[j+1]==nums[j])
                            j++;
                        while(j<k&&nums[k]==nums[k-1])
                            k--;
                        j++;
                        k--;
                    }
                    else if(nums[j]+nums[k]+nums[i]+nums[h]>target){
                        k--;
                    }
                    else if(nums[i]+nums[j]+nums[k]+nums[h]<target){
                        j++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a[]={1,-2,-5,-4,-3,3,3,5};
        System.out.println(new FourPathSum18().fourSum(a,-11));
    }
}
