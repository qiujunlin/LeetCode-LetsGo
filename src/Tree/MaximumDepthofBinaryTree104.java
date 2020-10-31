package Tree;
import  java.util.*;
public class MaximumDepthofBinaryTree104 {
    //方法1  使用递归  本质是后序遍历
    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    //方法2  使用层序遍历
    public int maxDepth2(TreeNode root) {
        int depth=0;
        if(root==null) return depth;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            for(int i=0;i<num;i++){
                TreeNode node=queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
