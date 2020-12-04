package Tree;

import java.util.*;

/**
 * @Classname InvertBinaryTree226
 * @Description:
 * @Date 2020/11/6 15:07
 * @Created by qiujunlin
 */
public class InvertBinaryTree226 {
    //前序遍历
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp= root.left;
        root.left= root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    //后序遍历

    public TreeNode invertTree2(TreeNode root) {
        if(root==null) return null;
        TreeNode left= invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left=right;root.right=left;
        return root;
    }
}
