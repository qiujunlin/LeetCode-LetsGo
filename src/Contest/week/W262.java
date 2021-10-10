package Contest.week;

import javax.print.DocFlavor;
import java.util.*;

public class W262 {
    public static void main(String[] args) {


    }
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> set1 = new HashSet<>();
        for(int a :  nums1) set1.add(a);
        HashSet<Integer> set2 = new HashSet<>();
        for(int a :  nums2) set2.add(a);
        HashSet<Integer> set3 = new HashSet<>();
        for(int a :  nums3) set3.add(a);
        HashMap<Integer,Integer>  map =  new HashMap<>();
        for(int a : set1) {
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(int a : set2) {
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(int a : set3) {
            map.put(a,map.getOrDefault(a,0)+1);
        }
        List<Integer>  res =new ArrayList<>();
        for(int a : map.keySet()){
            if(map.get(a)>=2){

                res.add(a);
            }
        }
        return  res;

    }
    public int minOperations(int[][] grid, int x) {
        int m =  grid.length;
        int n =  grid[0].length;
        int sum =0;
        int min =Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }
        int res=Integer.MAX_VALUE;
        Collections.sort(list);
        int len = list.size();
        if(len%2==0){
            int a = list.get(len/2);
            res =Math.min(res,get(list,a,x));
        }else{
            res =Math.min(res,get(list,list.get(len/2-1),x));
            res =Math.min(res,get(list,list.get(len/2),x));
        }
        return  res==Integer.MAX_VALUE?-1:res;
    }

    private int get(ArrayList<Integer> list, int a, int x) {
        int res =0;
        for(int b:list){
             if((b-a)%x!=0){
                 return  Integer.MAX_VALUE;
             }
             res+=Math.abs((b-a)/x);
        }return  res;
    }


}
