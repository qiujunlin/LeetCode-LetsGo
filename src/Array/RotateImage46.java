package Array;

import java.util.*;

/**
 * @Classname RotateImage46
 * @Description:
 * @Date 2020/12/20 21:11
 * @Created by qiujunlin
 */
public class RotateImage46 {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        for(int i=0;i<(m+1)/2;i++){
            for(int j=0;j<m/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[m-j-1][i];//(0,1),(2,0)
                matrix[m-j-1][i]=matrix[m-i-1][m-j-1];//(2,0).(3,2)
                matrix[m-i-1][m-j-1]=matrix[j][m-i-1];
                matrix[j][m-i-1]=temp;//（0,1）,(1,3),(0,2),(2,3),(1,2),(2,2)
            }
        }

    }
}
