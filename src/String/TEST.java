package String;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class TEST {
    public static void main(String[] args) {
        int a[][]= new int[1][2];


       // System.out.println(uniqueOccurrences(a));
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
