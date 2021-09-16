package leetcode;

import java.util.*;

/**
 * @Classname IntersectionofTwoArrays349
 * @Description:
 * @Date 2020/11/2 11:08
 * @Created by qiujunlin
 */
public class IntersectionofTwoArrays349 {
    //使用双指针
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
                continue;
            }else if(nums1[i]>nums2[j]){
                j++;
                continue;
            }else if(nums1[i]==nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }


        }

        int a[]= new int[set.size()];
        int k=0;
        for(Integer c:set){
            a[k++]=c;
        }

        return a;


    }
}
