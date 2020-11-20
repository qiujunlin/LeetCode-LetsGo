package dp;

import java.util.*;

/**
 * @Classname FibonacciNumber509
 * @Description:
 * @Date 2020/11/20 10:57
 * @Created by qiujunlin
 */
public class FibonacciNumber509 {
    /**
     * 第一种方法  递归  速度很慢 有很多重复结果 50%
     * @param N
     * @return
     */
    public int fib(int N) {
        if(N==1) return 1;
        if(N==0) return 0;
            // if(N==2||N==1) return 1;
        else return fib(N-1)+fib(N-2);
    }

    /**
     * 动态规划  使用数组
     * @param N
     * @return
     */
    public int fib2(int N) {
        if(N==1) return 1;
        if(N==0) return 0;
        int dp[]= new int[N+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=N;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[N];


    }

    /**
     * 动态规划  没有使用额外的数组空间  速度和第二种方法一样的快
     * @param N
     * @return
     */
    public int fib3(int N) {
        if(N==1) return 1;
        if(N==0) return 0;
        int pre1=0;
        int pre2=1;
        //if(N==1)
        for(int i=2;i<=N;i++){
            int a=pre1+pre2;
            pre1=pre2;
            pre2=a;
        }
        return pre2;


    }
}
