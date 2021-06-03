package acwing;

import java.util.Scanner;

public class Q2560 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int nums[] = new int[40];
        int idx = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (check(i)) {
                nums[idx] = i;
                idx++;
            }
        }
        // 第一个表示列  第二个表示 前一个状态  第三个表示前两个状态
        int dp[][][] = new int[m+1][idx][idx];
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < idx; j++) {
                dp[2][i][j]=1;

            }
        }
        for (int i = 3; i <= m; i++) {
            for (int j = 0; j < idx; j++) {
                for (int k = 0; k < idx; k++) {
                    for (int l = 0; l < idx; l++) {
                        if((nums[j]&nums[i]&nums[j])==0){
                            dp[i][l][k] += dp[i-1][k][j];
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < idx; j++) {
                res+=dp[m][i][j];
            }
        }
        if(m==1) res=idx;
        //for()
        System.out.println(res);

    }

    private static boolean check(int n) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (((n >> i) & 1) == 1) count++;
        }
        return count == 3;
    }
}
