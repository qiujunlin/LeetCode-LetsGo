package leetcode;

public class Q1219 {
    int dirt[][]=  {{0,1},{0,-1},{-1,0},{1,0}};
    int max = 0;
    int m =0;
    int n ;
    boolean vis[][];
    int men[][];
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis= new boolean[m][n];
        men = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[j][i]= true;
                dfs(grid,i,j,0);
               vis[i][j]= false;
            }
        }
        return  max;
    }

    private void dfs(int[][] grid, int i, int j, int sum) {
        // if(grid[i][j]==0
        max =Math.max(sum,max);
        int newx =0;
        int newy =0;
       // int max =0;
        for (int k = 0; k < 4; k++) {
            newx = i+dirt[i][0];
            newy = j+dirt[i][1];
            if(newx>=0&&newy>=0&&newx<=m-1&&newy<=n-1&&grid[newx][newy]!=0&&!vis[newx][newy]){
                vis[newx][newy]= true;
                dfs(grid,newx,newy,grid[newx][newy]+sum);
                vis[newx][newy]= false;
            }
        }
    }
}
