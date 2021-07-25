package Contest.week.T233;

import java.util.*;

public class t233 {


    public int maxAscendingSum(int[] nums) {
        int dp[] = new int[1];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + nums[i], dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        int mod = 1000000007;
        PriorityQueue<int[]> buy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < orders.length; i++) {
            int order[] = orders[i];
            //豺狗订单，查找销售订单钱的最小值 xioashoa<=caigou
            if (order[2] == 0) {

                if (sell.isEmpty() || sell.peek()[0] > order[0]) {
                    buy.add(order);
                    continue;
                }
                while (!sell.isEmpty() && sell.peek()[0] <= order[0] && order[1] > 0) {
                    //一起执行
                    if (sell.peek()[1] <= order[1]) {
                        order[1] -= sell.peek()[1];
                        sell.poll();
                    } else {
                        sell.peek()[1] -= order[1];
                        order[1] = 0;
                        break;
                    }
                }
                if (order[1] > 0) buy.add(order);
            } else {
                //xiaosou<<buy 查找buy
                if (buy.isEmpty() || buy.peek()[0] < order[0]) {
                    sell.add(order);
                    continue;
                }
                while (!buy.isEmpty() && buy.peek()[0] >= order[0] && order[1] > 0) {
                    //一起执行
                    if (buy.peek()[1] <= order[1]) {
                        order[1] -= buy.peek()[1];
                        buy.poll();
                    } else {
                        buy.peek()[1] -= order[1];
                        order[1] = 0;
                        break;
                    }
                }
                if (order[1] > 0) sell.add(order);
            }
        }
        int count = 0;
        for (int a[] : buy) {
            count = (count + a[1]) % mod;
        }
        for (int a[] : sell) {
            count = (count + a[1]) % mod;
        }
        return count;
    }




    boolean judge( int n,int index, int maxSum,int mid) {
      //
        int left = index ;
        int right  = n-index-1;
        int leftsum =0;
        int rightsum =0;
        if(left<=mid-1){
            int a1 = mid-1-left+1;
            leftsum = (a1+mid-1)*left/2;
        }else{
            leftsum = (mid-1+1)*(mid-1)/2;
            leftsum+=left-mid+1;
        }
        if(right<=mid-1){
            int a1 = mid-1-right+1;
            rightsum= (a1+mid-1)*right/2;
        }else{
            rightsum = (mid-1+1)*(mid-1)/2;
            rightsum+=right-mid+1;
        }
        int sum = mid+leftsum+rightsum;
        return  sum<=maxSum;

    }
    public int maxValue(int n, int index, int maxSum) {
      int left =1;
      int right  = maxSum;
      while (left<right){
          int mid  = left+(right-left+1)/2;
          if(judge(n,index,maxSum,mid)){
              left=mid;
          }else{
              right =mid-1;

          }
      }
      return  left;
    }

    public static void main(String[] args) {
        System.out.println(new t233().maxValue(5,0,28));
    }

}


