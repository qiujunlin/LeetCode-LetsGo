package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q77 {
    public List<List<Integer>> combine(int n, int k) {
        int nums[] = new int[n];
        List<List<Integer>> list  = new ArrayList<>();
        Deque<Integer> l = new LinkedList<>();
        dfs(list,l,0,k,n);
        return  list;

}

    private void dfs(List<List<Integer>> list, Deque<Integer> l, int index, int k,int n) {
      if(k==0) list.add(new LinkedList<>(l));
      for(int i=index+1;i<=n;i++){
          l.add(i);
          dfs(list,l,i,k-1,n);
          l.removeLast();
      }
    }

}
