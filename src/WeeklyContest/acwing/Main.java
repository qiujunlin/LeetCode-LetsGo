package WeeklyContest.acwing;

import java.util.*;

/**
 * @Classname Main
 * @Description:
 * @Date 2021/5/5 21:53
 * @Created by qiujunlin
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N=  scanner.nextLong();
        long k =scanner.nextLong();
        long pre[]=  new long[(int) (N+1)];
        long dp []= new long[(int) k];
        long res =0;
        for(int i=0;i<N;i++){
            long num =  scanner.nextLong();
            pre[i+1]= pre[i]+num;
            res+=dp[(int) (pre[i+1]%k)];
            dp[(int) (pre[i+1]%k)]++;
        }
        System.out.println(res+dp[0]);

    }
}
