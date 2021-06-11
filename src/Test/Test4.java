package Test;

import javax.jws.soap.SOAPBinding;
import java.math.BigInteger;
import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("FF",16));
        BigInteger bigInteger = new BigInteger("FF",16);
        System.out.println(bigInteger.toString(2));
        System.out.println(Integer.parseInt("1001110011100100001",2));
        System.out.println(Integer.toString(321313,2));
    }
 public  static  int gcd(int a,int b) {
        return b==0?a:gcd(b,a%b);
 }


}
