
package  leetcode;
public class Q44 {
    public boolean isMatch(String s, String p) {
       int len1 = s.length();
       int len2 =p.length();
       boolean dp[][] = new boolean[len1+1][len2+1];
       dp[0][0] = true;
        for (int i = 0; i <len2 ; i++) {
            if(p.charAt(i)=='*') dp[0][i+1] = dp[0][i];

        }
       for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <=len2 ; j++) {
                  char c = p.charAt(j-1);
                  if(s.charAt(i-1)==c||c=='?'){
                      dp[i][j] |= dp[i-1][j-1];
                  }else if(c=='*'){
                      dp[i][j] |= dp[i-1][j];
                  }else{
                      dp[i][j] = false;
                  }
            }
        }
       return  dp[len1][len2];
    }
}
