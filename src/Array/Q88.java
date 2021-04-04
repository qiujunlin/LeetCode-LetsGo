package Array;

import java.util.*;

/**
 * @Classname Q88
 * @Description:
 * @Date 2021/4/5 0:00
 * @Created by qiujunlin
 */
public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m - 1;
        int pos2 = n - 1;
        int index = m + n - 1;
        while (index >= 0) {
            if (pos1 == -1) {
                nums1[index] = nums2[pos2--];
            } else if (pos2 == -1) {
                nums1[index] = nums1[pos1--];
            } else if (nums1[pos1] < nums2[pos2]) {
                nums1[index] = nums2[pos2--];
            }
            if (nums1[pos1] > nums2[pos2]) {
                nums1[index] = nums1[pos1--];
            }
            index--;
        }

    }
}
