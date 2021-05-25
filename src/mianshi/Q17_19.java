package mianshi;

import java.util.ArrayList;
import java.util.HashSet;

public class Q17_19 {
    public int[] missingTwo(int[] nums) {
        int res[]  = new int[2];
        int len =  nums.length;
        HashSet<Integer> set = new HashSet<>();
        set.add(len+1);
        set.add(len+2);
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i+1){
                if(nums[i]>len){
                    set.remove(nums[i]);
                    break;
                }
                else{
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) set.add(i+1);
        }
        int index =0;
        for(int a: set) res[index++] =a;
        return  res;
    }

    public static void main(String[] args) {
        int a[] =new int[]{2,3};
        new Q17_19().missingTwo(a);
    }
}
