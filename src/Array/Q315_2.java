package Array;

import java.util.*;

public class Q315_2 {
    class TreeArray {
        int tree[];
        int n;

        public TreeArray(int n) {
            tree = new int[n + 1];
            this.n = n;
        }

        public void update(int x, int num) {
            while (x <= n) {
                tree[x] += num;
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int res = 0;
            while (x > 0) {
                res += tree[x];
                x -= lowbit(x);
            }
            return res;
        }

        public int lowbit(int x) {
            return x & -x;

        }

    }

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int tem[] = new int[len];
        System.arraycopy(nums, 0, tem, 0, len);
        Arrays.sort(tem);
        for (int i = 0; i < len; i++) {
            nums[i] = Arrays.binarySearch(tem, nums[i]);
        }
        TreeArray treeArray = new TreeArray(len);

        for (int i = len - 1; i >= 0; i--) {
            treeArray.update(nums[i], 1);
            list.add(treeArray.query(nums[i] - 1));
        }
        Collections.reverse(list);
        return list;
    }
}

