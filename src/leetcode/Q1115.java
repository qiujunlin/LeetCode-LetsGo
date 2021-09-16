package leetcode;
import java.util.*;
public class Q1115 {
    int f = 0;
    int d = 0;
    HashMap<String,Integer> map = new HashMap<>();
    public int numRollsToTarget(int d, int f, int target) {
        f =f;
        d= d;
        return  dfs(0,target);
    }

    private int dfs(int i, int target) {
       if(i==d&&target<=f){
           return  1;
       }
       if(target<=0){
           return  0;
       }
       if(i>d) return 0;

       int count  =0;
       String key  = i+"_"+target;
       if(map.containsKey(key)) return map.get(key);
        for (int j = 1; j <= f; j++) {
            count+=dfs(i+1,target-j);
        }
        map.put(key,count);
        return  count;

    }
}
