package leetcode;

public class Q1140 {
    int sum[];

    public int stoneGameII(int[] piles) {
        int len = piles.length;
        sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + piles[i];
        }
        int res =  dfs(piles,0,piles.length-1,1);
        return  (sum[len]-res)/2+res;
    }
   // 如果是li  return 最大 dfs 如果是alic return 最大 dfs+sum
    int dfs(int[] piles, int l, int r, int m) {
        if (l == r) return piles[l];
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= 2 * m; i++) {
            if (l + i <= r) {

                max = Math.max(sum[l + i] - sum[l + 1] - dfs(piles, l + i, r, Math.max(m, i)), max);
            }
            if (r - i >= l) {
                max = Math.min(sum[r + 1] - sum[r - i+1] - dfs(piles, l, r - i, Math.max(m, i)), max);
            }
        }
        return max;
    }
}
