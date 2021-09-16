package leetcode;

import java.util.*;

/**
 * @Classname Q1462
 * @Description:
 * @Date 2021/4/2 23:50
 * @Created by qiujunlin
 */
public class Q1462 {
    public List<Boolean> checkIfPrerequisite2(int n, int[][] prerequisites, int[][] queries) {
        ArrayList<Integer> course[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            course[i] = new ArrayList<>();
        }
        HashSet<Integer> set = new HashSet<>();
        for (int a[] : prerequisites) {
            course[a[0]].add(a[1]);
            set.add(a[0]);
            set.add(a[1]);
        }
        int men[][] = new int[n][n];
        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int temp[] = queries[i];
            res.add(dfs2(course,temp[0],temp[1],men));
        }
        return   res;

    }
    boolean dfs2(ArrayList<Integer> course[],int target,int v,int men[][]){
        if(men[target][v]==1) return  true;
        if(men[target][v]==-1) return  false;
        if(target==v) return  true;
        for(int a:course[v]){
            boolean res =dfs2(course,a,v,men);
            if(res) {
                men[a][v] =1;
                return  res;
            }
            else  men[a][v] = -1;
        }
        men[target][v] = -1;
        return  false;
    }
    //解法一 暴力 超时
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        ArrayList<Integer> course[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            course[i] = new ArrayList<>();
        }
        HashSet<Integer> set = new HashSet<>();
        for (int a[] : prerequisites) {
            course[a[0]].add(a[1]);
            set.add(a[0]);
            set.add(a[1]);
        }
       List<Boolean> res = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int arr[] = queries[i];
            int a=arr[0];
            int b=arr[1];
            boolean flag=false;
            if(set.contains(a)&&set.contains(b)){
                for(int c : course[a]) {
                    if (dfs(course, a, c)) {
                        res.add(true);
                        flag=true;
                        break;
                    }
                }
            }
            if(!flag) res.add(false);
        }
     return   res;

    }
    boolean dfs( ArrayList<Integer> course[],int target,int v){
        if(v==target) return true;
        for(int a:course[v]){
            boolean res = dfs(course,target,a);
            if(res) return true;
        }
        return  false;
    }
}
