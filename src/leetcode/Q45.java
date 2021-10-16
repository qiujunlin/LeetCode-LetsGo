package leetcode;

public class Q45 {
    public int jump(int[] nums) {
        // dp[i]  到达nums[i] 所需的最少跳跃次数
        int count = 1;
        int start =0;
        // int next = nums[0];
        if(nums[0]>=nums.length-1) return 1;
        while(true){
            int max =0;
            int next=nums[start];
            for(int j=1;j<=next;j++){
                System.out.println(j+start);
                if(nums[j+start]+j>max){
                    max =nums[j+start]+j;
                }
            }
            if(max>=nums.length-1) return count+1;
            count++;
            start =  max;
        }
        //  return 0;

    }

    public static void main(String[] args) {
        int a[] = new int[]{2,2,0,1,4};
        new Q45().jump(a);
    }
}
