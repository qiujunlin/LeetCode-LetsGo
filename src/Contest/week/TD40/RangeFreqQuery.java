package Contest.week.TD40;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

class RangeFreqQuery {
    HashMap<Integer, TreeMap<Integer,Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            TreeMap<Integer,Integer> m = map.computeIfAbsent(arr[i],(key)->new TreeMap<>());
            m.put(i,m.size()+1);
        }


    }

    public int query(int left, int right, int value) {
        TreeMap<Integer,Integer> m = map.get(value);
        if(m==null) return   0;
        Integer l  = m.ceilingKey(left);
        if(l==null) return   0;
        int ll  = m.get(l);
        Integer r = m.floorKey(right);
        if(r==null) return   0;
        int rr  = m.get(r);
        System.out.println(m);
        return  rr-ll+1;
    }
}
