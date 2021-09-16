package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Gongyueshu {
    public static void main(String[] args) {
       // Integer a = Integer.valueOf(args[0]);
  int a   =  378000;
       prims(a);

    }

    /**
     * 最小公倍数 =  x*y /  最大公约数
     */
    //递归写法
    int gcd(int a, int b){return b == 0 ? a: gcd(b, a%b);}
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
    static  void prims(int num){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i=2;i*i<=num;i++){
            if(num%i==0){
                list1.add(i);
                int count =0;
                while (num%i==0){
                    num=num/i;
                    count++;
                }
                list2.add(count);
            }
        }
        if(num>1) {
            list1.add(num);
            list2.add(1);
        }
        System.out.println(list1);
        System.out.println(list2);
        int sum = 1;
        for(int c:list2){
            sum*=(c+1);
            //sum+=1;
        }
        System.out.println(sum);
  }
}
