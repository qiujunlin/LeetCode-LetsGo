package Array;

public class Q10 {
    public boolean isMatch(String s, String p) {
        char ch1[] = s.toCharArray();
        char ch2[]=  p.toCharArray();
        int len1 = s.length();
        int len2=  p.length();
        boolean dp[][]=  new boolean[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            char c1 =  ch1[i-1];
            for(int j =1;j<=len2;j++){
                char c2 =  ch2[j-1];
                if(c2=='.'){
                  dp[i][j] = dp[i-1][j-1];
                }else if(c2>='a'&&c2<='z'){
                    if(c2==c1)
                    dp[i][j] =dp[i-1][j-1];
                    else dp[i][j] = false;
                }else{
                    char c = ch2[j-2];
                    if(c==c1){
                        dp[i][j] = dp[i-1][j]||dp[i][j-2];
                    }else{  
                        dp[i][j] = dp[i][j-2];
                    }

                }
            }
        }
             return  dp[len1][len2];
    }
}
