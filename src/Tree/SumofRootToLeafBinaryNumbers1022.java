package Tree;

import java.util.*;

/**
 * @Classname SumofRootToLeafBinaryNumbers1022
 * @Description:
 * @Date 2020/11/11 9:10
 * @Created by qiujunlin
 */
public class SumofRootToLeafBinaryNumbers1022 {
    //前序遍历
    int res;
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        preorder(root,0);
        return res;
    }
    void preorder(TreeNode node,int sum){
        if(node.left==null&&node.right==null){
            res=res+sum*2+node.val;
            return;
        }
        if(node.left!=null) preorder(node.left,sum*2+node.val);
        if(node.right!=null) preorder(node.right,sum*2+node.val);
    }
}
