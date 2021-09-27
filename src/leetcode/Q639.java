package leetcode;

/**
 * @description: 1
 * @author: qiujunlin
 * @create: 2021-09-27 18:13
 */
public class Q639 {
    public int numDecodings(String s) {
        int len = s.length();
        int dp[] = new int[len+1];
        dp[0] =1;
        /**
         * 1. s[i] ==  1-9|| *  dp[i+1] += dp[i]
         *    s[i-1] == 1-9 && s[i-1,i]<26  dp[i+1] += dp[i-1]
         *    s[i-1] == '*'
         *          s[i] <'7' dp[i+1] += d[i-1]*2   1*  2*
         *          s[i] >'6' dp[i+1] += dp[i-1]
         * 2  s[i] = *
         *     1. dp[i+1] *=dp[i];
         *     1. s[i-1] == '0'  dp[i+1] =
         *     2. s[i-1] == '1'  dp[i+1] +=dp[i-1]*9;
         *        s[i-1] == '2'  dp[i+1] += dp[i-1]*6;
         */
        for (int i = 0; i < len ; i++) {
              if(isNum(s.charAt(i))) {
                 dp[i+1] += dp[i];
                 if(i>1&&isNum(s.charAt(i-1))&&Integer.valueOf(s.substring(i-1,i+1))<=26) dp[i+1] += dp[i-1];

             }
            if(s.charAt(i-1)=='*'){
                if(s.charAt(i)<'7') dp[i+1] += dp[i-1]*2;
                else  if(s.charAt(i)>'6') dp[i+1] += dp[i-1];
            }
            if(s.charAt(i)=='*'){
                dp[i+1] += dp[i];
                if(s.charAt(i-1)=='1') dp[i+1] +=dp[i-1]*9;
                if(s.charAt(i-1)=='2' ) dp[i+1] += dp[i-1]*6;
            }




        }
        return  dp[len];

    }

    private boolean isNum(char c) {
       return  c>='1'&&c<='9';
    }
}
