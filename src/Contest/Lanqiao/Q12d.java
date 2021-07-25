package Contest.Lanqiao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Q12d {
    public static void main(String[] args) {
        long s =System.currentTimeMillis();
  HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
 // .put(1,5);
      //  HashMap<Integer,Integer> m2 =  map.computeIfAbsent(2,(k)->new HashMap<>());
     //   m2.put(6,9);
        System.out.println(map);
        int n=20210;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=i+21&&j<=n;j++){
                int w =i*j/GCD(i,j);
                HashMap<Integer,Integer> m =  map.computeIfAbsent(i,(k)->new HashMap<>());
                m.put(j,w);
                HashMap<Integer,Integer> m2 =  map.computeIfAbsent(j,(k)->new HashMap<>());
                 m2.put(i,w);
            }
        }
        int dist[]=dijiskra(map,1,n);
        System.out.println(dist[n]);
        long e =System.currentTimeMillis();
        System.out.println("time: "+(e-s));
    }
    public static  int GCD(int x,int y){
        int a = Math.min(x,y);
        int b = Math.max(x,y);
        while (b%a!=0){
            int c = b%a;
            b = a;
            a = c;
        }
        return  a;
    }
    public  static int[] dijiskra(HashMap<Integer, HashMap<Integer, Integer>> map, int source,int n) {
        int dist[]=  new int[n+1];
        int pre [] = new int[n+1];
        boolean  vis [] = new boolean[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
       // vis[source]=true;
        dist[source]=0;
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[1]-b[1]);
        que.offer(new int[]{source,0});
        while (!que.isEmpty())
        {
            int node[] =que.poll();
            int from=  node[0];
            //int wiiht = node[1];
            if(vis[from]) continue;
            vis[from]=true;
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



}
