package Tree;

import java.util.ArrayList;
import java.util.List;

public class CountCompleteTreeNodes {
    //方法一  通过  然后遍历后结果大小
    List<TreeNode> list = new ArrayList<>();
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        preOrder(root);
        return list.size();
    }
    public void preOrder(TreeNode root){
        if(root==null) return;
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
    //
}
