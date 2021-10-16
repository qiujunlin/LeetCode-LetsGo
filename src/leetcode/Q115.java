package leetcode;

/**
 * @Classname Q115
 * @Description:
 * @Date 2021/3/17 0:03
 * @Created by qiujunlin
 */
public class Q115 {

    /**dp[i][j] 表示在s[0:i-1]中 t[0:j-1] 出现的次数
     * s[i]==s[j] dp[i][j] = dp[i-1][j-1] + dp[i-1][j]+1 +dp[i][j-1] +1
     * else  dp[][]
     *
     * s[i]
     * @param
     * @param t
     * @return
     */

        public int numDistinct(String s, String t) {
            int len1 =s.length();int len2 =t.length();
            int dp[][] = new int[len1+1][len2+1];
            for (int i = 0; i <= len1; i++) {
                dp[i][0]=1;
            }

            for (int i = 1; i <=len1 ; i++) {
                for (int j = 1; j <=len2; j++) {
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    }else{
                        dp[i][j] =dp[i-1][j];
                    }
                }
            }
            CommonUtils.printMartrix(dp);

 return  0;
        }

    public static void main(String[] args) {
        String  s ="rabbbit", t = "rabbit";
        String s2 = "babgbag", t2 = "bag";
        new Q115().numDistinct(s,t);
    }

}
