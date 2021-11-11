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
    static void  printMartrix(long dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println(" ");
        }
    }
    static  void printArray(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] );
            if(i!=arr.length-1) System.out.print(",");
        }
        System.out.print("]");
    }
}
