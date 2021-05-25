package template;

import java.util.*;

/**
 * @Classname SegmentTree
 * @Description:
 * @Date 2021/5/25 21:51
 * @Created by qiujunlin
 */
public class SegmentTree {
        int tree[];
        int n;

        public SegmentTree(int[] nums) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
            //  System.out.println(tree);
        }

        private void buildTree(int[] nums) {
            for (int i = n; i < tree.length; i++) {
                tree[i] = nums[i - n];
            }
            for (int i = n - 1; i > 0; i--) {
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }

        public void update(int index, int val) {
            index = index+n;
            tree[index] = val;
            while (index > 0) {
                int left = index;
                int right = index;
                if (index % 2 == 0) {
                    right = index + 1;
                } else {
                    left = index - 1;
                }
                tree[index / 2] = tree[left] + tree[right];
                index = index / 2;
            }
        }

        public int sumRange(int left, int right) {
            int r = right+n;
            int l = left+n;
            int res =0;
            while (l<=r){
                if(l%2==1){
                    res+=tree[l];
                    l++;
                }
                if(r%2==0){
                    res+=tree[r];
                    r--;
                }
                l=l/2;
                r=r/2;
            }
            return res;
        }

}
