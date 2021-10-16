package leetcode;

public class CommonUtils {
   static void  printMartrix(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println(" ");
        }
    }
}
