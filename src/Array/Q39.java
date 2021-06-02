package Array;
import  java.util.*;
public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list  = new ArrayList<>();
        Deque<Integer> l = new LinkedList<>();
        dfs(list,l,candidates,0,target);
        return  list;
    }
    private void dfs(List<List<Integer>> list, Deque<Integer> l, int candidates[],int index, int k) {
        if(k==0) list.add(new LinkedList<>(l));
        if(k<0) return;
        for(int i=index+1;i<candidates.length;i++){
            l.add(candidates[i]);
            dfs(list,l,candidates,i,k-candidates[i]);
            l.removeLast();
        }
    }
}
