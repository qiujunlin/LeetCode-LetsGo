package Tree;

import java.util.*;

/**
 * @Classname SmallestSubtreewithalltheDeepestNodes865
 * @Description:
 * @Date 2020/11/17 19:24
 * @Created by qiujunlin
 */
public class SmallestSubtreewithalltheDeepestNodes865 {
    TreeNode res = null;
    int pre=0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root,0);
        return res;

    }
    int dfs(TreeNode  node,int depth){
        if(node==null) return depth;
        int left=dfs(node.left,depth+1);
        int right =dfs(node.right,depth+1);
        if(left==right&&left>=pre){
            res=node;
            pre=left;
        }
        return Math.max(left,right);
    }
    //前序遍历
    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        if(root==null) return null;
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(left==right) return root;
        else if(left<right) return lcaDeepestLeaves(root.right);
        return lcaDeepestLeaves(root.left);
    }
    int dfs(TreeNode  node){
        if(node==null) return 0;
        return 1+Math.max(dfs(node.right),dfs(node.left));
    }
}
