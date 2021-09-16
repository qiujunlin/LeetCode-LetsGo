package leetcode;

/**
 * @Classname Q28
 * @Description:
 * @Date 2021/5/27 22:00
 * @Created by qiujunlin
 */
public class Q28 {
    public int strStr(String haystack, String needle) {
        int  m = haystack.length();
        int n =  needle.length();
        int next[] = new int[n+1];
        haystack = " "+haystack;
        needle = " "+needle;
        char ch1[] = haystack.toCharArray();
        char ch2[] = needle.toCharArray();
        //预处理
        for(int j=0, i=2;i<n;i++){
            while (j>0&&ch2[j+1]!=ch2[i])  j = next[j];
            if(ch2[i] == ch2[j+1]) j++;
            next[i] =  j;

        }
        for(int i=1,j=0;i<m;i++){
            while (j>0&&ch1[i]!=ch2[j+1]) j =next[j];
            if(ch1[i] == ch2[j+1]) j++;
            if (j == n) return i - n;
        }
        return  -1;


    }
}
