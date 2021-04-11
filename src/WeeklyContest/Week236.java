package WeeklyContest;

import java.util.Arrays;
import java.util.LinkedList;

public class Week236 {
    public static void main(String[] args) {
        System.out.println("haha");
    }
    public int arraySign(int[] nums) {
     int flag = 1;
     for(int i=0;i<nums.length;i++){
         if(nums[i]==0) return  0;
         flag =  flag*nums[i]>0?1:-1;
     }
     return  flag;

    }
    public int findTheWinner(int n, int k) {
        LinkedList<Integer>  list = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int cur  =0;
        while (list.size()>1){
            int size =  list.size();
            cur  =  cur+k-1;
            cur =  cur%size;
            if(cur==size-1){
                list.remove(cur);
                cur=0;
            }else {
                list.remove(cur);
                cur = cur + 1;
            }
            //最后
        }
        return  list.get(0);

    }
    public int minSideJumps(int[] obstacles) {
   int len  = obstacles.length;
   int dp[][] = new int[len][4];
        Arrays.fill(dp, len+1);
    dp[0][1]= dp[0][0] = dp[0][2]=dp[0][3] =0;
        for(int i=1;i<len;i++){
            if(obstacles[i]==1){//第一道
                if(obstacles[i-1]==1)
                dp[i][2] =  Math.min(Math.min(dp[i-1][1]+1,dp[i-1][3]+1),dp[i-1][2]);
                dp[i][3] =Math.min(Math.min(dp[i-1][1]+1,dp[i-1][2]+1),dp[i-1][3]);
            }else if(obstacles[i]==2){
                dp[i][1]=Math.min(Math.min(dp[i-1][2]+1,dp[i-1][3]+1),dp[i-1][1]);
                dp[i][3]=Math.min(Math.min(dp[i-1][1]+1,dp[i-1][2]+1),dp[i-1][3]);
            }else if(obstacles[i]==3){
                dp[i][1]=Math.min(Math.min(dp[i-1][2]+1,dp[i-1][3]+1),dp[i-1][1]);
                dp[i][2]=Math.min(Math.min(dp[i-1][1]+1,dp[i-1][3]+1),dp[i-1][2]);
            }else{
                dp[i][1]=Math.min(Math.min(dp[i-1][2]+1,dp[i-1][3]+1),dp[i-1][1]);
                dp[i][2] =  Math.min(Math.min(dp[i-1][1]+1,dp[i-1][3]+1),dp[i-1][2]);
                dp[i][3] =Math.min(Math.min(dp[i-1][1]+1,dp[i-1][2]+1),dp[i-1][3]);
            }
        }
        int res  = Integer.MAX_VALUE;
        for(int i=1;i<=3;i++){
            res = Math.min(dp[len-1][i]);

        }
        return  res;
    }

}
