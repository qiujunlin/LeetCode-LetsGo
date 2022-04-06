package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Main3 {
   static  boolean f = false;
    public static void main(String[] args)  throws  Exception{
        Object a = new Object();
        new Thread(()->{
            for (int i = 0; i <10 ;) {
                 synchronized (a){
                     while (!f) {

                     }
                     System.out.println(a);
                     i++;
                     f =true;
                     a.notifyAll();
                 }
            }
        }).start();


    }
    private static void dfs(HashMap<Long, Integer> map, int[] nums, long t,int i) {
        if(i==nums.length){
            map.put(t,map.getOrDefault(t,0)+1);
            return;
        }
        dfs(map,nums,t*nums[i],i+1);
        dfs(map,nums,t,i+1);
    }
    private static HashSet<Long> getZhi(long num) {
        HashSet<Long> set = new HashSet<>();
        for (long i = 2; i <=num ; i++) {
            while (i!=num){
                if(num%i==0){ set.add(i);
                    num=num/i;
                }else{
                    break;
                }
            }
        }
        set.add(num);
        return set;
    }
}
