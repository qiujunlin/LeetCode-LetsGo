package leetcode;

/**
 * @Classname powxy50
 * @Description:
 * @Date 2020/11/29 9:41
 * @Created by qiujunlin
 */
public class powxy50 {
    public double myPow(double x, int n) {
      //  System.out.println(-2147483648);
        return n>=0?fun(x,n):(1.0/fun(x,-n));
    }
    double fun(double x,long n){
        double res=1;
        while(n>0){
            if((n&1)==1){
                res=res*x;
            }
            x=x*x;
            n= n>>1;

        }
        return res;
    }
   void print(long a){
       System.out.println(a);
   }
    public static void main(String[] args) {
       // System.out.println(new powxy50().myPow(2.000,-2));
      new powxy50().print(-2147483648);
    }
}
