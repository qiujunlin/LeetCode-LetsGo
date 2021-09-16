package leetcode;

/**
 * @Classname Q80
 * @Description:
 * @Date 2021/4/6 0:00
 * @Created by qiujunlin
 */
public class Q80 {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[index] = nums[i];
                index++;
            }



        }
        return index;
    }

}
