package leetcode;

import java.util.Arrays;

public class Q87 {
    public boolean isScramble(String s1, String s2) {
    int len1 = s1.length();
    int len2  =s2.length();
    if(len1!=len2) return  false;
    int a[] =new  int[26];
    int b[] =new  int[26];
    for(int i=0;i<len1;i++){
        a[s1.charAt(i)-'a']++;
        b[s2.charAt(i)-'a']++;
    }
    if(!Arrays.equals(a,b)) return  false;
    for(int  i=1;i<len1;i++){
        if(isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i,len1),s2.substring(i,len2))) return  true;
        if(isScramble(s1.substring(0,i),s2.substring(len1-i,len1))&&isScramble(s1.substring(i,len1),s2.substring(0,len1-i)))return  true;
    }
    return  false;
    }

    public boolean isScramble1(String s1, String s2) {
        int len =  s1.length();
        boolean dp[][][] = new boolean[len][len][len+1];
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <len ; j++) {
                dp[i][j][1] = true;
            }
        }
        //枚举长度
        for (int i = 2; i <=len ; i++) {
            // s1左边界
            for (int j = 0; j < len ; j++) {
                // s2 左边界
                for (int k = 0; k < len; k++) {
                    // 枚举分割点
                    for (int l = 1; l <=len ; l++) {

                        dp[i][j][len] |= dp[i+l][j+l][len-l] && dp[i][j][l];
                        if(dp[i][j][len])  break;

                        dp[i][j][len] |= dp[i][j+len-l][l] &&dp[i+l][j][len-l];
                        if(dp[i][j][len]) break;

                    }
                }
            }
        }
        return  dp[0][0][len];


    }
}
