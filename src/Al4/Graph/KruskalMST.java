package Al4.Graph;

import edu.princeton.cs.algs4.*;

import java.util.PriorityQueue;

public class KruskalMST {
    private Queue<Edge> mst;
    public  KruskalMST(EdgeWeightedGraph G){
        PriorityQueue<Edge>  queue = new PriorityQueue<>();
        mst = new Queue<>();
        for(Edge e : G.edges()){
            queue.offer(e);
        }
        Union u = new Union(G.V());
        while (!queue.isEmpty()&&mst.size()!=G.V()-1){
            Edge e = queue.poll();
            int v   = e.either();
            int w = e.other(v);
            if(!u.isconnected(v,w)){
                u.merge(v,w);
                mst.enqueue(e);
            }
        }
    }
    public Iterable<Edge> edges()
    { return mst; }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();     //获取开始时间
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST  mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        //StdOut.printf("%.5f\n", mst.weight());

        long overTime = System.currentTimeMillis();      //获取结束时间
        System.out.println("程序运行时间为："+(overTime-startTime)+"毫秒");
    }
}
