package math;

import java.util.ArrayList;
import java.util.List;

public class Gongyueshu {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(args[0]);
        System.out.println(new Gongyueshu().getPrime(a));

    }

    /**
     * 最小公倍数 =  x*y /  最大公约数
     * @param x
     * @param y
     * @return
     */
 public int LCM(int x ,int y){
        return  x*y/GCD(x,y);
 }
   //辗转相除法
    public int GCD(int x,int y){
        int a = Math.min(x,y);
        int b = Math.max(x,y);
        while (b%a!=0){
            int c = b%a;
            b = a;
            a = c;
        }
        return  a;
    }
    //更相减损术
    public int GCD2(int x,int y){
        int a = Math.min(x,y);
        int b = Math.max(x,y);
        int temp =1;
        while (a%2==0&&b%2==0){
            a=a/2;
            b=b/2;
            temp*=2;
        }
        while (a!=b){
            int c = b-a;
            if(c>a){
                b =c;
            }else{
                b=a;
                a=c;
            }
        }
        return  a*temp;
    }
    //判断质数
    public  boolean judge(int num){
     for(int i=2;i<=Math.sqrt(num);i++){
         if(num%i==0) return  false;
     }
     return  true;
    }
    //分解质因数 https://www.cnblogs.com/youxin/p/3232049.html
    List<Integer> getPrime(int num){
      List<Integer> list = new ArrayList<>();
      for(int i=2;i<=num;i++){
          while (i!=num){
              if(num%i!=0){
                  break;
              }
              list.add(i);
              num=num/i;
          }
      }
      list.add(num);
      return  list;
    }

}
