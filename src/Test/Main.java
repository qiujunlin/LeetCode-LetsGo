package Test;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Stack;
import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         StringBuffer s =  new StringBuffer();
         s.append("aba");
        System.out.println(s.toString().equals(s.reverse().toString())) ;
    }
    private static void dfs(boolean[] vis, HashSet<String> set, HashMap<Integer, HashSet<Integer>> map, int source, int dep, StringBuffer s) {
        if(dep==5) {
            set.add(s.toString());
            return;
        }
        for(int a :  map.get(source)){
            if(!vis[a]){
                vis[a] = true;
                s.append(a);
                dfs(vis,set,map,a,dep+1,s);
                vis[a] = false;
                s.deleteCharAt(s.length()-1);
            }
        }
    }
//
//    private static boolean judge(HashSet<Integer> set, boolean[] vis,int pre ){
//        for (int i = 1; i <vis.length ; i++) {
//            if(vis[i]&&i!=pre){
//                if(set.contains(i))  return  false;
//            }
//        }
//        return  true;
//    }
    /**
     *
     6 7
     1 2
     2 3
     3 4
     4 5
     5 6
     1 6
     3 6
     */


}





