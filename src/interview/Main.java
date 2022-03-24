package interview;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();
        char ch[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            ch[i] = s.toCharArray();
        }
        int dp[][] = new int[n + 2][m + 2];
        while (q > 0) {
            int x1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int y2 = scanner.nextInt();
            insert(x1, x2, y1, y2, dp);
            q--;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] % 2 == 1) {
                    if (ch[i - 1][j - 1] >= 'a' && ch[i - 1][j - 1] <= 'z') {
                        ch[i - 1][j - 1] = Character.toUpperCase(ch[i - 1][j - 1]);
                    } else {
                        ch[i - 1][j - 1] = Character.toLowerCase(ch[i - 1][j - 1]);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(new String(ch[i]));
        }
    }

    static void insert(int x1, int y1, int x2, int y2, int dp[][]) {
        dp[x1][y1] += 1;
        dp[x1][y2 + 1] -= 1;
        dp[x2 + 1][y1] -= 1;
        dp[x2 + 1][y2 + 1] += 1;
    }
}