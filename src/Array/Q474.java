package Array;

public class Q474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;

        int dp[][][] = new int[len+1][m+1][n+1];
        for(int i=0;i<strs.length;i++){
            int count[] = getoneandzero(strs[i]);

            for(int j = count[0];j<=m;j++){
                for(int k = count[1];k<=n;k++){
                    dp[i][j][k] = dp[i-1][j][k];
                    dp[i][j][k] =Math.max(dp[i-1][j-count[0]][k-count[1]]+1,dp[i][j][k]);
                }
            }
        }
        return  dp[len][m][n];

    }

    private int[] getoneandzero(String str) {
      int res[] = new int[2];
        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i)-'0']++;
        }
        return  res;
    }
}
