package Al4.Graph;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Arrays;

public class Dijkstra {
private DirectedEdge[] edgeTo;
private double[] distTo;
private IndexMinPQ<Double> pq;
public Dijkstra(EdgeWeightedGraph G,int s){
    edgeTo = new DirectedEdge[G.V()];
    distTo= new double[G.V()];
    Arrays.fill(edgeTo,Double.MAX_VALUE);
    distTo[s]= 0.0;
    pq.insert(s,0.0);
    while (!pq.isEmpty()){

    }

}
public void relax(EdgeWeightedDigraph G, int v){
    for(DirectedEdge e:G.adj(v)){

        if(distTo[e.to()]>distTo[v]+e.weight()){
             distTo[e.to()] = distTo[v]+e.weight();
             edgeTo[e.to()] =  e;
             if(pq.contains(e.to())){
                 pq.changeKey(e.to(),distTo[e.to()]);
             }else{
                 pq.insert(e.to(),distTo[e.to()]);
             }
        }
    }

}

    public static void main(String[] args) {

    }
}
