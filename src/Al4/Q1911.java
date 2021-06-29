package Al4;

public class Q1911 {
    public long maxAlternatingSum(int[] nums) {
        int  i=0;
        int len =nums.length;
        long res =0;
        //第一个下降序列的开始
        while (i+1<len&&nums[i]<nums[i+1]){
            i++;
        }
        if(i==len-1) return  nums[i];
        while (i<len) {
            int max = nums[i];
            while (i + 1 < len && nums[i] >= nums[i + 1]) {
                i++;
            }
            res +=(max-nums[i]);
            while (i+1<len&&nums[i]<nums[i+1]){
                i++;
            }
        }
        return  res;



    }
}
