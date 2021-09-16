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
     if((men[l][r])!=Integer.MIN_VALUE) return  men[l][r];
     int ll = piles[l]-dfs(piles,l+1,r,men);
     int rr = piles[r]-dfs(piles,l,r-1,men);
     return  men[l][r] = Math.max(ll,rr);
    }
}
