package Array;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/11/3
 */
public class ValidMountainArray946 {
    //判断是否是山脉数组，使用 爽 指针
    public boolean validMountainArray(int[] A) {
        if(A.length<3) return false;
        int left=0;
        int right=A.length-1;
        while(left<A.length-1&&A[left]<A[left+1]){
            left++;
        }
        while(right>0&&A[right]<A[right-1]){
            right--;
        }
        return left!=A.length-1&&right!=0&&left==right;
    }
}
