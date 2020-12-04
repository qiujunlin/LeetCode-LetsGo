package Tree;

import java.util.*;

/**
 * @Classname LowestCommonAncestorofaBinarySearchTree235
 * @Description:
 * @Date 2020/11/15 14:04
 * @Created by qiujunlin
 */
public class LowestCommonAncestorofaBinarySearchTree235 {
    //第一种方法和二叉树的最近公共祖先的方法一样  但是没有 利用到二叉搜索树的性质
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val||root.val==q.val) return root;
        TreeNode left= lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,q,p);
        if(left!=null&&right!=null) return root;
        if(left==null) return right;
        if(right==null) return left;
        return null;
    }
    //使用迭代  充分利用了二叉搜索树的性质，这种方法很快

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while((root.val<p.val&&root.val<q.val)||(root.val>p.val&&root.val>q.val)){
            root=root.val>p.val?root.left:root.right;
        }
        return root;

    }
    //第三种 递归的方法   很实用  理解简单
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

        if((root.val<p.val&&root.val<q.val)||(root.val>p.val&&root.val>q.val)){
            return lowestCommonAncestor(root.val>p.val?root.left:root.right,p,q);
        }
        return root;

    }

}
