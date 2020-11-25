package dp;

import java.util.*;

/**
 * @Classname UniquePathsII63
 * @Description:
 * @Date 2020/11/25 9:05
 * @Created by qiujunlin
 */
public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]= new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<m;i++) {
            if(obstacleGrid[i][0]==1) {
                dp[i][0]=0;
                break;
            }else{
                dp[i][0]=1;
            }
        }
        // int dp[][]= new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<n;i++) {
            if(obstacleGrid[0][i]==1) {
                dp[0][i]=0;
                break;
            }else{
                dp[0][i]=1;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}
