package math;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/7
 */
public class Sqrtx56 {
    /**
     * 方法一  二分
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long left =0,right=x;
        while(left<right){
            long mid = left + (right - left +1)/2;
            long squre = mid * mid;
            if(squre > x){
                right=mid - 1;
            }else{
                left = mid ;
            }

        }
        return (int)left;
    }


}
