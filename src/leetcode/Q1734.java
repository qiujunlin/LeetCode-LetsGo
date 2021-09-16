package leetcode;

/**
 * @Classname Q1734
 * @Description:
 * @Date 2021/5/11 0:02
 * @Created by qiujunlin
 * 1 ^2 2^3 3^4 4 ^5
 */
public class Q1734 {
    public int[] decode(int[] encoded) {
         int res[] = new  int[encoded.length];
         int a =0;
         for(int i=1;i<encoded.length;i+=2){
             a=a^encoded[i];
         }
         for(int i=1;i<=encoded.length+1;i++) a=a^i;
         res[0] =a;
         for(int i=1;i<res.length;i++){
             res[i]=res[i-1]^encoded[i-1];
         }
         return  res;
    }
}
