package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1020 {
    boolean vis[][];
    boolean can[][];
    int[][] grid;
    int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
    public int numEnclaves(int[][] grid) {
        int res =0;
        int m =grid.length;int n =grid[0].length;
        vis = new boolean[m][n]; can = new boolean[m][n];
        this.grid =grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1&&!vis[i][j]){
                    Queue<int[]> queue =new LinkedList<int[]>();
                    queue.offer(new int[]{i,j});
                    int c =1;
                    vis[i][j] =true;
                    while (!queue.isEmpty()){
                        int a[] = queue.poll();
                        int x =a[0];int y =a[1];
                        boolean is =false;
                        for(int t[] :dir){
                            int newx = t[0]+x;
                            int newy = t[1]+y;
                            if(newx>=0&&newy>=0&&newx<m&&newy<m&&!vis[newx][newy]&&grid[newx][newy]==1){
                                int b[] =new int[]{newx,newy};
                                c++;
                                queue.offer(b);
                                vis[newx][newy]=true;
                                if(newx==0||newy==0||newx==m||newy==n){
                                    is=true;
                                    break;
                                }
                            }
                            if(is) break;
                        }
                        if(!is){
                           res+=c;
                        }
                    }
                }
            }
        }
        return  res;
    }
}
