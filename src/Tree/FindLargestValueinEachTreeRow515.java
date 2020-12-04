package Tree;

import java.util.*;

/**
 * @Classname FindLargestValueinEachTreeRow515
 * @Description:
 * @Date 2020/11/13 21:19
 * @Created by qiujunlin
 */
public class FindLargestValueinEachTreeRow515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int num =queue.size();
            int max =Integer.MIN_VALUE;
            for(int i=0;i<num;i++){
                TreeNode node =queue.poll();
                max= Math.max(node.val,max);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            res.add(max);
        }
        return res;

    }
}
