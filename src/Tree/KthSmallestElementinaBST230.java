package Tree;

import java.util.*;

/**
 * @Classname KthSmallestElementinaBST230
 * @Description:
 * @Date 2020/11/13 20:38
 * @Created by qiujunlin
 */
public class KthSmallestElementinaBST230 {
    //第一种解法很容易就想出来
    int res=0;
    int i=0;
    public int kthSmallest(TreeNode root, int k) {
        i=k;;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root ){
        if(root==null) return;
        dfs(root.left);
        if(i==1) res=root.val;//如果说k=1 说明第-1k个元素被访问过了，现在要访问第k个
        i--;
        dfs(root.right);
    }
    //递归  超过百分之58
    /**不知道为什么要慢一些  ，
     * 使用迭代的好处就是只要找到了第k个节点 就可以直接跳出循环，
     * 不用对树种的每一个节点都要遍历，但是不知道为什么比递归还要慢一些？
     * 黑人问号？？？？？？
     **/
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null||stack.size()!=0){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node = stack.pop();
            if(k--==1) return node.val;
            cur = node.right;
        }
        return 0;
    }
}
