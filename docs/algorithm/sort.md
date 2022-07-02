# 推快排的时间复杂度



Arrays。sort底层使用了什么插入排序，快速排序，归并排序三种排序的组合

[排序](https://www.nowcoder.com/jump/super-jump/word?word=排序)[算法](https://www.nowcoder.com/jump/super-jump/word?word=算法)的稳定性：序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，即在原序列中，r[i]=r[j]，且r[i]在r[j]之前，而在排序后的序列中，r[i]仍在r[j]之前，则称这种排序算法是稳定的；否则称为不稳定的。

快速排序复杂度证明？

因此只要每次pivot分成的两段是O(N)的，快排的[递归层数](https://www.zhihu.com/search?q=递归层数&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A"629313891"})就是O(lgN)，而每层是固定O(N)的，所以这种情况快排复杂度就是O(NlgN)



![img](https://cdn.nlark.com/yuque/0/2022/png/12764359/1644736215025-d8a68344-2bd8-4cb7-adf1-7909536028f2.png)



# **哈夫曼树 最优二叉树**

给定N个权值作为N个[叶子结点](https://baike.baidu.com/item/叶子结点/3620239)，构造一棵二叉树，若该树的带权路径长度达到最小，夫曼树是带权路径长度最短的树，权值较大的结点离根较近。



**找出****存放一串字符所需的最少的二进制编码**

**首先统计出每种字符出现的****频率****！（也可以是概率）//权值**

**根据频率去构建一棵树，每次选择节点最小的两个值**

**根据结果获取 每个字母的编码  左边是0 右边是1** 