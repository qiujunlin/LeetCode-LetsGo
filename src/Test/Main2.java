package Test;


import java.util.*;

public class Main2   {
    public static void main(String[] args)  {
  ArrayList<Integer> l =new ArrayList<>();
  int a[] = {1,2,3,4,5,6,7};
  int b[] = new int[a.length];
  int i=0;
  int j=0;
        //Arrays.copyOf;
        for (int k = 0; k < a.length; k++) {
            b[i++] =a[j++];
        }
        for (int k = 0; k <b.length ; k++) {
            System.out.print(b[k] +" ");
        }
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

