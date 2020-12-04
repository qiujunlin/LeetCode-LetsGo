package String;

import Tree.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class TEST {

    public static void main(String[] args)
    {
      LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println(new TEST().string2(10,"acesxd"));

    }
    public int string2 (int k, String s) {
        // write code here
        // write code here
        int maxlength=0;
        for(int i=0;i<s.length();i++){
            int length=1;
            int time=k;
            int index=i;
            while(time>0&&index+1<s.length()){
                int c=s.charAt(index+1)-s.charAt(index);
                time=time-c;
                if(time>=0)
                    length++;
                index++;
            }
            while(time==0&&index+1<s.length()&&s.charAt(index)+1==s.charAt(index+1)) length++;
            maxlength=Math.max(maxlength,length);
        }
        return maxlength;
    }
    public int solve (int a, int b, int n) {
        // write code here
        int max=0;
        int i=n;
        while(i<=n){
            if(i%a==b) {
                max=i;
               break;
            }else
            i--;
        }
    return max;
    }
    //int min=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            int res=amount+1;
            for(int j=0;j<coins.length;j++) {
                if (i >= coins[j]) {
                    int a = dp[i - coins[j]];
                    if (a != amount + 1 && res > a) res = a + 1;
                }
            }
            dp[i]=res==amount+1?amount+1:res                    ;
        }

        return dp[amount]==amount+1?-1:dp[amount];
        //return dfs(coins,dp,amount);
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
