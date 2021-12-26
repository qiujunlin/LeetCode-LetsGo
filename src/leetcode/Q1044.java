package leetcode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Q1044 {
    long mod1  = longRandomPrime();
    long mod2  = longRandomPrime();
    long r1  ;
    long r2  ;
    public String longestDupSubstring(String s) {
        Random random =  new Random();
        r1 = random.nextInt(75) + 26;
        r2 = random.nextInt(75) + 26;
          int l = 0;int r  = s.length();
          String  res ="";
          while (l<r){
              int mid  = (l+r+1)/2;
              String temp = check(s,mid);
              if(temp.length()!=0){
                  l  =mid;
                  res=temp;

              }else{
                  r =mid-1;
              }
          }
          return  res;
    }
    private String check(String s, int mid) {
        long rm1  =1; //需要减去的数字
        long rm2  =1;
        for (int i = 0; i <mid-1;  i++) {
            rm1 =(rm1*r1)%mod1;
            rm2 =(rm2*r2)%mod2;
        }
        long num1 = 0;
        long num2 = 0;
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i <mid ; i++) {
             num1  = num1*r1 + s.charAt(i)%mod1;
             num2  = num2*r2 + s.charAt(i)%mod2;
        }
        set.add(num1*mod2 +num2);
        for (int i = mid; i < s.length(); i++) {
               num1 = (num1+mod1- rm1*s.charAt(i-mid))%mod1;
               num2 = (num2+mod2- rm2*s.charAt(i-mid))%mod2;
               num1 =(num1 *rm1 + s.charAt(i))%mod1;
               num2 =(num2 *rm2 + s.charAt(i))%mod2;
               if(set.contains(num1*mod2+num2)) return  s.substring(i-mid+1,i+1);
               else set.add(num1*mod2+num2);
        }
        return  "";

    }

    private  long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }


}
