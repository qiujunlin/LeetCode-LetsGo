package leetcode;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SummaryRanges {
    TreeMap<Integer,Integer> map ;
    public SummaryRanges() {
        map = new TreeMap<>();

    }

    public void addNum(int val) {
        // 1. 寻找大于val的最小值 2， 小于val的最大值
        if(map.isEmpty()) {map.put(val,val);return;}
        Integer a = map.ceilingKey(val);
        Integer b = map.floorKey(val);
        // if()

        if(b!=null&&b<=val&&map.get(b)>=val||a!=null&&a==val){
        }else if(a!=null&&a-1==val&&b!=null&&map.get(b)+1==val){
            map.put(b,map.get(a));
            map.remove(a);
        }else if(a!=null&&a-1==val){
            map.put(val,map.get(a));
            map.remove(a);
        }else if(b!=null&&map.get(b)+1==val){
            map.put(b,val);
        }else{
            map.put(val,val);
        }
    }

    public int[][] getIntervals() {
        int size = map.size();
        int res[][] = new int[size][2];
        int i =0;
        Iterator<Integer> integerIterator = map.keySet().iterator();
        while (integerIterator.hasNext()){
            Integer a = integerIterator.next();
            res[i++] = new int[]{a,map.get(a)};
        }
        return  res;
    }
}
