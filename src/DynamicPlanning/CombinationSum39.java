package DynamicPlanning;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/4
 */
public class CombinationSum39 {
    List<List<Integer>>  res ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> list= new LinkedList<>();
        res= new ArrayList<>();
        dfs(candidates,target,list);
        return res;
    }
    void dfs(int []candidates,int target,LinkedList<Integer> list){
        if(target==0) {
            res.add(new ArrayList(list));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=0;i<candidates.length;i++){
            if(list.size()!=0&&list.getLast()>candidates[i]) continue;
            list.add(candidates[i]);
            dfs(candidates,target-candidates[i],list);
            list.removeLast();
        }
    }
}
