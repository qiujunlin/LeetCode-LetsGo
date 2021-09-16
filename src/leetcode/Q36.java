package leetcode;

import java.util.*;

/**
 * @Classname Q36
 * @Description:
 * @Date 2021/2/25 0:38
 * @Created by qiujunlin
 */
public class Q36 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);set.add(2);set.add(3);
        while (!set.isEmpty()) System.out.println(set.pollFirst());

    }
    public boolean isValidSudoku(char[][] board) {
       int grid[][] = new int[9][9];
       int col[][] = new int[9][9];
       int row[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.') continue;
                int a  = board[i][j]-'0';
                if(grid[i/3*3+j/3][a]==1) return  false;
                else grid[i/3*3+j/3][a] =1;
                if(col[j][a]==1) return  false;
                else col[j][a]=1;
                if(row[i][a]==1) return  false;
                else  row[i][a] =1;
            }
        }
        return  true;
    }
}
