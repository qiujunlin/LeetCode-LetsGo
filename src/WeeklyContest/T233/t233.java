package WeeklyContest.T233;

import java.util.*;

public class t233 {
    public static void main(String[] args) {
        System.out.printf("jaja");
    }

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


    public int maxValue(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum - n + 1;
        int a[] = new int[n];
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            a[index] = mid;
            if (judge(a, mid, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
            Arrays.fill(a, 0);
        }
        return left;
    }

    boolean judge(int a[], int index, int maxSum) {
        int lenleft = index;
        int lenright = a.length - 1 - index;
        int maxleft = (lenleft - 1) * lenleft / 2;
        int maxright = (lenright - 1) * lenright / 2;
        if (maxSum - lenleft - lenright >= 0 && maxSum <= maxleft + maxright) {
            return true;
        } else {
            return false;
        }
    }
}


