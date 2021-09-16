package leetcode;
import  java.util.*;
public class    Q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list  = new ArrayList<>();
        Deque<Integer> l = new LinkedList<>();
        int sum =  n;
        dfs(list,l,0,k,10,sum);
        return  list;

    }
    private void dfs(List<List<Integer>> list, Deque<Integer> l, int index, int k,int n,int sum) {
        if(k==0&&sum==0) list.add(new LinkedList<>(l));
        if(k<0) return;
        if(sum<0) return;
        for(int i=index+1;i<=n;i++){
            l.add(i);
            dfs(list,l,i,k-1,n,sum-i);
            l.removeLast();
        }
    }
}
