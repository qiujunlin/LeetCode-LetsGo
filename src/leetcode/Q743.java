package leetcode;
import  java.util.*;
public class Q743 {
        public int networkDelayTime(int[][] times, int n, int k) {
            HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
            for(int a[]:times){
                map.computeIfAbsent(a[0],(key)->new HashMap<>()).put(a[1],a[2]);
            }

            int dis[] = new int[n+1];
            boolean vis[] = new boolean[n+1];
            dijs(map,dis,vis,k);
            int max =0;
            for(int i =1;i<=n;i++){
               if(!vis[i]) return -1;
              max = Math.max(dis[i],max);
            }
            return  max;
        }

        private void dijs(HashMap<Integer, HashMap<Integer, Integer>> map, int[] dis, boolean vis[],int k) {
            Arrays.fill(dis,Integer.MAX_VALUE);
            PriorityQueue<int []> queue = new PriorityQueue<>();
            dis[k] = 0;
            queue.offer(new int[]{k,0});
            while (!queue.isEmpty()){
                int edge[] = queue.poll();
                if(vis[edge[0]]) continue;
                vis[edge[0]] = true;
                HashMap<Integer,Integer> ma = map.get(edge[0]);
                for(int key:ma.keySet()){
                    if(dis[key]<dis[k]+ma.get(key)){
                        dis[key] = dis[k]+ma.get(key);
                        queue.offer(new int[]{key,dis[key]});
                    }
                }
            }
        }
}
