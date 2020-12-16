package String;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/15
 */
public class Test1 {
    public static void main(String[] args) {
        int a[] = new int[]{2, 2, 2,1,3};
   Arrays.s



    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public int solve(int n, int[] a) {
        // write code here
        LinkedList<Integer> list = new LinkedList();
        Arrays.sort(a);
        dfs(a, 0, list,0);
        return max - min;
    }

    void  dfs(int[] nums, int left, LinkedList<Integer> list,int sum) {
        if (list.size() == 3) {
            int a = list.get(0);
            int b = list.get(1);
            int c = list.get(2);
            if (valid(a, b, c)) {
                max = Math.max(max, sum);
                min = Math.min(min, sum);

            }
        }
        for (int i = left; i < nums.length; i++) {
            list.offer(nums[i]);
            if(list.size()==3&&sum<nums[i]) {
                list.removeLast();
                break;
            }
            dfs(nums, i + 1, list,sum+nums[i]);
            list.removeLast();
        }
    }

    boolean valid(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            return false;
        }
    }

}
