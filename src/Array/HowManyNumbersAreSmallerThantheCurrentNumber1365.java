package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowManyNumbersAreSmallerThantheCurrentNumber1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int res[] = Arrays.copyOf(nums,nums.length);
        List<Integer> list= new ArrayList<>();
        Arrays.sort(nums);//nums是排序后的结果
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=list.indexOf(res[i+1]);
        }
        return nums;
    }
    //方法二 使用 桶思想

}
