package Array;

import java.util.*;

/**
 * @Classname Q36
 * @Description:
 * @Date 2021/2/25 0:38
 * @Created by qiujunlin
 */
public class Q36 {
    public boolean isValidSudoku(char[][] board) {
       HashMap<Integer,HashSet<Integer>> row = new HashMap<>();
       HashMap<Integer,HashSet<Integer>> col = new HashMap<>();
       HashMap<Integer,HashSet<Integer>> sca = new HashMap<>();
       for(int i = 0;i<9;i++){
           row.put(i,new HashSet<>());
           col.put(i,new HashSet<>());
           sca.put(i,new HashSet<>());
       }

       for(int i=0;i<9;i++){
           for(int j =0;j<9;j++){
               if(board[i][j]=='.') continue;
               if(row.get(i).contains(board[i][j]-'0')){
                   return  false;
               }
               if(col.get(i).contains(board[i][j]-'0')){
                   return  false;
               }
               int t = i/3*3+j/3;
               if(sca.get(t).contains(board[i][j]-'0')){
                   return  false;
               }
               row.get(i).add(board[i][j]-'0');
               col.get(i).add(board[i][j]-'0');
               sca.get(t).add(board[i][j]-'0');
           }
       }
       return  true;
    }
}
