package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer, ArrayList<Integer>> map =new HashMap<>();
        for (int i = 0; i <richer.length ; i++) {
            map.computeIfAbsent(richer[i][1],(key)->new ArrayList<>()).add(richer[i][0]);
        }
        int res[] = new int[quiet.length];
       Arrays.fill(res,Integer.MAX_VALUE);
        for (int i = 0; i <quiet.length ; i++) {
            dfs(map,i,quiet,res,i);
        }
        return  res;
}

    private void dfs(HashMap<Integer, ArrayList<Integer>> map, int i,int[] quiet,int res[],int index) {
         if(res[i]==Integer.MAX_VALUE||quiet[res[i]]>quiet[res[index]]) res[index] = i;
        if(map.get(index)==null) return  ;
        for(int a : map.get(index)){
           dfs(map,a,quiet,res,a);
        }
    }


}
