package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Q207 {
    HashMap<Integer, ArrayList<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       map =  new HashMap<>();
       for(int a[]: prerequisites){
            int course  =  a[0];
            int pre =  a[1];
            map.computeIfAbsent(pre,(key)->new ArrayList<>()).add(course);
       }
       // dfs判断是否存在环
        boolean vis[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(dfs(vis,i)) return  false;
        }
        return  true;
    }

    private boolean dfs(boolean[] vis, int i) {
         vis[i] = true;
         ArrayList<Integer> list = map.get(i);
         if(list==null) {vis[i] = false;return  false;}
         for(int key : list){
              if(vis[key]) return  true;
              dfs(vis,key);
         }
         vis[i] = false;
         return  false;
    }

    public static void main(String[] args) {
        int a[][] ={{0,1},{1,0}};
        new Q207().canFinish(2,a);
    }
    public class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<Integer>  course[] = new ArrayList[numCourses];
            for(int i=0;i<numCourses;i++){
                course[i] = new ArrayList<>();
            }
            for(int a[] : prerequisites){
                course[a[1]].add(a[0]);
            }
            boolean marked[] = new boolean[numCourses];
            boolean onstack[] = new boolean[numCourses];

            for(int i=0;i<numCourses;i++){
                if(!marked[i]){
                    boolean res = judge(course,marked,onstack,i);
                    if(res)  return  false;
                }
            }
            return  true;
        }
        public  boolean judge(ArrayList<Integer>  course[] ,boolean marked[],boolean onstack[],int v){
            marked[v] =true;
            onstack[v] =true;
            for(int a :  course[v]){
                if(!marked[a]){
                    marked[a] = true;
                    boolean bo = judge(course,marked,onstack,a);
                    if(bo)  return  bo;
                }else if(onstack[a]){
                    return  true;
                }
            }
            onstack[v] =false;
            return  false;
        }
    }
}
