package Al4;

import java.math.BigInteger;
import java.util.*;

/**
 * @Classname Q483
 * @Description:
 * @Date 2021/5/2 23:09
 * @Created by qiujunlin
 */
public class Q483 {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("1000000000000000000");
        BigInteger bigInteger2 = new BigInteger("999999999999999999");
        //System.out.println(new Q483().get(bigInteger,bigInteger2));
        System.out.println(new Q483().smallestGoodBase("10000000"));
    }
    public String smallestGoodBase(String n) {
        BigInteger num = new BigInteger(n);
        BigInteger a = new BigInteger("2");
        while (a.compareTo(num)<0){
             boolean s = get(new BigInteger(n),a);
             if(s) return  a.toString();
             a=a.add(new BigInteger("1"));
           // System.out.println(a.toString());
        }
        return  "0";
    }

    private boolean get(BigInteger num, BigInteger a) {
        BigInteger temp = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        //BigInteger res= new BigInteger();
        while (num.compareTo(temp)!=0){
            BigInteger bis[]= num.divideAndRemainder(a);
            if(bis[1].compareTo(one)!=0) return  false;
           // System.out.println(bis[1]);
            num = bis[0];
        }
        return true;
    }
}
