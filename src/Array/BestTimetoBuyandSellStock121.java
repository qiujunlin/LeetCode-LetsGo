package Array;

import java.util.*;

/**
 * @Classname BestTimetoBuyandSellStock121
 * @Description:
 *
 * @Date 2020/11/8 10:26
 * @Created by qiujunlin
 */
public class BestTimetoBuyandSellStock121 {


    public int maxProfit(int[] prices) {
        int minprice=Integer.MAX_VALUE;
        int maxprifit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minprice){
                minprice=prices[i];
            }if(prices[i]-minprice>maxprifit){
                maxprifit=prices[i]-minprice;
            }
        }
        return maxprifit;
    }
}
