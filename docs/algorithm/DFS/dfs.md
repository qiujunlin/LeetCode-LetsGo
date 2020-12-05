 回溯算法 

## 39. 组合总和

#### 回溯算法 + 剪枝

1. 结束条件 

    1.1  target<0  结束，结果集不保存

    1.2   target=0 刚好合适，将结果集保存在里面

2.  递归步骤  

    2.1  循环遍历数组  如果当前数组的值 大于目标值 无法分配 直接返回 

   2.2 更新target 更新begin ，list加入结果 继续递归

    2.3  递归完成 list删除刚刚加入的结果    减枝 

剪枝提速  将数组进行排序  也就是步骤2.1

[题解](https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/)

```java
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
```

## 40. 组合总和 II

这道题的思路和组合总和的思路一样，但是也有区别

上一道题39题的思路是选取的数字在下一层递归的时候可以再次被选取

这道题的要点是上一次被选取的、数字这一次不能被选取，同时在同一层递归的数字中 不能有相同的数字 。因此这道题要比上一道题多一次减枝。

难点在于如何去重，

代码：

```java
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
```



## 46. 全排列

## 47. 全排列 II

## 78. 子集

## 90.子集 II