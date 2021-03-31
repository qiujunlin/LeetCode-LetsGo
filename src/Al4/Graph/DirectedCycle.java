package Al4.Graph;

import java.util.*;
import  edu.princeton.cs.algs4.Digraph;

/**
 * @Classname DirectedCycle
 * @Description:
 * @Date 2021/3/31 14:21
 * @Created by qiujunlin
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // 有向环中的所有顶点（如果存在）
    private boolean[] onStack; // 递归调用的栈上的所有顶点
    public DirectedCycle (Digraph G)
    {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }
    private void dfs(Digraph G, int v)
    {

    }

    public boolean hasCycle()
    { return cycle != null; }
    public Iterable<Integer> cycle()
    { return cycle; }
}
