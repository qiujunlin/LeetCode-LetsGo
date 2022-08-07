import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    int a =  new Main().solution("...XXXX",4);
        System.out.println(a);

    }
    public int solution(String S, int B) {
        // write your code in Java 8 (Java SE 8)
          PriorityQueue<Integer> q  =new PriorityQueue<>((a,b)->b-a);
          int c =0;
          for (int i = 0; i <S.length() ; i++) {
            if(S.charAt(i)=='X') c++;
            else{
                if(c!=0) q.offer(c);
                c =0;
            }
        }
        if(c!=0) q.offer(c);
       // System.out.println(q);
          int res =0;
          while (B>0&&!q.isEmpty()){
              int a =q.poll();
              if(a+1<=B){
                  res+=a;
                  B-=(a+1);
              }else{
                  res+=B-1;
                  B =0;
              }
            //  System.out.println(B);
          }
          return  res;

    }

}
