package leetcode;

import Contest.week.Node;

public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          if(nums1.length>nums2.length){
              int temp[] = nums1;
              nums1 = nums2;
              nums2 = temp;
          }
          int m  = nums1.length;
          int n = nums2.length;
          int lefttotal = (m+n+1)/2;
          int l = 0;
          int r =  m;
          while (l<r){
              int mid = l + (r-l+1)>>1;
              if(nums1[mid-1]>nums2[ lefttotal-mid]){
                  r = mid-1;
              }else{
                  l = mid;
              }
          }
          // l ==0
          int num1leftmax = l==0?Integer.MIN_VALUE:nums1[l-1];
          int num1rightmax =  l==m?Integer.MIN_VALUE:nums1[l];
          int num2leftmax= lefttotal-l == 0?Integer.MAX_VALUE:nums2[lefttotal-l-1];
          int nums2rightmin = lefttotal-l == n?Integer.MIN_VALUE:nums2[lefttotal-l];
          if((m+n)%2==0){
              return  (Math.max(num1leftmax,num2leftmax)+Math.min(num1rightmax,nums2rightmin))/2;
          }else{
              return  Math.max(num1leftmax,num2leftmax);
          }

    }
}
