package WeeklyContest.T215;

import java.util.*;

/**
 * @Classname DetermineifTwoStringsAreClose5603
 * @Description:
 * @Date 2020/11/15 13:22
 * @Created by qiujunlin
 */
public class DetermineifTwoStringsAreClose5603 {
    public boolean closeStrings(String word1, String word2) {
        int a[]=new int[26];
        int b[]=new int[26];

        for(int i=0;i<word1.length();i++){
            a[word1.charAt(i)-'a']++;
        }
        for(int i=0;i<word2.length();i++){
            b[word2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if((a[i]==0&&b[i]!=0) ||(a[i]!=0&&b[i]==0) )return false;

        }
        Arrays.sort(a);
        Arrays.sort(b);
        int index=25;
        while(index>=0){
            if(a[index]!=b[index]) return false;
            index--;
        }

        return true;
    }
}
