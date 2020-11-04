package String;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class TEST {
    public static void main(String[] args) {
     int a[][]={{1,2},{2,1},{1,3}};
     List<int[]> list= new ArrayList<>();
     list.add(a[0]);
     list.add(a[2]);
        System.out.println(list.get(1)[1]);

}

    public static  boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map= new HashMap<>();
        for (int a:arr) {
            map.put(a ,map.getOrDefault(a, 0) + 1);
        }
        Set<Integer> set= new HashSet<>(map.values());
        for(Integer a:map.values()){
            if(set.add(a)==false) return false;
        }
        return true;
    }

}
