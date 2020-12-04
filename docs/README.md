进击的小番茄 算法学习之路

> 

记录自己的leetcode刷题过程。

目标：

1. 保持每天一道题，更新仓库，开始更新仓库时间：2010.9.20

2. 每个周末参与周赛，开始参加比赛时间：2020.11.8
3. 每个周末把每周做的题总结一遍，把题目链接到 ReadMe上
4. 每个月对之前做的题看看，记一下模板
5. 2021.9.20 号，所有类型都保证刷一遍。

## leetcode

| 题号 |                             标题                             |                             题解                             | 难度   |
| ---- | :----------------------------------------------------------: | :----------------------------------------------------------: | ------ |
| 1    |                           两数之和                           |                             hash                             | easy   |
| 3    |                     无重复字符的最长子串                     |                           滑动窗口                           | Middle |
| 31   |                          下一个排列                          |                          传统技巧题                          |        |
| 50   |                           Pow(x,y)                           |                            指数幂                            |        |
| 53   |                          最大子序和                          |                           动态规划                           | Easy   |
| 56   | [插入区间](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/MergeIntervals56.java) |                             排序                             |        |
| 57   | [插入区间2](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/InsertInterval57.java) |                   排序，遍历插入（双指针）                   |        |
| 62   |                           不同路径                           |                           动态规划                           | Middle |
| 63   |                          不同路径II                          |                           动态规划                           | Middle |
| 64   |                          最小路径和                          |                           动态规划                           |        |
| 70   |                            爬楼梯                            |                           动态规划                           |        |
| 94   | [二叉树中序遍历](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/BinaryTreeInorderTraversal94.java) |                         迭代 ，递归                          |        |
| 95   | [不同的二叉树搜索树](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/UniqueBinarySearchTreesII95.java)ii |                        递归，动态规划                        |        |
| 96   | [不同的二叉搜索树](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/UniqueBinarySearchTrees96.java) |                        递归，动态规划                        |        |
| 98   |                        验证二叉搜索树                        |                           中序遍历                           |        |
| 99   |                        恢复二叉搜索树                        |                          迭代，递归                          |        |
| 100  | [相同的树](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/SameTree100.java) |                           递归，BF                           |        |
| 101  | [对称二叉树](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/SymmetricTree101.java) |                          递归，迭代                          |        |
| 102  | [二叉树的层序遍历](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/BinaryTreeLevelOrderTraversal102.java) |                          递归，迭代                          |        |
| 103  | [二叉树锯齿遍历](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/BinaryTreeZigzagLevelOrderTraversal.java) |                             BFS                              |        |
| 104  | [二叉树的最大深度](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/MaximumDepthofBinaryTree104.java) |                          递归。迭代                          |        |
| 105  | [前序遍历与中序遍历构造二叉树](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/ConstructBinaryTreefromPreorderandInorderTraversal105.java) |                             递归                             |        |
| 106  | [中序遍历与后序遍历构造二叉树](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/ConstructBinaryTreefromInorderandPostorderTraversal106.java) |                             递归                             |        |
| 107  | [二叉树层序遍历2](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/BinaryTreeLevelOrderTraversalII107.java) |                             BFS                              |        |
| 108  | [将有序数组转化为二叉搜索树](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/ConvertSortedArraytoBinarySearchTree108.java) |                             递归                             |        |
| 110  | [平衡二叉树](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/BalancedBinaryTree.java) |                                                              |        |
| 111  |                       二叉树的最小深度                       | [递归](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/) |        |
| 112  | [路径总和](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/PathSum112.java) |                                                              |        |
| 113  | [路径总和2](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/PathSumII113.java) |                                                              |        |
| 114  | [二叉树展开为链表](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/FlattenBinaryTreetoLinkedList114.java) |                                                              | Easy   |
| 116  | [填充每个节点的下一个右侧节点指针](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/PopulatingNextRightPointersinEachNode116.java) |                                                              |        |
| 117  | [填充每个节点的下一个右侧节点指针2](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/PopulatingNextRightPointersinEachNodeII117.java) |                                                              |        |
| 120  |                      三角形的最小路径和                      |                           动态规划                           |        |
| 121  | [卖股票的最佳时机](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/BestTimetoBuyandSellStock121.java) |                             遍历                             |        |
| 122  | [卖股票的最佳时机II](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/BestTimetoBuyandSellStockII122.java) |                           遍历技巧                           |        |
| 124  |                     二叉树中的最大路径和                     | [递归](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/shou-hui-tu-jie-hen-you-ya-de-yi-dao-dfsti-by-hyj8/) | Hard   |
| 129  | [求根到叶子节点数字之和](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/SumRoottoLeafNumbers129.java) |                                                              |        |
| 144  | [二叉树前序遍历](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/BinaryTreePreorderTraversal144.java) |                                                              |        |
| 145  | [二叉树的后序遍历](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/BinaryTreePostorderTraversal145.java) |                       递归，迭代，翻转                       |        |
| 173  |                       二叉搜索树迭代器                       |                中序遍历 ，使用栈模拟中序遍历                 |        |
| 198  |                           打家劫舍                           |                           动态规划                           |        |
| 199  | [二叉树右视图](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/BinaryTreeRightSideView199.java) |                             bfs                              |        |
| 206  | [反转链表](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/LinkedList/ReverseLinkedList206.java) |                     迭代（双指针），递归                     |        |
| 231  |                          打家劫舍II                          |                           动态规划                           |        |
| 222  | [完全二叉树的节点个数](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/CountCompleteTreeNodes.java) |                                                              |        |
| 226  | [反转二叉树](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/InvertBinaryTree226.java) |                      递归（前序/后序）                       |        |
| 230  |                     二叉树中第K小的元素                      |                         迭代 ，递归                          | Middle |
| 234  | [判断是否是回文链表](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/LinkedList/PalindromeLinkedList234.java) |                    双指针，反转+快慢指针                     |        |
| 235  |                     二叉树的最近公共祖先                     |                                                              |        |
| 236  | [二叉树最近公共祖先](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/LowestCommonAncestorofaBinaryTree236.java) |                                                              |        |
| 322  |                           零钱兑换                           |                           动态规划                           | Middle |
| 349  | [两个数组交集](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/IntersectionofTwoArrays349.java) |                           双指针，                           |        |
| 340  | [两个数组的交集\|\|](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/IntersectionofTwoArrays350.java) |                         双指针，map                          |        |
| 450  |                     在二叉搜索树种删节点                     |                          递归，迭代                          |        |
| 508  |                   出现次数最多的子树元素和                   | [递归排序](https://leetcode-cn.com/problems/most-frequent-subtree-sum/solution/java-liang-ge-90xiao-ji-qiao-by-qiujunlin/) | Middle |
| 509  |                           斐波那契                           |             动态规划，递归（由上到下，由下到上）             | Easy   |
| 513  |                        找树左下角的值                        |                                                              |        |
| 637  |                    二叉树的层序遍历平均值                    |                           层序遍历                           | easy   |
| 654  | [最大二叉树](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/MaximumBinaryTree654.java) |                           递归构造                           |        |
| 865  |                 具有所有最深节点的最小子树)                  |                          后序，前序                          | Middle |
| 876  | [链表中间节点](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/LinkedList/MiddleoftheLinkedList876.java) |                        迭代  ，双指针                        |        |
| 922  |                      按奇偶数组排序\|\|                      |                  使用额外数组 ，使用双指针                   |        |
| 946  | [有效的 山脉数组](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/ValidMountainArray946.java) |                            双指针                            |        |
| 976  |                       三角形的最大周长                       |                             遍历                             | Easy   |
| 998  | [最大二叉树II](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Tree/MaximumBinaryTreeII998.java) |                             递归                             |        |
| 1022 |                    从根到叶的二进制数之和                    |                           使用递归                           |        |
| 1122 |                        数组的相对排序                        |                        常规解法 遍历                         | easy   |
| 1123 |                   最深叶节点的最近公共祖先                   |                             后序                             | Middle |
| 1207 | [独一无二的出现次数](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/UniqueNumberofOccurrences1207.java) |                           java集合                           |        |
| 1356 | [按照二进制1的个数排序](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/SortIntegersbyTheNumberof1Bits1356.java) |                        排序，巧妙方法                        |        |
| 1365 | [有多少小于当前数字的数字](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/HowManyNumbersAreSmallerThantheCurrentNumber1365.java) |                    计数排序，额外数组排序                    |        |
| 1370 |                        上升下降字符串                        |                                                              |        |
| 1572 | [矩阵的对角线和](https://github.com/qiujunlin/LeetCode-LetsGo/blob/master/src/Array/MatrixDiagonalSum1572.java) |                       暴力，一次性遍历                       |        |



周赛

 

| 周赛 | 题目编号 | 题名                       | 难度   | 题解 |
| ---- | -------- | -------------------------- | ------ | ---- |
| 213  | 1640     | 能否连接形成数组           | easy   |      |
| 214  | 1646     | 获取生成数组中的最大值     | easy   |      |
| 241  | 1647     | 字符频次唯一的最小删除次数 | middle |      |
| 215  | 5601     | 设计有序流                 | easy   |      |
| 215  | 5603     | 确定两个字符串是否接近     | middle |      |

| 场次 | 题目编号 | 题名           | 难度   | 题解 |
| ---- | -------- | -------------- | ------ | ---- |
| 38   | 5550     | 踩炸弹         | middle |      |
| 40   | 5557     | 最大重复字符串 |        |      |
| 40   | 5558     | 合并两个链表   |        |      |
| 40   | 5560     | 设计前中后队列 |        |      |
| 40   |          |                |        |      |

剑指OFFER

|      |      |      |
| ---- | ---- | ---- |
|      |      |      |
|      |      |      |
|      |      |      |
