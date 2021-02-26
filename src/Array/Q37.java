package Array;

import java.util.*;

/**
 * @Classname Q37
 * @Description:
 * @Date 2021/2/25 10:06
 * @Created by qiujunlin
 */
public class Q37 {
    public void solveSudoku(char[][] board) {
        boolean col[][] =  new boolean[10][10];
        boolean row[][] =  new boolean[10][10];
        boolean square[][] =  new boolean[10][10];
        dfs(col,row,square,board,0,0);


    }
    boolean dfs(boolean col[][],boolean row[][],boolean square[][],char board[][],int r,int c){
        if(c==10){
            if(r==10){
                return  true;
            }else{
                c=0;
                r++;
            }
        }
        if(board[r][c]=='.') {
            for (int i = 1; i <= 9; i++) {
                if (!col[r][i]&&!row[c][i]&&!square[r/3*3+c][i]){
                    col[r][i]=row[c][i]=square[r/3*3+c][i]=true;
                    if(!dfs(col,row,square,board,r,c+1)){
                        col[r][i]=row[c][i]=square[r/3*3+c][i]=false;
                    }
                }else{
                    return  false;
                }
            }
        }else{
            dfs(col,row,square,board,r,c+1);
        }
      return  true;
    }
    public void begin(boolean col[][],boolean row[][],boolean square[][],char board[][]){
        for(int i=0;i<9;i++){
            for(int j =0;j<9;j++){

                if(board[i][j]>='1'&&board[i][j]<='9'){
                    int a = board[i][j]-'0';
                    row[i][a]=true;
                    col[j][a]=true;
                    square[i/3*3+j][a]=true;
                }
            }
        }
    }
}
