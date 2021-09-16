package leetcode;

import java.util.*;

public class Q46 {
    List<List<Integer>>  res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    boolean vis [];
    public List<List<Integer>> permute(int[] nums) {
        vis = new boolean[nums.length];
        dfs(nums);
        return  res;

    }

    private void dfs(int[] nums) {
      if(list.size()==nums.length) res.add(new ArrayList<>(list));
      for(int j  =0;j<nums.length;j++){
          if(vis[j]) continue;
          list.add(nums[j]);
          vis[j]= true;
          dfs(nums);
          vis[j]= false;
      }
    }
}
