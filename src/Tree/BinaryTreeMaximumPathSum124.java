package Tree;

import java.util.*;

/**
 * @Classname BinaryTreeMaximumPathSum124
 * @Description:
 * @Date 2020/11/13 19:56
 * @Created by qiujunlin
 */
public class BinaryTreeMaximumPathSum124 {
    int maxsum=Integer.MIN_VALUE;//定义全局的最大值
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxsum;
    }
    int dfs(TreeNode root){
        if(root==null) return 0;
        int left = dfs( root.left);
        int right = dfs(root.right);
        //计算当前树的最大值
        maxsum = Math.max(maxsum,left+right+root.val);
        return (Math.max(left,right)+root.val)<0?0:(Math.max(left,right)+root.val);
    }

    public static void main(String[] args) {
        TreeNode noe1 = new TreeNode(1);
        TreeNode noe2 = new TreeNode(2);
        TreeNode noe3 = new TreeNode(3);
        noe1.left=noe2;
        noe1.right=noe3;
        System.out.println(new BinaryTreeMaximumPathSum124().maxPathSum(noe1));
    }
}
