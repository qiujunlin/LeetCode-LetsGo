package leetcode;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/5
 */
public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        LinkedList<Integer> list = new LinkedList();
        Set<Integer> set = new HashSet();
        dfs(nums,list,res,set);
        return res;
    }
    void dfs(int nums[],LinkedList<Integer> list,List<List<Integer>> res, Set<Integer> set){
        if(list.size()==nums.length){
            res.add(new LinkedList(list));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            list.offer(nums[i]);
            dfs(nums,list,res,set);
            list.removeLast();
            set.remove(nums[i]);
        }
    }
}
