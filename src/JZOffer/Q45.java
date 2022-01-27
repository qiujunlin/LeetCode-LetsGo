package JZOffer;

import java.util.Arrays;

public class Q45 {
    public String minNumber(int[] _nums) {
        Integer[] nums =new Integer[_nums.length];
        for(int i=0;i<nums.length;i++) nums[i] =  _nums[i];
        Arrays.sort(nums,(a, b)->{
            String s1 =String.valueOf(a);
            String s2 =String.valueOf(b);
            return (s1+s2).compareTo(s2+s1);
        });
        String res ="";
        for(int a: nums) {
            res += String.valueOf(a);
        }
        return res;

    }
}
