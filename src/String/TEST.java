package String;

import java.util.*;

public class TEST {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(1,3);
        Set<Integer> set= new HashSet<>();
        for (Integer a:map.keySet()) {
            if(set.contains(a)){
                return;
            }else{
                set.add(map.get(a));
            }
        }
        System.out.println(map.get(1));
    }

}
