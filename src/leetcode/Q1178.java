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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : words) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                count |= 1 << (s.charAt(i) - 'a');
            }
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (String s : puzzles) {
            int source = 0;
            for (int i = 0; i < s.length(); i++) {
                source |= 1 << (s.charAt(i) - 'a');
            }
            int bit = source;
            int first = 1 << (s.charAt(0) - 'a');
            int count = 0;
            while (bit != 0) {
                if ((bit & first) != 0 && map.containsKey(bit)) {
                    count += map.get(bit);
                }
                bit = (bit - 1) & source;
            }
            res.add(count);
            //枚举子集


        }
        return res;
    }

    public List<Integer> findNumOfValidWords1(String[] words, String[] puzzles) {
        HashMap<String, HashMap<Character, Integer>> map = new HashMap<>();
        for (int i = 0; i < puzzles.length; i++) {
            String s = puzzles[i];
            map.put(s, new HashMap<>());
            for (int j = 0; j < s.length(); j++) {
                map.get(s).put(s.charAt(j), 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            String s = puzzles[i];
            int count = 0;
            for (int k = 0; k < words.length; k++) {
                String ss = words[k];
                if (map.get(s).containsKey(ss.charAt(0))) {
                    HashMap<Character, Integer> hash = map.get(s);
                    int j = 1;
                    for (j = 1; j < ss.length(); j++) {
                        if (!hash.containsKey(ss.charAt(j)))
                            break;
                        ;
                    }
                    if (j == ss.length()) count++;
                }
            }
            list.add(count);
        }
        return list;
    }
}
