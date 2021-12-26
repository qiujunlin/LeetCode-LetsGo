package template;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {
      long  mod  = longRandomPrime();
      long  r  =  256;
      public int rk(String  str ,String pattern){
       int len = pattern.length();
       long phash = hash(pattern,len);
       long shash =  hash(str,len);
       //计算rm
          long rm  =  1;
          for (int i = 0; i <len-1 ; i++) {
                rm  = (rm*r)%mod;
          }
          //1
          if(phash==shash) return   0;
          for (int i = len; i < str.length()  ; i++) {
              shash =  (shash +r -  rm*str.charAt(i-len)%mod );
              shash = (shash*r + str.charAt(i))%mod;
             if(shash == phash) return  i-len+1;
          }
          return  0;
      }
      private  long hash(String s  ,int len){
          long res  =0;
          for (int i = 0; i < len ; i++) {
              res = (res*r +s.charAt(i))%mod;
          }
          return  res;
      }
    private  long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {

        }
    }



}
