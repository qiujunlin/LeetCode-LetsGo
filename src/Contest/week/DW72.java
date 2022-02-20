package Contest.week;

import java.util.ArrayList;
import java.util.List;

public class DW72 {
    public static void main(String[] args) {
        System.out.println("dsa");
    }

    public int countPairs(int[] nums, int k) {
        int res =0;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]==nums[j]){
                    if(i*j%k==0) res++;
                }
            }
        }
        return  res;
    }
    public long[] sumOfThree(long num) {
        long res[] = new long[3];
         long a =  num-3;
         if(a%3==0){
             long c =  a/3;
             return  new long[]{c,c+1,c+2};
         }else{
             return  new long[0];
         }


    }
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long>  res =new ArrayList<>();
        if(finalSum%2==1) return  res;
        long a = 2;
        while (finalSum>0){
             if (finalSum-a<=a) {
                 res.add(finalSum);
                 break;
             }else{
                 res.add(a);
                 finalSum =finalSum-a;
                 a=a+2;

             }
        }
        return  res;



    }

}
