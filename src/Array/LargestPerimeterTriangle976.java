package Array;

import java.util.*;

/**
 * @Classname LargestPerimeterTriangle976
 * @Description:
 * @Date 2020/11/29 9:24
 * @Created by qiujunlin
 */
public class LargestPerimeterTriangle976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;


    }
}
