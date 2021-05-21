package WeeklyContest.acwing;

import java.util.*;

/**
 * @Classname Main
 * @Description:
 * @Date 2021/5/5 21:53
 * @Created by qiujunlin
 */
public class Main {
    public static void main(String[] args) {
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String ,Integer> map = new HashMap();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> que =
                new PriorityQueue<Map.Entry<String,Integer>>((o1,o2)->o1.getValue()-o2.getValue());
        for(Map.Entry<String,Integer> entry:map.entrySet()) {
            que.offer(entry);
            if(que.size()>k) que.poll();
        }
        List<String> res = new ArrayList();
        while(!que.isEmpty()){
            res.add(que.poll().getKey());
        }
        return res;
    }
}
