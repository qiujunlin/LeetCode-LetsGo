package Array;

import java.util.*;

/**
 * @Classname NextPermutation31
 * @Description:
 * @Date 2020/11/10 14:18
 * @Created by qiujunlin
 */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index=len-1;
        while(index>0&&nums[index]<=nums[index-1]){
            index--;
        }
        int left=index-1;
        index=len-1;
        if(left>=0){

            while(left<index&&nums[left]>=nums[index]){
                index--;
            }
            int temp=nums[left];
            nums[left]=nums[index];
            nums[index]=temp;
        }
        for(int i=left+1,j=len-1;i<=j;i++,j--){
            int mid=nums[i];
            nums[i]=nums[j];
            nums[j]=mid;
        }
    }

}
