package leetcode;

public class Q1449 {
    public String largestNumber(int[] cost, int target) {
        int len =  cost.length;
        int dp[][] = new int[len+1][target+1];
        int pre[][] = new int[len+1][target+1];
        for (int i = 1; i <=10 ; i++) {
            int cos = cost[i-1];
            for (int j = 1; j <=target ; j++) {
                //如果小于
                if(cos<j){
                    dp[i][j] =dp[i-1][j];
                    pre[i][j] = j;
                }else{
                    if(dp[i][j]<=dp[i][j-cos]+1){
                        dp[i][j]= dp[i][j-cos]+1;
                        pre[i][j] =  j-cos;
                    }
                }
            }
        }
        StringBuffer res  = new StringBuffer();
        int i  = 9;
        int j = target;
        while (i>0){
            if(pre[i][j]==j){
                i--;
            }else{
                res.append(j);
                j=pre[i][j];
            }
        }
        return  res.toString();
    }
}
