package Array;

import java.util.*;

/**
 * @Classname SortArrayByParityII922
 * @Description:
 * @Date 2020/11/12 11:43
 * @Created by qiujunlin
 */
public class SortArrayByParityII922 {
    //第一次  击败了百分之30
    public int[] sortArrayByParityII(int[] A) {
        int res[]= new int[A.length];
        int even =0, odd=0;
        for(int i=0;i<A.length;i++){
            while(even<A.length&&A[even]%2!=0) even++;
            res[i++]=A[even++];
            while(odd<A.length&&A[odd]%2==0) odd++;
            res[i]=A[odd++];
        }
        return  res;
    }
    //利用双指针    效率 百分之百
    public int[] sortArrayByParityII2(int[] A) {
        int odd=1;//奇数的下标
        for(int even=0;even<A.length;even+=2){
            if(A[even]%2==1){//even 代表的是偶数坐标  当当前位置不是偶数的时候
                while(A[odd]%2==1) odd+=2;  //  当前位置为奇数  就 继续向下遍历
                int temp =A[even];//交换两个下标 的位置
                A[even]=A[odd];
                A[odd] = temp;
            }
        }
        return A;

    }

    public static void main(String[] args) {
        System.out.println(new SortArrayByParityII922().sortArrayByParityII2(new int[]{4,4,4,4,4,5,5,5,5,5}));
    }
}
