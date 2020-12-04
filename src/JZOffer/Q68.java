package JZOffer;

import java.util.*;

/**
 * @Classname Q68
 * @Description:
 * @Date 2020/11/11 9:57
 * @Created by qiujunlin
 */
public class Q68 {
    //击败百分之50 适用于不是二叉树搜索树 适用于所有二叉搜索树
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        return postorder(root,p,q);
    }
    TreeNode postorder(TreeNode node,TreeNode p,TreeNode q){
        if(node==null)  return  null;
        if(node==p)   return node;
        if(node==q) return node;
        TreeNode left=postorder(node.left,p,q);
        TreeNode right =  postorder(node.right,p,q);
        if(right!=null&&left!=null)  return node;
        if(left!=null) return left;
        if(right!=null) return right;
        return null;
    }
    //适用于二叉搜索树 迭代的方法 这个方法是最慢的 超过了百分之10
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val<p.val&&root.val<q.val)  root=root.right;
            else if (root.val>p.val&&root.val>q.val)  root=root.left;
            else break;
        }
        return root;
    }
    //适用于二叉搜索树  适用递归 这个方法是最快的方法 超过了百分之百   前序遍历
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val<p.val&&root.val<q.val)  return  lowestCommonAncestor(root=root.right,p,q);
        if(root.val>p.val&&root.val>q.val)  return  lowestCommonAncestor(root=root.left,p,q);
        return root;
    }
}
