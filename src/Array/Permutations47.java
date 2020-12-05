package Array;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/5
 */
public class Permutations47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList();
        Arrays.sort(nums);
        boolean bo[]=new boolean[nums.length];
        dfs(nums,list, res,bo);
        return res;
    }
    private void dfs(int[] nums,LinkedList<Integer> list, List<List<Integer>> res,boolean bo[]) {
        if (list.size()==nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 重点理解这里从 begin 开始搜索的语意
        for (int i = 0; i < nums.length; i++) {
            if(bo[i]==true) continue;
            if(!judege(bo,nums,i)) continue;
            bo[i]=true;
            list.offer(nums[i]);
            dfs(nums,list,res,bo);
            list.removeLast();
            bo[i]=false;;
        }
    }
    private boolean judege(boolean bo[],int nums[],int i){
        for(int j=0;j<i;j++){
            if(nums[j]==nums[i]&&bo[j]==false) return false;
        }
        return true;
    }
}
