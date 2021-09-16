package leetcode;

/**
 * @Classname FindTheDifference389
 * @Description:
 * @Date 2020/12/20 21:14
 * @Created by qiujunlin
 */
public class FindTheDifference389 {
    public char findTheDifference(String s, String t) {
        char  res= t.charAt(t.length()-1);
        for(int i=0;i<s.length();i++){
            res^=s.charAt(i);
            res^=t.charAt(i);
        }
        return res;
    }
}
