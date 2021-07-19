package WeeklyContest;

import java.util.*;

/**
 * @Classname D249
 * @Description:
 * @Date 2021/7/11 10:24
 * @Created by qiujunlin
 */
public class D249 {
    public static void main(String[] args) {
        System.out.println("dsfsd");
    }
    public int[] getConcatenation(int[] nums) {
        int res[] = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }

        return res;
    }
    public int countPalindromicSubsequence(String s) {
            HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
            char ch[] = s.toCharArray();
            for (int i = 0; i <s.length() ; i++) {
                map.computeIfAbsent(s.charAt(i),(key)->new ArrayList<Integer>()).add(i);
            }
            int res  =0;
           for(Character k: map.keySet()){
               ArrayList<Integer> list = map.get(k);
             //  HashSet<String> set = new HashSet<>();
               if(list.get(list.size()-1)-list.get(0)>1){
                   HashSet<Character> set = new HashSet<>();
                   for (int i = list.get(0)+1; i < list.get(list.size()-1); i++) {
                       set.add(ch[i]);
                   }
                   res+=set.size();
               }

           }
           return  res;

    }

}
