package Array;

public class Q5 {
    //区间dp问题
    public String longestPalindrome(String s) {
        int len  = s.length();
        int max  = 0;
        int l  = 0;
        int r  = 0;
        boolean dp[][] = new boolean[len][len] ;
        for (int i = len-1; i >=0 ; i--) {
            dp[i][i] =true;
            for (int j = i+1 ; j < len; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2) dp[i][j]   = true;
                    else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = true;
                }
                if (dp[i][j]){
                    if(j-i+1>max){
                        l  = i;
                        r  = j;
                        max = j-i+1;
                    }
                }
            }
        }
        return  s.substring(l,r+1);
    }
    public String longestPalindrome2(String s) {
        int len  = s.length();
        int max  = 0;
        int l  = 0;
        int r  = 0;
        boolean dp[][] = new boolean[len][len] ;
        for (int j = 1; j < len ; j++) {
            dp[j][j] =true;
            for (int i = 0 ; i < j; i++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2) dp[i][j]   = true;
                    else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = true;
                }
                if (dp[i][j]){
                    if(j-i+1>max){
                        l  = i;
                        r  = j;
                        max = j-i+1;
                    }
                }
            }
        }
        return  s.substring(l,r+1);
    }
    public String longestPalindrome3(String s) {
        int len  = s.length();
        int max  = 0;
        int l  = 0;
        int r  = 0;
        boolean dp[][] = new boolean[len][len] ;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                 int length =  j+i-1;
                 if(length>=len) break;
                 if(s.charAt(j)==s.charAt(length)){
                     if(i<=2) dp[j][length] =true;
                     else {
                         dp[j][length] =dp[j+1][length-1];
                     }
                 }else {
                      dp[j][length] = false;
                 }
                 if(dp[j][length]){
                     if(len>max){
                         l =  j;
                         r = length;
                         max = len;
                     }
                 }
            }

        }
        return  s.substring(l,r+1);

    }

}
