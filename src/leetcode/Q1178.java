package leetcode;

import java.util.*;

/**
 * @Classname Q1178
 * @Description:
 * @Date 2021/2/26 0:06
 * @Created by qiujunlin
 */
public class Q1178 {
    public static void main(String[] args) {
        System.out.println(1 << 6);

    }
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
           List<Integer> res = new ArrayList<>();
           HashMap<String,Integer> map = new HashMap<>();
           for(String s :  words){
               int num = 0;
               for (int i = 1; i <s.length() ; i++) {
                   num|=(1<<(s.charAt(i)-'a'));
               }
           }
           ArrayList<Integer>  list =  new ArrayList<>();
        for (int i = 0; i < (1<<6) ; i++) {
            int num = 0;
            for (int j = 0; j < 6; j++) {
                 if(((i>>j)&1)==1) num|=(1<<j);
            }
            list.add(num);
        }
        System.out.println(list);
        for (int i = 0; i < puzzles.length; i++) {
            String s = puzzles[i];
            int n =  1<<(s.charAt(0));
            String end = s.substring(1,8);
            HashSet<Integer> set = new HashSet<>();
            for(Integer num : list){
               int temp  = n;
               for (int j = 5; j >= 0 ; j--) {
                   if(((num>>j)&1)==1){
                       temp|=(1<<(end.charAt(5-j)-'a'));
                   }
               }
               set.add(temp);
           }
           int count  =0;
           for(Integer temp :set ){
               count+= map.getOrDefault(temp,0)+1;
           }
           res.add(count);

        }
        return  res;
    }


}
