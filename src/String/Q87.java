package String;

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

}
