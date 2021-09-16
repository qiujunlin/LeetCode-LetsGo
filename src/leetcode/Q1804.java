package leetcode;

import java.util.*;

/**
 * @Classname Q1804
 * @Description:
 * @Date 2021/4/5 23:49
 * @Created by qiujunlin
 */
public class Q1804 {
    public int reinitializePermutation(int n) {
        int s[] = new int[n];
        for(int i=0;i<n;i++) s[i] = i;
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = i;
        int arr2[] = new  int[n];
        int res=0;
        do{
            for(int i=0;i<n;i++) {
                if (i % 2 == 0) arr2[i] = arr[i / 2];
                if (i % 2 == 1) arr2[i] = arr[n / 2 + (i - 1) / 2];
            }
            int temp[] = arr;
            arr = arr2;
            arr2= temp;
            res++;
            }while (!Arrays.equals(arr,s));
return  res;
    }

    public static void main(String[] args) {
        new Q1804().reinitializePermutation(4);
    }
}
