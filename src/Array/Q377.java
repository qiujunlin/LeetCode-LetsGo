package Array;
import java.util.*;
public class Q377 {
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int mem[] = new int[target + 1];
        Arrays.fill(mem, -1);
        return dfs(mem, nums, target);
    }

    private int dfs(int men[], int nums[], int k) {
        if (k == 0) return 1;
        if (k < 0) return 0;
        int sum = 0;
        if (men[k] != -1) return men[k];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>k) break;
            sum += dfs(men, nums, k - nums[i]);
        }
        return men[k] = sum;


    }
}
