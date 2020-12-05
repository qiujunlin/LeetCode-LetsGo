package Array;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/5
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        //map用来记录下标，同时也用来判断窗口中是否存在重复值
        Map<Character,Integer> map = new HashMap<>();
        int max=0;
        for(int start =0,end=0;end<s.length();end++){
            if(map.containsKey(s.charAt(end))){    //如果窗口中已经包含了这个字符，就更新start，将start更新为当前窗口中出现重复值的那个字符的下一位
                start=Math.max(map.get(s.charAt(end))+1,start);

            }
            map.put(s.charAt(end),end);//因为start已经更新，所以就将窗口内的字符的下标也要更新
            max=Math.max(max,end-start+1);//每一次迭代过后都要更新最终的值
        }
        return max;

    }
}
