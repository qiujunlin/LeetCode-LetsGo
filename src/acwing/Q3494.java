package acwing;

import java.util.Scanner;

public class Q3494 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int m =scanner.nextInt();
        int k =scanner.nextInt();
        int mod = 1000000007;
        int dp[][][][] = new  int[m+1][1<<n][1<<n][k+1];
        for(int i=1;i<=m;i++){
            for(int a=0;a<(1<<n);a++){
                for(int b=0;b<(1<<n);b++){
                    if(((a&(b>>2))!=0)||(((a>>2)&b)!=0))continue;
                    for(int c = 0;c<(1<<n);c++){
                        if(((c&(b>>2))!=0)||(((c>>2)&b)!=0))continue;
                        if(((a&(c>>1))!=0)||(((a>>1)&c)!=0))continue;
                        int count = Integer.bitCount(c);
                        for(int j=count;j<=k;j++){
                            dp[i][b][c][j] = (dp[i][b][c][j]+dp[i-1][a][b][j-count])%mod;
                        }
                    }
                }
            }
        }
        int res = 0;
        for(int i=0;i<(1<<n);i++){
            for (int j = 0; j < (1<<n); j++) {
              res=(res+ dp[m][i][j][k])%mod;

            }
        }
        System.out.println(res);

    }
}
