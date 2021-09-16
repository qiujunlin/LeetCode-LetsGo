package leetcode;
import  java.util.*;
public class Q1418      {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>>  res =new ArrayList();
        TreeMap<String,HashMap<String,Integer>> map  = new TreeMap();
        TreeSet<String> in = new TreeSet<>();
        for(List<String> l : orders){
            String num =l.get(1);
            String cai =  l.get(2);
            HashMap<String,Integer> m =  map.computeIfAbsent(num,(key)->new HashMap<>());
            m.put(cai,m.getOrDefault(cai,0)+1);
            if(!in.contains(cai)){in.add(cai);}
        }
        //  System.out.println(list);
        List<String> list = new ArrayList<>();
        list.add("Table");
        while (!in.isEmpty()){
            list.add(in.pollFirst());
        }
        res.add(list);
        int size = list.size();
        for(String key : map.keySet()){
            HashMap<String,Integer> t  = map.get(key);
            String[] ll =  new String[size];
            Arrays.fill(ll,"");
            ll[0] =key;
            //  System.out.println(ll.size());
            for(String k : t.keySet()){
                //ll[in.get(k)] = String.valueOf(t.get(k));
            }
            res.add(Arrays.asList(ll));
        }
        return res;


    }
}
