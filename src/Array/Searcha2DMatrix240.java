package Array;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/24
 */
public class Searcha2DMatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        for(int i=0;i<matrix.length;i++){
            if(Arrays.binarySearch(matrix[i],target)>=0) return true;
        }
        return false;
    }
}
