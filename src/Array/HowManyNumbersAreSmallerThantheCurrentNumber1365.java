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
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int length= nums.length;
        int temp[] = new int[101];
        int res[] = new int[length];
        for(int i=0;i<length;i++){
            temp[nums[i]]++;
        }
        for(int i=1;i<101;i++){
            temp[i]+=temp[i-1];
        }
        for(int i=0;i<length;i++){
            res[i]=nums[i]==0?0:temp[nums[i]-1];
        }

        return res;
    }

}
