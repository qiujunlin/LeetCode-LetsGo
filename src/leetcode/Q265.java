package leetcode;

public class Q265 {
    public static void main(String[] args) {
        //[[15,17,15,20,7,16,6,10,4,20,7,3,4],[11,3,9,13,7,12,6,7,5,1,7,18,9]]
        int a[][] = {{15,17,15,20,7,16,6,10,4,20,7,3,4},{11,3,9,13,7,12,6,7,5,1,7,18,9}};
        new Q265().minCostII(a);
    }
    public int minCostII(int[][] costs) {
        int len  = costs.length;
        int k = costs[0].length;
        int dp[][] = new int[len+1][k];

        int min1 =0;int min2 =0;
        for(int i =1;i<=len;i++){
            int a1 =Integer.MAX_VALUE;int a2 =Integer.MAX_VALUE;
            for(int j =0;j<k;j++){
                if(j==min1){
                    dp[i][j] =  costs[i-1][j] + dp[i-1][min2];
                }else {
                    dp[i][j] =  costs[i-1][j] + dp[i-1][min1];
                }
                if(a1==Integer.MAX_VALUE||dp[i][j]<dp[i][a1]){
                    a1 = j;
                }else if(a2==Integer.MAX_VALUE||dp[i][j]<dp[i][a2]&&dp[i][j]>=dp[i][a1]){
                    a2 = j;
                }

            }
            min1 =a1;min2 = a2;
            System.out.println(min1+ " "+min2);
        }
        CommonUtils.printMartrix(dp);
        int res =0;
        for(int i=0;i<k;i++){
            res =Math.min(dp[len][i],res);
        }
        return res;

    }
}
