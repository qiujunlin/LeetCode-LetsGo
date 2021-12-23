package leetcode;

/**
 * @Classname Q28
 * @Description:
 * @Date 2021/5/27 22:00
 * @Created by qiujunlin
 */
public class Q28 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int  m = haystack.length();
        int n =  needle.length();
        char  s [] =  haystack.toCharArray();
        char p [] = needle.toCharArray();
        int next [] = new int[needle.length()];
        // next
        for (int i = 1,j=-1; i <n ; i++) {
            while (j>=0&&p[i]!=p[j+1])  j  =next[j];
            if(p[i]==p[j+1]) j++;
            next[i] = j;
        }
        //pipeo
        for (int i = 0,j=-1; i <m ; i++) {
            while (j>=0&&s[i]!=p[j+1]) j  = next[j];
            if(s[i]==p[j+1])  j++;
            if(j==n-1) return  i-n+1;
        }
        return  -1;


    }
}
