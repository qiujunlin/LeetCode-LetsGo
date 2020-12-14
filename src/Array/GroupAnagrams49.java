package Array;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/14
 */
public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List<String>>  map= new HashMap<>();
        for(String s:strs){
            char chs[] = s.toCharArray();
            Arrays.sort(chs);
            String s1= String.valueOf(chs);
            if(map.containsKey(s1)) map.get(s1).add(s);
            else {
                List<String> newlist = new ArrayList<>();
                newlist.add(s);
                map.put(s1,newlist);
            }
        }
        for(List<String> l : map.values()){
            list.add(l);
        }
        return list;
    }
}
