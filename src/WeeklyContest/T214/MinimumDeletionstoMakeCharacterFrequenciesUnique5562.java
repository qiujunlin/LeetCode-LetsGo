package WeeklyContest.T214;

import java.util.*;

/**
 * @Classname MinimumDeletionstoMakeCharacterFrequenciesUnique5562
 * @Description:
 * @Date 2020/11/8 13:43
 * @Created by qiujunlin
 */
public class MinimumDeletionstoMakeCharacterFrequenciesUnique5562 {
    //第一次 百分之五六十
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return (e1.getValue()).compareTo(e2.getValue());
            }
        });
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        int times=0;
        System.out.println(map);
        for (Character a:
                result.keySet()) {
            Integer re=map.get(a);
            map.put(a,map.get(a)+1);
            while(map.containsValue(re)){
                System.out.println(re);
                int newval= re-1;
                re=newval;
                times++;
                if(newval==0) break;

            }
            map.put(a,re);
        }
        return times;
    }
    //第二次 双百
    public int minDeletions2(String s) {
        int  a[]= new int[26];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        Arrays.sort(a);
        Set<Integer> set= new HashSet();
        int times=0;
        for(int i=0;i<a.length;i++){
            int k=0;
            while(a[i]!=0&&set.add(a[i])==false){
                k++;
                a[i]--;
            }
            times+=k;
        }
        return times;
    }
}

