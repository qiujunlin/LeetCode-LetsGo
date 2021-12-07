package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Q1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
    // bfs
        int source =  grid[row][col];
        Deque<int[]>  deque = new LinkedList<>();
        boolean  vis[][] = new boolean[row][col];
        vis[row][col] = true;
        int direct[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        deque.offer(new int[]{row,col});
        while (deque.size()!=0){
            int g[] =  deque.poll();
            for (int i = 0; i < 4; i++) {
               int newx =  g[0]+direct[i][0];
               int newy =  g[1]+direct[i][1];
               if(newx<row&&newx>=0&&newy<col&&newy>=0&&grid[newx][newy]==source){
                   deque.offer(new int[]{newx,newy});
                   vis[newx][newy]=true;
               }
            }
        }
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                if(vis[i][j]){
                    for (int k = 0; k <4 ; k++) {
                        int newx =  i+direct[i][0];
                        int newy =  j+direct[i][1];
                        if(newx>=row||newx<0||newy>=col||newy<0||vis[newx][newy]==false){
                            grid[i][j]=color;
                        }
                    }
                }
            }
        }
        return  grid;



    }
}
