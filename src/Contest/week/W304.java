package Contest.week;

import edu.princeton.cs.algs4.In;
import sun.plugin.javascript.navig4.Link;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class W304 {
    public static void main(String[] args) {
        System.out.println("dsa");
    }
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int c =0;
        while (nums[nums.length-1]!=0){
            int min =0;
            for (int i = 0; i <nums.length ; i++) {
                if(nums[i]!=0) {
                    min =nums[i];break;
                }
            }
            for (int i = 0; i <nums.length ; i++) {
                if(nums[i]!=0) {
                    nums[i] -= min;
                }
            }
            c++;

        }
        return  c;


    }
    public int maximumGroups(int[] grades) {
        int  res =1;
        long i =1;
        while (i*2+1<=grades.length){
            res++;
            i = i*2+1;
        }
        return  (int)i;

    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer,Integer> map =new HashMap<Integer, Integer>();
        for (int i = 0; i <edges.length ; i++) {
            if(edges[i]!=-1){
                map.put(i,edges[i]);
            }
        }
        LinkedList<Integer> q1 =new LinkedList<>();
        LinkedList<Integer> q2 =new LinkedList<>();
        q1.offerLast(node1);
        q2.offerLast(node2);
        HashSet<Integer> set =new HashSet<>();
        set.add(node1);
        set.add(node2);
        while (!q1.isEmpty()||!q2.isEmpty()){
            int size = q1.size();
            for (int i = 0; i <size ; i++) {
                Integer cur = q1.pollFirst();
                Integer next = map.get(cur);
                if(next==null) continue;
                if(set.contains(next)) return  next;
                set.add(next);
                q1.offerLast(next);
            }
             size = q2.size();
            for (int i = 0; i <size ; i++) {
                Integer cur = q2.pollFirst();
                Integer next = map.get(cur);
                if(next==null) continue;
                if(set.contains(next)) return  next;
                set.add(next);
                q2.offerLast(next);
            }
        }
        return   -1;

    }
    public int longestCycle(int[] edges) {
          HashMap<Integer,Integer> map =new HashMap<>();
          int in[] = new int[edges.length];
          for (int i = 0; i <edges.length ; i++) {
            if(edges[i]!=-1 ){
                map.put(i,edges[i]);
                in[edges[i]]++;
            }
          }
          HashSet<Integer> set =new HashSet<>();
        LinkedList<Integer> l =new LinkedList<>();
        for (int i = 0; i <edges.length ; i++) {
            if(in[i]==0 ){
                set.add(i);
                l.addFirst(i);
            }
        }
        while (!l.isEmpty()){
            int a =l.pollFirst();
            Integer next = map.get(a);
            if(next==null)continue;
            in[next]--;
            if(in[next]==0){
                set.add(next);
                l.addLast(next);
            }
        }
        int max =0;
        for (int i = 0; i < in.length; i++) {
            if(in[i]!=0){
                dfs(map,i,set,0);
            }
        }
        return  max;



    }
    int max =0;

    private void dfs(HashMap<Integer, Integer> map, int i, HashSet<Integer> set,int len) {
        if(set.contains(i)){
            max =Math.max(len,max);
            return;
        }
        set.add(i);
        System.out.println(i);
        dfs(map,map.get(i),set,len+1);
    }
}
