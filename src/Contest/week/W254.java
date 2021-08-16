package Contest.week;

import java.lang.reflect.Array;
import java.util.Arrays;

public class W254 {
    public int numOfStrings(String[] patterns, String word) {
          int res  =0;
          for (String s:patterns){
              if(word.indexOf(s)!=-1) res++;
          }
          return  res;
    }
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int i  =1;
        for (int j = 1; j < nums.length-1; j++) {
            if(nums[j]==(nums[j-1]-nums[j+1])/2&&(nums[j-1]-nums[j+1])%2==0){
                if(j+1==nums.length){
                    swap(nums,j);
                }else{
                    swap(nums,j+1);
                }
            }
        }
        return  nums;
    }

    private void swap(int[] nums, int j) {
        int a = nums[j];
        nums[j]=nums[j+1];
        nums[j+1] = a;
    }
}
