package Contest.week;

import java.util.*;

public class DB84 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int a[]:items1) {
            map.put(a[0],a[1]);
        }
        for(int a[] :items2){
            map.put(a[0],map.getOrDefault(a[0],0)+a[1]);
        }
        List<List<Integer>> res =new ArrayList<>();
        for(int a:map.keySet()){
            ArrayList<Integer> l =new ArrayList<>();
            l.add(a);l.add(map.get(a));
            res.add(l);
        }
        Collections.sort(res,(a,b)->{
            ArrayList<Integer> l1 =(ArrayList)a;
            ArrayList<Integer> l2 =(ArrayList)b;
            return  l1.get(1).compareTo(l2.get(1));
        });
        return  res;

    }
    public long countBadPairs(int[] nums) {
        long len = nums.length;
        long res =0;
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j +i<nums.length ; j++) {
                 if(nums[i]-nums[j]!=i-j) res++;
            }
        }

        return  res;


    }
    public long countBadPairs(int[] nums,int space) {
        class Node{
            int val;
            long time;
        }
       HashMap<Integer,Node> map =new HashMap<>();
       long time  =0;
       for(int a:nums){
           if(!map.containsKey(a)){
               Node n = new Node();n.val = a;n.time = time+space;
               map.put(a,n);
           }else{
               Node n = map.get(a);
               if(n.time<=time){
                    n.time = n.time+space;

               }else{
                   time = n.time;
                   n.time = time+space;
               }

           }

       }
       return  time;


    }


}
