package leetcode;

public class Q329 {
    int matrix[][] ;
    int m ;
    int n ;
    int men[][];
    boolean vis[][];
    int direct[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        this.m =matrix.length;this.n =matrix[0].length;
        this.matrix = matrix;this.men = new int[m][n];vis = new boolean[m][n];
        int res =0;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j]= true;
                res= Math.max(res,dfs(i,j));
                vis[i][j]= false;
            }
        }
        return  res;

    }
    int  dfs(int i,int j){
        if(men[i][j]!=0) return men[i][j];
        int max  =1 ;
        for (int k = 0; k < 4; k++) {
             int newx = i+direct[k][0];
             int newy = j+direct[k][1];
             if(newx>=0&&newy>=0&&newx<m&&newy<n&&!vis[newx][newy]&&matrix[newx][newy]>matrix[i][j]){
                 vis[newy][newy] = true;
                 max =Math.max(max,dfs(newx,newy)+1);
                 vis[newy][newy] = false;
             }
        }
        return  men[i][j] =max;
    }

}
