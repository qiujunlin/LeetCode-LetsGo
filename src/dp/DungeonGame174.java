package dp;

import java.util.*;

/**
 * @Classname DungeonGame174
 * @Description:
 * @Date 2020/12/20 21:12
 * @Created by qiujunlin
 */
public class DungeonGame174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon[0].length;//kuan
        int n = dungeon.length;//gao
        int dp[][]= new int[n][m];
        dp[n-1][m-1]=Math.max(1-dungeon[n-1][m-1],1);
        for(int i=n-2;i>=0;i--)  dp[i][m-1]=Math.max(dp[i+1][m-1]-dungeon[i][m-1],1);
        for(int i=m-2;i>=0;i--) dp[n-1][i]=Math.max(dp[n-1][i+1]-dungeon[n-1][i],1);
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                dp[i][j]=Math.min(Math.max(dp[i+1][j]-dungeon[i][j],1),Math.max(dp[i][j+1]-dungeon[i][j],1));
            }
        }
        return dp[0][0];
    }
}
