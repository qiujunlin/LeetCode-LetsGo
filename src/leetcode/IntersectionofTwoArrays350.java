package leetcode;

import java.util.*;

/**
 * @Classname IntersectionofTwoArrays350
 * @Description:
 * @Date 2020/11/7 12:22
 * @Created by qiujunlin
 */
public class IntersectionofTwoArrays350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list  = new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
                continue;
            }else if(nums1[i]>nums2[j]){
                j++;
                continue;
            }else if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int a[]= new int[list.size()];
        int k=0;
        for(Integer c:list){
            a[k++]=c;
        }

        return a;

    }
    //使用map数组
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int a:nums1){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int res[]=new int[1000];
        int index=0;
        for(int a:nums2){
            if(map.containsKey(a)&&map.get(a)!=0){
                res[index++]=a;
                map.put(a,map.get(a)-1);
            }
        }
        return  Arrays.copyOf(res,index);

    }

}
