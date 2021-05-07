package TU;


import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijiskra {
    public static void main(String[] args) {
        HashMap<Integer,HashMap<Integer,Integer>>  map = new HashMap<>();
        int  source =0;
        int n =7;
        int dist[] = dijiskra(map,source,n);
    }

    private static int[] dijiskra(HashMap<Integer, HashMap<Integer, Integer>> map, int source,int n) {
           int dist[]=  new int[n];
           int pre [] = new int[n];
           boolean  vis [] = new boolean[n];
           Arrays.fill(dist,Integer.MAX_VALUE);
           PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[1]-b[1]);
           que.offer(new int[]{source,0});
           while (!que.isEmpty())
           {
               int node[] =que.poll();
               int from=  node[0];
               if(vis[from]) continue;
               vis[from] = true;
               HashMap<Integer, Integer>  edges = map.get(from);
               for(int to : edges.keySet()) {
                   if (dist[to] > dist[from] + edges.get(to)) {
                       dist[to] = dist[from] + edges.get(to);
                       que.offer(new int[]{to, dist[to]});
                       pre[to] = from;
                   }
               }
           }
           return  dist;
    }
    //void dijisjra()
}
