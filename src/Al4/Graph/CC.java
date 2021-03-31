package Al4.Graph;

import java.util.*;

/**
 * @Classname CC
 * @Description:
 * @Date 2021/3/28 16:39
 * @Created by qiujunlin
 */
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CC {
    private int id[];
    private boolean marked[];
    private int count;

    CC(Graph G) {
        int len = G.V();
        id = new int[len];
        marked = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!marked[i]) {
                dfs(G, i);
                count++;
            }
        }
    }

    void dfs(Graph g, int s) {
        marked[s] = true;
        id[s] = count;
        for (int a : g.adj(s)) {
            if (!marked[a]) {
                dfs(g, a);
            }
        }
    }

    boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    int count() {
        return count;
    }

    int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);
        int M = cc.count();
        ArrayList<Integer> a[] = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < G.V(); i++) {
            int c = cc.id(i);
            a[c].add(i);
        }
        for (int i = 0; i < M; i++) {
            for (int v : a[i])
                StdOut.print(v + " ");
            StdOut.println();
        }
    }
}
