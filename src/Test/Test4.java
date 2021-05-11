package Test;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        System.out.println(Integer.bitCount(1111111111));
        long s =System.currentTimeMillis();
        gcd(10,20);
        long e =System.currentTimeMillis();
        System.out.println("time: "+(e-s));
    }
 public  static  int gcd(int a,int b) {
        return b==0?a:gcd(b,a%b);
 }


}
