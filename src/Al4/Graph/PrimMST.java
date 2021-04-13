package Al4.Graph;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.PriorityQueue;

public class PrimMST {
    private Edge[] edgeTo; // 距离树最近的边
    private double[] distTo; // distTo[w]=edgeTo[w].weight()
    private boolean[] marked; // 如果v在树中则为true
    private IndexMinPQ<Double> pq; // 有效的横切边}
    public  PrimMST(EdgeWeightedGraph G){
        edgeTo  = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> qu  = new PriorityQueue<>();
        qu.offer(1);
        qu.offer(2);
        qu.offer(23);
        qu.remove(23);
        System.out.println(qu);
    }

}
