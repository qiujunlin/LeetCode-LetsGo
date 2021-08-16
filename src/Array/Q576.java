package Array;

public class Q576 {
     int m  ;
     int n ;
     int mod  = 1000000007;
     int res  = 0;
     int mem[][][];
     int dirt[][]=  {{1,0},{-1,0},{0,1},{0,-1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
         this.m = m;
         this.n = n;
         mem   =  new int[m][n][maxMove];
         return  0;

    }
    int dfs(int i,int j ,int moveCount){
        if(moveCount==0) return  0;
        int  count  =0;
        if(mem[i][j][moveCount]!=0) return  mem[i][j][moveCount];
        for (int k = 0; k < 4;k++) {
           int x = i + dirt[k][0];
           int y = j + dirt[k][1];
           if(x==0||x==m-1||y==0||y==n-1){
               count++;
           }else{
               count=  (count+   dfs(x,y,moveCount-1))%mod;
           }
        }
        return mem[i][j][moveCount] = count;
    }
}
