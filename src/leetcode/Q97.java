package leetcode;

public class Q97 {
    /**
     * dp[i][j]  s1的前i个字符和 s2 的前 j 个字符 能否构成 s3的前 i+j个字符
     * dp[i][j]  s2[j-1] = s3[i+j-1] dp[i][j] |= dp[i][j-1]
     *           s1[i-1] =s3[i+j-1] dp[i][j] |= dp[i-1][j]
     *
     *
     *

     * dp[i][j]
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
          int len1 =s1.length();int len2 =s2.length();
          if(len1+len2!=s3.length()) return  false;
          boolean dp[][] = new boolean[len1+1][len2+1];
          dp[0][0] =  true;
        for (int i = 0; i <len1 ; i++) {
           if(s1.charAt(i)==s3.charAt(i)) dp[i][0] |=dp[i-1][0];
           else break;
        }
        for (int i = 0; i <len2 ; i++) {
            if(s2.charAt(i)==s3.charAt(i)) dp[0][i] |=dp[0][i-1];
            else break;
        }
        for (int i = 0; i < len1 ; i++) {
            for (int j = 0; j < len2 ; j++) {
                if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                    dp[i][j] |= dp[i-1][j];
                }
                if(s2.charAt(i-1)==s3.charAt(i-j+1)){
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }
        return  dp[len1][len2];
    }
    void  print(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println(" ");
        }
    }
}
