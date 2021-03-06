package Array;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/14
 */
public class FindMinimuminRotatedSortedArray153 {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid= left+(right-left)/2;
            if(nums[mid] > nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];

    }

}
