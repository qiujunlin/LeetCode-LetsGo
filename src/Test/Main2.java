package Test;


import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main2   {
    public static void main(String[] args)  {
        StringBuilder s =new StringBuilder("abc");
        System.out.println(s.delete(0,1));

    }

   static void quicsort(int nums[],int l,int r){
        if(l>=r) return;
        int i =part(nums,l,r);
        quicsort(nums,l,i-1);
        quicsort(nums,i+1,r);
    }
    private static  int part(int nums[], int l, int r) {
         int  i =l;
         int left=l;int right =r;
         while (left<right){
             while (right>left&&nums[right]>=nums[i])right--;
             while (right>left&&nums[left]<=nums[i]) left++;
             if(left<right) {
                 int temp = nums[left];
                 nums[left] = nums[right];
                 nums[right] = temp;
             }
         }
        int temp =nums[i];
        nums[i]=nums[right];
        nums[right] =temp;
         return   left;
    }


}

