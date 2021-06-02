package acwing;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Q1207 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i=0;i<n-1;i++){
            int from = scanner.nextInt();
            int to= scanner.nextInt();
            int w = scanner.nextInt();
            HashMap<Integer,Integer> m = map.computeIfAbsent(from,(key)->new HashMap<>());
            m.put(to,w);
            HashMap<Integer,Integer> m2= map.computeIfAbsent(to,(key)->new HashMap<>());
            m.put(from,w);
        }
        int dis[] = new int[n+1];
       // dfs(dis,-1,1,0,map);
        bfs(dis,0,map);
        int sourece =0;
        for (int i = 1; i < dis.length; i++) {
            if(dis[i]>sourece){
                sourece =  i;
            }
        }
        //dfs(dis,-1,sourece,0,map);
        bfs(dis,sourece,map);
        int max  =0;
        for (int i = 0; i < dis.length; i++) {
            max =Math.max(max,dis[i]);
        }
        int sum =0;
        for(int i=1;i<=max;i++){
            sum=sum+i+10;
        }
        System.out.println(sum);


    }
     static void dfs(int dis[],int pre,int v,int w,HashMap<Integer,HashMap<Integer,Integer>> map){
        dis[v] = w;
        HashMap<Integer,Integer> m =  map.get(v);
        for(int key:m.keySet()){
            if(key!=pre){
                dfs(dis,pre,key,w+m.get(key),map);
            }
        }
        return;
    }
    static  void bfs(int dis[],int v,HashMap<Integer,HashMap<Integer,Integer>> map ){
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(v);
        while (!deque.isEmpty()){
            int num =  deque.pollFirst();
            HashMap<Integer,Integer> m =  map.get(num);
            for(int key : m.keySet()){
                if(key!=num){
                    deque.offer(key);
                    dis[key]  = m.get(key) +  dis[num];
                }
            }
;        }
    }
}
