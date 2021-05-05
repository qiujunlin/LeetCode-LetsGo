package acwing;

import java.util.*;

/**
 * @Classname Main
 * @Description:
 * @Date 2021/5/5 1:57
 * @Created by qiujunlin
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int num[] = new int[n+1];
        int w[] =new int[n+1];
        for(int i=1;i<=n;i++){
            num[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        int dp[]= new int[n+1];
        for(int i=1;i<=n;i++){
            for (int j=m;j>=num[i];j--){
                dp[j] =Math.max(dp[j],dp[j-num[i]]+w[i]);
            }
        }
        int res =0;
        for(int a:dp) res=Math.max(res,a);
        System.out.println(res);
    }
}
