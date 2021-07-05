package Array;

public class Q10 {
    public boolean isMatch(String s, String p) {
        //   dp[0][]
        char ch1[] = s.toCharArray();
        char ch2[]=  p.toCharArray();
        int len1 = s.length();
        int len2=  p.length();
        boolean dp[][]=  new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if(ch2[i]=='*') dp[0][i+1] = dp[0][i-1];
        }
        for(int i=1;i<=len1;i++){
            char c1 =  ch1[i-1];
            for(int j =1;j<=len2;j++){
                char c2 = p.charAt(j-1);
                if(c1==c2) dp[i][j] =dp[i-1][j-1];
                else if(c2=='.') dp[i][j] =dp[i-1][j-1];
                else if(c2=='*'){
                    if(c1==p.charAt(j-2)||p.charAt(j-2)=='.') dp[i][j] =dp[i][j-2]||dp[i-1][j-2]||dp[i-1][j];
                    else  {

                        dp[i][j] =dp[i][j-2];
                    }
                }

            }
        }
             return  dp[len1][len2];
    }
}
