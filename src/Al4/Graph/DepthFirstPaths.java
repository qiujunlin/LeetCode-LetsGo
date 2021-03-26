package Al4.Graph;

import java.util.*;
import  edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * @Classname DepthFirstPaths
 * @Description:
 * @Date 2021/3/26 22:03
 * @Created by qiujunlin
 */
public class DepthFirstPaths
{
    private boolean[] marked; // 这个顶点上调用过dfs()了吗？
    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; // 起点
    public DepthFirstPaths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }
    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(G, w);
            }
    }
    public boolean hasPathTo(int v)
    { return marked[v]; }
    public Iterable<Integer> pathTo(int v)
    {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        DepthFirstPaths depthFirstPaths  =new DepthFirstPaths(g,Integer.valueOf(args[1]));
        System.out.println(depthFirstPaths.pathTo(4));
    }
}
