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



解释语句: if cur > begin and candidates[cur-1] == candidates[cur] 是如何避免重复的。摘抄来自[leetcode](https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/225211)

```
这个避免重复当思想是在是太重要了。
这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
                  1
                 / \
                2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
               /     \
              5       5
                例2
                  1
                 /
                2      这种情况确是允许的
               /
              2  
                
为何会有这种神奇的效果呢？
首先 cur-1 == cur 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。 
因为当第二个2出现的时候，他就和前一个2相同了。
                
那么如何保留例2呢？
那么就用cur > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
例2的两个2是处在不同层级上的。
在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
第一个出现的2的特点就是 cur == begin. 第二个出现的2 特点是cur > begin.
```

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

这道题的思路就是回溯 ，和组合总和的思路一样，就是把每一个数字都要遍历到，但是遍历的顺序不一样。每个数字的使用次数也只能为1 。

组合总和用来保存遍历状态的方法是使用了排序和下标的操作，有点像零钱兑换，下标的不断增加，这样之前的就遍历过，之后的就没被遍历。而全排列不许要被排序，一个数访问了，它之前的数可能还没有被访问。因此可以使用一个状态数组 Boolean dp[] 来保存，也可以使用一个Set来保存已经遍历过的数字，方法也是一样，不过速度要慢很多。

```java
 public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> res = new ArrayList();
         LinkedList<Integer> list = new LinkedList();
         boolean bo[]= new boolean[nums.length+1];
        dfs(nums,list,res,bo);
        return res; 
    }
    void dfs(int nums[],LinkedList<Integer> list,List<List<Integer>> res, boolean bo[]){
        if(list.size()==nums.length){
            res.add(new LinkedList(list));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(bo[i]==true) continue;
            bo[i]=true;
            list.offer(nums[i]);
            dfs(nums,list,res,bo);
            list.removeLast();
            bo[i]=false;
        }
    }
```



## 47. 全排列 II

 这道题日和46题全排列的区别在于  46题的数组中没有重复的元素，全排列的结果中没有重复值，这道题的数组中有重复值，如果按照46题的方法来做 肯定 会有重复的值。

这道题的难点在于 如何对结果进行去重复。

1. ###### 方法一  使用set去重，set可以对list集合去重 但是效率jid

2. ###### 方法二  使用排序比较的方法。 

   ```
   if(i>0&&nums[i]==nums[i-1]&&bo[i-1]==false) continue;
   ```

   这句话 代表的意思是  在在当前的循环内，如果a和b挨着的，且a=b  那么如果访问 a  ，接着访问b是没有问题的。如果访问b，先判断a是否被访问过，如果a没有被访问，那么结果和先访问a的结果是一样的，直接continueb、 剪纸，如果a访问过了，说明顺序是对的，直接访问。这样就可以保证结果是相同的 。 

   这道题  的去重方法可以和组合总和2 的排序方法进行一个比较。加深印象

代码

```java
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
            if(i>0&&nums[i]==nums[i-1]&&bo[i-1]==false) continue;
            bo[i]=true;
            list.offer(nums[i]);
            dfs(nums,list,res,bo);
            list.removeLast();
            bo[i]=false;;
        }
    }
```



## 78. 子集

代码：

```java
  public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList();
        LinkedList<Integer> list = new LinkedList();
        dfs(nums,0,res,list);
        return res;
    }
    void dfs(int []nums,int left,List<List<Integer>> res,LinkedList<Integer> list){
           if(list.size()<=nums.length) {
               res.add(new ArrayList(list));
           }else return;
           for(int i=left;i<nums.length;i++){
                list.offer(nums[i]);
                dfs(nums,i+1,res,list);
                list.removeLast();
           }
    }
```



## 90.子集 II