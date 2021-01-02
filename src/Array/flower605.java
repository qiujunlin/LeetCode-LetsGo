package Array;

import java.util.*;

/**
 * @Classname flower605
 * @Description:
 * @Date 2021/1/1 20:58
 * @Created by qiujunlin
 */
public class flower605 {
    public static void main(String[] args) {
        System.out.println(new flower605().canPlaceFlowers(new int[]{1,0,0,0,1},1));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int res=0,j=flowerbed.length-1, count=0,i=0;
        while(i<flowerbed.length&&flowerbed[i]==0){
            count++;
            i++;
        }
      //  System.out.println(count);
        res+=count/2;
        count=0;
        while(j>=0&&flowerbed[j]==0){
            count++;
            j--;
        }
       // System.out.println(count);
        res+=count/2;
        for(;i<=j;i++){
            count=0;
            while(i<j&&flowerbed[i]==0){
                count++;i++;
            }
           // System.out.println(count);
           // System.out.println((count&1)==1?count/2:(count/2-1));
            if(count!=0)
            res=res+((count&1)==1?count/2:(count/2-1));
        }
        System.out.println(res);
        return res==n;
    }
}
