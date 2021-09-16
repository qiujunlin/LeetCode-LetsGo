package leetcode;
import  java.util.*;
public class Q40 { public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> list  = new ArrayList<>();
    Deque<Integer> l = new LinkedList<>();
    boolean vis[] = new boolean[candidates.length];
    dfs(list,l,candidates,0,target,vis);
    return  list;
}
    private void dfs(List<List<Integer>> list, Deque<Integer> l, int candidates[],int index, int k,boolean vis[]) {
        if(k==0) list.add(new LinkedList<>(l));
        if(k<0) return;
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]==candidates[i-1]&&!vis[i]) continue;
            if(candidates[i]>k) return;
            vis[i] = true;
            l.add(candidates[i]);
            dfs(list,l,candidates,i+1,k-candidates[i],vis);
            l.removeLast();
            vis[i] =false;
        }
    }
}