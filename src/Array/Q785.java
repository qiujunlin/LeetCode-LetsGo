package Array;

import java.util.*;

/**
 * @Classname Q785
 * @Description:
 * @Date 2021/3/28 17:04
 * @Created by qiujunlin
 */
public class Q785 {
    public boolean isBipartite(int[][] graph) {
        //创建邻接链表
        int len = graph.length;
        boolean vis[] = new boolean[len];
        boolean color[] = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!vis[i]) {
                boolean res = dfs(graph, color, vis, i);
                if (!res) return false;
            }
        }
        return true;


    }

    boolean bfs(int graph[][], boolean color[], boolean vis[], int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int c : graph[a]) {
                if (!vis[c]) {
                    color[c] = !color[a];
                    queue.offer(c);
                }
                else{
                    if (color[a] == color[c]) return false;
                }
            }
        }
        return  true;
        }
        boolean dfs ( int graph[][], boolean color[], boolean vis[], int s){
            vis[s] = true;
            for (int a : graph[s]) {
                if (!vis[a]) {
                    color[a] = !color[s];
                    return dfs(graph, color, vis, a);
                } else {
                    if (color[a] == color[s]) return false;
                }
            }
            return true;
        }
    }
