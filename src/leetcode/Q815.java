package leetcode;
import  java.util.*;
public class Q815 {
    public static void main(String[] args) {
        HashMap<Integer,HashSet<Integer>> map  = new HashMap<>();
        map.put(1,new HashSet<>());
        map.get(1).add(1);
        map.computeIfAbsent(1,(keu)->new HashSet<>()).add(2);
        System.out.println(map);

    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,HashSet<Integer>> map  = new HashMap<>();
        HashMap<Integer,Integer>  m  = new HashMap<>();
        Deque<Integer> deque= new LinkedList<>();
        for (int i = 0; i < routes.length; i++) {
            for(int j : routes[i]){
                if(j==source){
                    deque.offer(i);
                    m.put(i,1);
                }
                map.computeIfAbsent(j,(key)->new HashSet<>()).add(i);
            }
        }
        while (!deque.isEmpty()){//不存在层次遍历的问题 因为已近用哈是map记录了层次
            int bian =  deque.poll();
            int count  = m.get(bian);
            for(int a :  routes[bian]){//遍历这一条边上的每一个点，将当前点有公交车的加入进来
                if(a ==  target) return  bian;
                HashSet<Integer> set  = map.get(a);
                if(set.isEmpty()) continue;
                for(Integer c  :  set){//遍历每一条边
                    if(m.containsKey(c)) continue;
                     m.put(a,count+1);
                     deque.offer(a);
                }
            }
        }
        return   -1;


    }
}
