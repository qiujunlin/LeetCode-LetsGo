package leetcode;

/**
 * @Classname BestTimetoBuyandSellStock121
 * @Description:
 * @Date 2020/11/8 10:26
 * @Created by qiujunlin
 */
public class BestTimetoBuyandSellStockII122 {
    public int maxProfit(int[] prices) {
        int res=0;

        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0) res+=(prices[i]-prices[i-1]);
        }
        return res;
    }
}
