package Contest.week;

import Test.Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class W280 {
    public static void main(String[] args) {
        System.out.println("dsa");
    }
    public int countOperations(int num1, int num2) {
        int c =0;
           while (num1!=0&&num2!=0){
               if(num1>num2){
                   num1 =num1-num2;
               }else{
                   num2 =num2-num1;
               }
               c++;
           }
           return  c;
    }

    public int minimumOperations(int[] nums) {


        HashMap<Integer,Integer>  map1 = new HashMap<>();
        HashMap<Integer,Integer>  map2 = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(i%2==0){
                map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
            }else{
                map2.put(nums[i],map2.getOrDefault(nums[i],0)+1);
            }
        }
        int a =0;
        int c1 =0;
        int b =0;
        int c2 =0;
        for(int c:map1.keySet()){
            if(map1.get(c)>c1) {
                a = Math.max(c, a);
                c1 =map1.get(c);
            }
        }
        for(int c:map2.keySet()){
            if(map2.get(c)>c2) {
                b = Math.max(c, b);
                c2 =map1.get(c);
            }
        }

        if(a==b){
            if(c1>c2){
                int  d =0;
                for(int e:map2.keySet()){
                    if(e!=a){
                        d=Math.max(map2.get(e),d);
                    }
                }
                if(d==0) return  nums.length-c1;
                else return  nums.length-c1-d;
            }else if(c2>c1){
                int  d =0;
                for(int e:map1.keySet()){
                    if(e!=a){
                        d=Math.max(map1.get(e),d);
                    }
                }
                if(d==0) return  nums.length-c1;
                else return  nums.length-c2-d;
            }else {
                int d1 = 0;
                int d2 = 0;
                for (int e : map1.keySet()) {
                    if (e != a) {
                        d1 = Math.max(map1.get(e), d1);
                    }
                }
                for (int e : map2.keySet()) {
                    if (e != a) {
                        d2 = Math.max(map2.get(e), d2);
                    }
                }
                return nums.length - c1-Math.max(d1, d2);
            }
        }else{
return  nums.length-c1-c2;
        }







    }

}
