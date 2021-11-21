package leetcode;

import java.util.HashMap;

public class Q318 {
    public int maxProduct(String[] words) {
        int nums[] =new int[words.length];
        for (int i = 0; i <words.length ; i++) {
            String s = words[i];
            int a  =0;
            for (int j = 0; j < s.length(); j++) {
                a|=(1<<(s.charAt(j)-'a'));
            }
            nums[i] =a;
        }
        int max  =0;
        for (int i = 0; i <words.length ; i++) {
            for (int j = i+1; j <words.length ; j++) {
                if((nums[i]&nums[j])==0) {
                    max =Math.max(words[i].length()+words[j].length(),max);
                }
            }
        }
        return  max;

    }
}
