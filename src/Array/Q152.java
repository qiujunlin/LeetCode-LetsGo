package Array;
import  java.util.*;
public class Q152 {

    public int maxProduct(int[] nums) {
         int max=1;
         int min =1;
         int res =Integer.MIN_VALUE;
         for(int a:nums){

             int nmax = Math.max(max,Math.max(max*a,min*a));
             int nmin =Math.min(min,Math.min(max*a,min*a));
             max =nmax;
             min =nmin;
             res =Math.max(res,max);
         }
         return  res;
    }
}
