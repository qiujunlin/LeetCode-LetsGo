package leetcode;

import java.util.*;

/**
 * @Classname Q1856
 * @Description:
 * @Date 2021/5/10 21:58
 * @Created by qiujunlin
 */
public class Q1856 {
    public int maxSumMinProduct(int[] nums) {
         int  pre[] = new int[nums.length+1];
         for(int i=0;i<nums.length;i++){
             pre[i+1] = pre[i] +  nums[i];
         }
         //求左边的最小值
        //求右边的最小值
         int left[] = new int[nums.length];Arrays.fill(left,-1);
         int right[] = new int[nums.length];Arrays.fill(right,nums.length);
         Deque<Integer> deque = new LinkedList<>();
         for(int i=0;i<nums.length;i++){
             while (!deque.isEmpty()&&nums[deque.peekLast()]>=nums[i]){
                 deque.pollLast();
                 //left[i] = l;
             }
             if(!deque.isEmpty()){
                 left[i] = deque.peekLast();
             }
             deque.offerLast(i);
         }
         deque.clear();
        for(int i=nums.length-1;i>=0;i--){
            while (!deque.isEmpty()&&nums[deque.peekLast()]>=nums[i]){
                deque.pollLast();
                //left[i] = l;
            }
            if(!deque.isEmpty()){
                right[i] = deque.peekLast();
            }
            deque.offerLast(i);
        }
        int max =0;
        for(int i=0;i<nums.length;i++){
            int l =  left[i];
            int r =  right[i];
            int sum = pre[r]-pre[l+1];
            max =Math.max(sum*nums[i],max);
        }
        return  max;


    }

    public static void main(String[] args) {
        int a [] = new int[]{2,3,3,1,2};
        new Q1856().maxSumMinProduct(a);
    }
}
