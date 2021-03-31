package Al4.Graph;

import edu.princeton.cs.algs4.Graph;

import java.util.*;

/**
 * @Classname BreadthFirstPaths
 * @Description:
 * @Date 2021/3/26 23:09
 * @Created by qiujunlin
 */
public class BreadthFirstPaths {
    private boolean[] marked; // 这个顶点上调用过dfs()了吗？
    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; // 起点

    public BreadthFirstPaths(Graph g, int s) {
        this.s = s;
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.V()];
        bfs(g, s);
    }

    private void bfs(Graph g, int v) {
        Queue<Integer> queue = new LinkedList<>();
        marked[v] = true;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int a = queue.poll();
            for(int node : g.adj(a)){
                if(!marked[node]){
                    marked[node] =true;
                    edgeTo[node] =a;
                    queue.offer(node);
                }
            }
        }


    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return  null;
        Stack<Integer> stack = new Stack<>();
        while (v!=s){
            stack.push(v);
            v=edgeTo[v];
        }
        stack.push(s);
        return  stack;

    }

}
