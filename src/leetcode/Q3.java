package leetcode;

import java.util.HashSet;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l  = 0;
        int res  =0;

        for (int i = 0; i < s.length(); i++) {
            char c =  s.charAt(i);
             if(!set.contains(c)) set.add(c);
             else {
                 while (s.charAt(l)!=c) {
                     set.remove(s.charAt(l));
                     l++;
                 }
             }
             res =Math.max(res,set.size());

        }
        return res;


    }
}
