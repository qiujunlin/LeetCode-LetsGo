package dp;

import java.util.*;

/**
 * @Classname CoinChange322
 * @Description:
 * @Date 2020/11/20 11:03
 * @Created by qiujunlin
 */
public class CoinChange322 {

    int dp[];
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount+1];
        return dfs(coins,amount);
        //return [amount];
    }
    int dfs(int []coins,int amount){
        //返回条件
        if(amount==0) return 0;
        if(amount<0) return -1;
     //如果 不为0  直接返回值  就 不用继续递归了
       if(dp[amount]!=0) return dp[amount];
        int  min=Integer.MAX_VALUE;
        //  遍历数组中的每一个  得到最小值
        for(int a:coins){
            int res=dfs(coins,amount-a);
            if(res==-1) continue;
            min=Math.min(min,res+1);
        }
        //如果最终的最小值改变了 就改变dp数组中的值
        dp[amount]=min==Integer.MAX_VALUE?-1:min;
        return dp[amount];
    }
  //  int dp[];
    public int coinChange2(int[] coins, int amount) {
        dp=new int[amount+1];
        //     return dfs(coins,amount);
        //return [amount];
        for(int i=1;i<amount+1;i++)dp[i]=Integer.MAX_VALUE-1;
        dp[0]=0;
        for(int i=1;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]<0) continue;
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount]==Integer.MAX_VALUE-1?-1:dp[amount];
    }
    //暴力递归
    //DFS 减枝
    //先将最小值设置为最大
    int min=Integer.MAX_VALUE;
    public int coinChange3(int[] coins, int amount) {
        //先进行排序，由大到小进行遍历
        Arrays.sort(coins);
        //count  数量  idnex：下标
        dfs(coins,amount,0,coins.length-1);
        return min==Integer.MAX_VALUE?-1:min;
    }
    void dfs(int[] coins,int amount,int count,int index){
        if(amount<0) return;//小于0表示 溢出  直接返回
        if(amount==0) { //等于0 表示 刚好分配完全 这个时候要和最小值的结果进行一个比较
            min=Math.min(min,count);
            return;
        }
        if(index==-1) return; //如果下标 越界  直接返回
        //k=0  表示 不使用当前的零钱，进行下一个零钱的遍历
        //  k+count  是一个剪纸  如果 k+count  小于最后的结果 继续遍历，如果大于的话，继续遍历也就没有了必要
        for(int k=amount/coins[index];k>=0&&k+count<min;k--){
            //这里注意是index-1 不是index--
            dfs(coins,amount-k*coins[index],count+k,index-1);
        }

    }


}
