package leetcode;

import java.util.*;

public class Q1488 {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer>  map = new HashMap<>();
        int res[] = new int[rains.length];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
             if(rains[i]>0){
                 if(!map.containsKey(rains[i])){
                     map.put(rains[i],i);
                 }else {
                     if(set.size()>0){
                         res[i] = -1;
                         Integer a = set.ceiling(map.get(rains[i]));
                         if(a==null){
                             res = new int[0];
                             break;
                         }
                         res[a] = rains[i];
                         set.remove(a);
                         map.put(rains[i],i);
                     }
                 }
             }else{
                 set.add(i);
             }
        }
        while (set.size()>0){
            res[set.pollFirst()] = 1;
        }
        return  res;
    }
}
