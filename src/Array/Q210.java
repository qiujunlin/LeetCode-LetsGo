package Array;

import java.util.*;
/**
 * @Classname Q210
 * @Description:
 * @Date 2021/4/2 22:27
 * @Created by qiujunlin
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> course[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            course[i] = new ArrayList<>();
        }
        int in[] = new int[numCourses];
        for (int a[] : prerequisites) {
            course[a[1]].add(a[0]);
            in[a[0]]++;
        }
        //    System.out.println(set);
        if (!canFinish(numCourses, prerequisites)) return new int[0];
        Queue<Integer> q =new LinkedList<>();
        boolean marked[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(in[i] == 0){
                q.offer(i);
            }
        }
        int res[] = new int[numCourses];
        //计算头结点
        int count = 0;
        while (!q.isEmpty()){
            Integer a = q.poll();
            res[count] = a;
            for(int c : course[a]){
                in[c]--;
                if(in[c]==0)
                q.offer(c);
            }
            count++;
        }
        return res;
    }

    void dfs(ArrayList<Integer> course[], boolean marked[], ArrayList<Integer> list, int v) {
        marked[v] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        list.add(v);
        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int a : course[temp]) {
                if (!marked[a]) {
                    marked[a] = true;
                    list.add(a);
                    que.offer(a);
                }
            }
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> course[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            course[i] = new ArrayList<>();
        }
        for (int a[] : prerequisites) {
            course[a[1]].add(a[0]);
        }
        boolean marked[] = new boolean[numCourses];
        boolean onstack[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!marked[i]) {
                boolean res = judge(course, marked, onstack, i);
                if (res) return false;
            }
        }


        return true;
    }
    public boolean judge(ArrayList<Integer> course[], boolean marked[], boolean onstack[], int v) {
        marked[v] = true;
        onstack[v] = true;
        for (int a : course[v]) {
            if (!marked[a]) {
                marked[a] = true;
                boolean bo = judge(course, marked, onstack, a);
                if (bo) return bo;
            } else if (onstack[a]) {
                return true;
            }
        }
        onstack[v] = false;
        return false;
    }
}

