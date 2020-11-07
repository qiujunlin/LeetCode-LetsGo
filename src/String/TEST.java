package String;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class TEST {
    public static void main(String[] args) {


          List<Integer> list=new ArrayList<>();
          list.add(1);
          list.add(2);
          list.add(3);
          Integer[] a = list.toArray(new Integer[list.size()]);
          System.out.println(a[2]);

    }
    public int[] sortByBits(Integer[] arr) {
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<arr.length;i++){
        //   map.put(arr[i],cout(arr[i]));
        // }
        Arrays.sort(arr,(Integer a,Integer b)->a-b);
        return null;
    }
    public static  int cout(int n){
        int res=0;
        while(n!=0){
            if(n%2==1) res++;
            n = n/2;
        }
        return   res;
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
