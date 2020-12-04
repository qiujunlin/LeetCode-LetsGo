package Tree;

import java.util.*;

/**
 * @Classname BinarySearchTreetoGreaterSumTree1038
 * @Description:
 * @Date 2020/11/20 10:39
 * @Created by qiujunlin
 */
public class BinarySearchTreetoGreaterSumTree1038 {

    int pre=0;

    /**
     * 使用中序遍历  从有往左    每次都加上上一次的结果
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {
        if(root==null) return  null;
        bstToGst(root.right);
        root.val=root.val+pre;
        pre=root.val;
        bstToGst(root.left);
        return root;
    }
}
