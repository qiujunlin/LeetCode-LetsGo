package Al4.Graph;

import java.util.*;

/**
 * @Classname Q220
 * @Description:
 * @Date 2021/4/17 0:08
 * @Created by qiujunlin
 */
public class Q220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) set.add((long) nums[i]);
            else {
                Long a = set.ceiling((long) k - (long) nums[i]);
                if (a != null || (long) a + (long) k >= (long) nums[i]) {
                    return true;
                }
                set.add((long) (nums[i]));
                set.remove(((long) nums[i - t]));
            }

        }
        return false;
    }
}
