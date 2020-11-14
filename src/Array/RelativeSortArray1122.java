package Array;

import java.util.*;

/**
 * @Classname RelativeSortArray1122
 * @Description:
 * @Date 2020/11/14 13:53
 * @Created by qiujunlin
 */
public class RelativeSortArray1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int hash[]= new int [1001];
        for(int i =0;i<hash.length;i++){
            hash[i]=-1;
        }
        for(int i =0;i<arr1.length;i++){
            hash[arr1[i]]++;
        }
        int  res[] = new int[arr1.length];
        int index =0;
        for(int i=0;i<arr2.length;i++){
            while(hash[arr2[i]]>-1) {
                res[index++]=arr2[i];
                hash[arr2[i]]--;
            }
        }
        for(int i=0;i<hash.length;i++){
            if(hash[i]>-1) res[index++]=i;
        }
        return res;
    }

    //第二种方法  不使用list   速度百分之百 但是额外空间 百分之五十
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int hash[]= new int [1001];
        for(int i =0;i<hash.length;i++){
            hash[i]=-1;
        }
        for(int i =0;i<arr1.length;i++){
            hash[arr1[i]]++;
        }
        int  res[] = new int[arr1.length];
        int index =0;
        for(int i=0;i<arr2.length;i++){
            while(hash[arr2[i]]>-1) {
                res[index++]=arr2[i];
                hash[arr2[i]]--;
            }
        }
        for(int i=0;i<hash.length;i++){
            while(hash[i]>-1) {
                res[index++]=i;
                hash[i]--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int a[]={2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int b[]={2,42,38,0,43,21};
        int c[]= new RelativeSortArray1122().relativeSortArray(a,b);
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+" ");
        }
    }
}
