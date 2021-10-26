package leetcode;

public class Q188 {

    public int maxProfit(int k, int[] prices) {
        /**
         *

        seil[i][j] 表示第i天，进行j笔交易 并且不持有股票
        buy[i][j] :表示第i天，进行了j笔交易，并且持有股票
         buy[i][j] : =Math.max(seil[i-1][j]-price[i],buy[i-1][j]) 1：第i天买入，第i-1天不持有 2：第i-1天持有
         seil[i][j] =Math.max(buy[i-1][j-1]+price[i],seil[i-1][j])  1: 第i天卖出，i-1天持有  2、 第i-1天的时候就不持有股票
         初始值 ：
         buy[0][0] = -priec[0]
         seil[0][0] = 0
         其他的情况就是最小值

         seil[i][0] =
         buy[i][0] =

         */

        int len =  prices.length;
        int seil[][]  = new int[len][k+1];
        int buy[][]  = new int[len][k+1];
        //初始化
        buy[0][0] = -prices[0];seil[0][0] = 0;
        for (int i = 0; i <k ; i++) {
            buy[0][i+1] = seil[0][i+1] =  Integer.MAX_VALUE/2;
        }
        for (int i = 1; i <prices.length ; i++) {
            buy[i][0] =Math.max(buy[i-1][0],-prices[i]);
            for (int j = 1; j <= k ; j++) {
                buy[i][j] =Math.max(seil[i-1][j]-prices[i],buy[i-1][j]);
                seil[i][j] =Math.max(buy[i-1][j-1]+prices[i],seil[i-1][j]);
            }
        }
        int res =0 ;
        for (int i = 0; i <=k ; i++) {
            res =Math.max(res,seil[len-1][i]);
        }
        return  res;


    }
}
