package Array;

import java.util.*;

/**
 * @Classname MatrixDiagonalSum1572
 * @Description:
 * @Date 2020/11/9 17:15
 * @Created by qiujunlin
 */
public class MatrixDiagonalSum1572 {
    public int diagonalSum(int[][] mat) {
        int len=mat.length;
        int sum=0;
        for(int i=0;i<len;i++){
            sum=sum+mat[i][i]+mat[len-i-1][i];
        }
        if(len%2==0) return sum;
        return sum-mat[len/2][len/2];
    }
}
