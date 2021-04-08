package Al4.Graph;

import edu.princeton.cs.algs4.*;

import java.util.PriorityQueue;

public class LazyPrimMST {
private  boolean marked[];
private Queue<Edge>  mst;
private PriorityQueue<Edge> pq;
public  LazyPrimMST(EdgeWeightedGraph G){
    pq  = new PriorityQueue<>();
    marked = new boolean[G.V()];
    mst = new Queue<>();
    visit(G,0);
    while (!pq.isEmpty()){
        Edge edge = pq.poll();
        int v  = edge.either();
        int w  =  edge.other(v);
        if(marked[v]&&marked[w]) continue;
        mst.enqueue(edge);
     if(!marked[v]) visit(G,v);
     if(!marked[w]) visit(G,w);
    }
}

    private void visit(EdgeWeightedGraph G, int v)
    { // 标记顶点v并将所有连接v和未被标记顶点的边加入pq
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) pq.offer(e);
    }
    public Iterable<Edge> edges()
    { return mst; }
 // 请见练习4.3.31

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();     //获取开始时间
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
       LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
       // StdOut.printf("%.5f\n", mst.weight());
        long overTime = System.currentTimeMillis();      //获取结束时间
        System.out.println("程序运行时间为："+(overTime-startTime)+"毫秒");
    }
}
