package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/5
 */
public class CombinationSum40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, list, res);
        return res;
    }
    private void dfs(int[] candidates, int begin, int target, LinkedList<Integer> list, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < candidates.length; i++) {
            //大减枝
            if(target-candidates[i]<0) break;
            //小减枝
            if(i>begin&&candidates[i]==candidates[i-1]) continue;
            list.addLast(candidates[i]);

            dfs(candidates, i+1, target - candidates[i], list, res);
            // 状态重置
            list.removeLast();
        }
    }

}
