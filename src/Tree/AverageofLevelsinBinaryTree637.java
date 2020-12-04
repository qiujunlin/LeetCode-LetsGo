package Tree;

import java.util.*;

/**
 * @Classname AverageofLevelsinBinaryTree
 * @Description:
 * @Date 2020/11/13 21:10
 * @Created by qiujunlin
 */
public class AverageofLevelsinBinaryTree637 {
    /**
     * 层序遍历 简单
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            long num =queue.size();
            long  sum =0;
            for(int i=0;i<num;i++){
                TreeNode node =queue.poll();
                sum+=node.val;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            res.add((double)sum/num);
        }
        return res;
    }
}
