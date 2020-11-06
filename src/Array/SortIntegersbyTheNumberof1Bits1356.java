package Array;

import java.util.*;

/**
 * @Classname SortIntegersbyTheNumberof1Bits1356
 * @Description:
 * @Date 2020/11/6 12:19
 * @Created by qiujunlin
 */
public class SortIntegersbyTheNumberof1Bits1356 {
    //第一次代码
    public int[] sortByBits(int[] arr) {

        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums,(Integer a,Integer b)->{
            int res1=cout(a);
            int res12=cout(b);
            return res1==res12?a-b:res1-res12;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
    int cout(int n){
        int res=0;
        while(n!=0){
            if(n%2==1) res++;
            n = n/2;
        }
        return   res;
    }
}
