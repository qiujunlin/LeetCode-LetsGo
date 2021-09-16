package leetcode;

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
       boolean  res = dfs(col,row,square,board,0,0);
    }

    private boolean dfs(boolean[][] col, boolean[][] row, boolean[][] square, char[][] board, int r, int c) {
       if(r==9&&c==0) return  true;
       if(board[r][c]=='.'){
           for(int i=1;i<=9;i++){
               if(!col[c][i]&&!row[r][i]&&!square[r/3+c/3][i]){
                   col[c][i]=row[r][i]=square[r/3+c/3][i]=true;
                   board[r][c] = (char)('a'+i);
                   boolean res;
                   if(c==8) {
                    res =    dfs(col,row,square,board,r+1,0);
                   }else{
                    res =    dfs(col,row,square,board,r,c);
                   }
                   if(res) return true;
                   col[c][i]=row[r][i]=square[r/3+c/3][i]=false;
                   board[r][c] = '.';

               }
           }
       }
       return  false;
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
