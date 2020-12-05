package Array;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/5
 */
public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, list, res);
        return res;
    }

    /**
     * @param candidates  数组
     * @param begin   开始的位置，也就是下次遍历的开始位置
     * @param target  目标值
     * @param list    当前的结果
     * @param res  最终结果
     */
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
            if(target-candidates[i]<0) break;
            list.addLast(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, target - candidates[i], list, res);
            // 状态重置
            list.removeLast();
        }
    }
}
