package template;

public class KMP {
    public int strStr(String str, String pattern) {
        if(pattern.length()==0) return 0;
        int  m = str.length();
        int n =  pattern.length();
        char  s [] =  str.toCharArray();
        char p [] = pattern.toCharArray();
        int next [] = new int[pattern.length()];
        // next
        next[0]=-1;
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
