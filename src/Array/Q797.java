package Array;
import  java.util.*;
public class Q797 {
    List<List<Integer>> res  =new LinkedList<>();
    int len =0;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        len = graph.length;
        HashMap<Integer,List<Integer>> map  = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i,new ArrayList<>());
            for (int j = 0; j <graph[i].length ; j++) {
                map.get(i).add(graph[i][j]);
            }
        }
        LinkedList<Integer> list  = new LinkedList<>();
        list.add(0);
        dfs(0,map,list);
        return  res;
    }
    private void dfs(int i, HashMap<Integer, List<Integer>> map, LinkedList<Integer> list) {
        if(i==len-1){
            res.add(new LinkedList<>(list));
            return;
        }
        for (int n : map.get(i)){
            list.add(n);
            dfs(n,map,list);
            list.removeLast();
        }
    }
}
