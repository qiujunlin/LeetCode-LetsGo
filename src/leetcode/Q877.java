package leetcode;

import java.util.Arrays;

public class Q877 {
    public boolean stoneGame(int[] piles) {
        int  len = piles.length;
        int men[][]=  new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(men[i],Integer.MIN_VALUE);
        }
       return dfs(piles,0,len-1,men)>0;
    }

    private int dfs(int[] piles, int l, int r, int[][] men) {
     if(l==r) return piles[l];
    // if((men[l][r])!=Integer.MIN_VALUE) return  men[l][r];
     int ll = piles[l]-dfs(piles,l+1,r,men);
     int rr = piles[r]-dfs(piles,l,r-1,men);
     return  men[l][r] = Math.max(ll,rr);
    }

    public boolean stoneGame2(int[] piles) {
        // dp[i][j] 表示 i到j 能够取得的最好分数  不管谁是先手
        //  dp[i][j] = Math.max(piles[i]-dp[i+1][j],piles[j] - dp[i][j-1])1. 取左边  d
        int  len = piles.length;
        int dp[][] = new int[len+1][len+1];
        for(int L=1;L<=len;L++){
            for(int i =1;i<=len;i++){
                int j = i+L-1;
                // 如果右边界越界，就可以退出当前循环
                if (j > len) {
                    break;
                }
                dp[i][j] =  Math.max(piles[i]-dp[i+1][j],piles[j] - dp[i][j-1]);
            }
        }
        CommonUtils.printMartrix(dp);
        return  dp[0][len-1]>0;
    }

    public static void main(String[] args) {
        int a[] = {5,3,4,5};
        new Q877().stoneGame2(a);
    }
}
