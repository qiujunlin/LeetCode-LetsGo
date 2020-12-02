package String;

import Tree.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class TEST {

    public static void main(String[] args) {

HashMap<String,Integer> map = new HashMap<>();
map.put("a",1);
map.put("b",2);
        System.out.println(map.containsKey("a"));
       // System.out.println(new TEST().Probability(2));
    }
    public String Probability (int n) {
        // write code here
        double x=2.0;
        double res=2/fun(x,n);
        String s = String.format("%.2f", res);
        return s ;

    }
    double fun(double x,long n){
        double res =1;
        while(n>0){
            if((n&1)==1){
                res=res*x;
            }
            n=n>>1;
            x=x*x;
        }

        return res;

    }
    private long mod = 1000000007;
    public long power(int x,long n) {
        if(n == 0){
            return 1;
        }
        long t = power(x,n/2);
        t = (t*t)%mod;
        if(n%2 == 1){
            t = (t*x)%mod;
        }
        return t%mod;
    }
    public int Answerforcn (long n) {
        // write code here
        // Cn = 15Cn-1

        return (int)(power(15,n-1)*14%mod);
    }
    public int Answerforcn2(long n) {
        // write code here
        System.out.println(fiba(n));
        return (int)(fiba(n)*fibb(n)%1000000007);
    }
    public double fiba(long N) {
        if(N==1) return 2;
        if(N==2) return 6;
        // if(N==2||N==1) return 1;
        //
        //    else return fib(N-1)+fib(N-2);
        double pre1=2;
        double pre2=6;
        //if(N==1)
        for(int i=3;i<=N;i++){
            double a=3*pre1%1000000007+2*pre2%1000000007;
            pre1=pre2;
            pre2=a;
        }
        return pre2;
    }
    public double fibb(long N) {
        if(N==1) return 7;
        if(N==2) return 35;
        double pre1=7;
        double pre2=35;
        //if(N==1)
        for(int i=3;i<=N;i++){
            double a=10*pre1%1000000007+3*pre2%1000000007 ;
            pre1=pre2;
            pre2=a;
        }
        return pre2%1000000007;
    }
    long fb(long n){

        if(n==1) return 7;
        if(n==2) return 35;
        return 3*fb(n-1)+10*fb(n-2);
    }
    public int Minimumdays (int n, int[] DEF) {
        // write code here
        Arrays.sort(DEF);
        int day=0;
        // int res=0;
        for(int i=0;i<DEF.length;i++){
            // res++;
            if(day<DEF[i] ){
                while(day<DEF[i]){
                    day++;
                }//day=i
                continue;
            }
            day++;
            // if(day==i)
        }
        return day;
    }
    public long tree4 (long n) {
        long res=0;
        int level=1;
        while(Math.pow(2,level)-1<n){
           level++;
        }

        int i=1;
        int num=1;
        while(i<level){
            for(int j=0;j<num;j++){
                res=res+i*(num+j);
            }
            i++;
            num*=2;
        }
        for(int j=0;j<n-Math.pow(2,level-1)+1;j++){
            res=res+level*(num+j);
        }

        return res%998244353;
    }


}
