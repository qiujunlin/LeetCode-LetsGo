package Test;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        long s =System.currentTimeMillis();
        System.out.println(gcd(2,4));
        long e =System.currentTimeMillis();
        System.out.println("time: "+(e-s));
    }
 public  static  int gcd(int a,int b) {
        return b==0?a:gcd(b,a%b);
 }


}
