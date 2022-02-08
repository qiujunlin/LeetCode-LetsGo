package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Q1001 {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer,Integer> row =new HashMap<>();
        HashMap<Integer,Integer> col =new HashMap<>();
        HashMap<Integer,Integer> left =new HashMap<>();
        HashMap<Integer,Integer>  right =new HashMap<>();
        HashSet<Long>  set =new HashSet<>();
        for(int a[] : lamps){

             int x =a[0];int y =a[1];
            long x1 =x;long x2 =y;long len =n;
             if(set.contains(x2*n+x2)) continue;

             set.add(x1*len+x2);
             row.put(x,row.getOrDefault(x,0)+1);
             col.put(y,row.getOrDefault(y,0)+1);
             left.put(x+y,row.getOrDefault(x+y,0)+1);
             right.put(x-y,row.getOrDefault(x-y,0)+1);
        }
        int[][] dirs = new int[][]{{0,0},{0,-1},{0,1},{-1,0},{-1,-1},{-1,1},{1,0},{1,-1},{1,1}};
        int res[] =new int[queries.length];int index =0;
        for(int a[]: queries){
             int x =a[0];int y = a[1];
             if(row.containsKey(x)||col.containsKey(y)||left.containsKey(x+y)||right.containsKey(x-y)) res[index] = 1;
             for (int i = 0; i < dirs.length; i++) {
                 int newx = dirs[i][0]+x;
                 int newy = dirs[i][1]+y;
                 if(newx<0||newy<0||newx>=n||newy>=n) continue;
                 long len =n;
                 if(set.contains(len*newx+newy)) {
                     System.out.println("111");
                     set.remove(len*newx+newy);
                     remove(row, x);
                     remove(col, y);
                     remove(left, x + y);
                     remove(right, x - y);
                 }
             }
             index++;
        }
        return  res;

    }

    private void remove(HashMap<Integer, Integer> row, int x) {
              if(row.get(x)==1)row.remove(x);
              row.put(x,row.get(x)-1);
    }
}
