package template;

import java.util.*;

/**
 * @Classname BinarySearch
 * @Description:
 * @Date 2021/1/1 23:08
 * @Created by qiujunlin
 */
public class BinarySearch {
    public static void main(String[] args) {
      int a[]=new int[]{1,2,3,5,6};
        System.out.println(new BinarySearch().binarysearch3(a,4));
    }
    //寻找第一个等于的数
    int binarysearch1(int []nums,int target){
        int left=0;int right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target) left=mid+1;
            else  right=mid;
        }
        return  left;
    }
    //寻找最后一个等于target的数
    int binarysearch2(int []nums,int target){
        int left=0;int right=nums.length-1;
        while(left<right){
            int mid = left+(right-left+1)/2;
            if(nums[mid]>target) right=mid-1;
            else  left=mid;
        }
        return  left;
    }
    //寻找第一个大于target的数
    int binarysearch3(int []nums,int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
