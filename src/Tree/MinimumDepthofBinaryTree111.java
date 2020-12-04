package Tree;

import java.util.*;

/**
 * @Classname MinimumDepthofBinaryTree111
 * @Description:
 * @Date 2020/11/13 19:02
 * @Created by qiujunlin
 */
public class MinimumDepthofBinaryTree111 {
    //第一种 使用递归   很慢  不知道为什么  超过了百分之5
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left =minDepth(root.left);
        int right= minDepth(root.right);
        if(left==0)  return right+1;
        if(right==0) return left+1;
        return Math.min(left,right)+1;
    }
    //第二种  使用层序遍历  超过了百分之 30  还是很慢  继续改改
     public int minDepth2(TreeNode root) {
        if(root==null) return 0;
        int  height=0;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int num = queue.size();
            height++;
            for(int i=0;i<num;i++){
                TreeNode node=queue.poll();
                if(node.left==null&&node.right==null) return height;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return height;
    }
}
