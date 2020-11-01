package Tree;
import  java.util.*;
public class PathSum112 {
    //前序遍历
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        else if(root.left==null&&root.right==null&&sum-root.val==0) return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    //方法 2  迭代  也就是层序遍历
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root==null) return false;
        Queue<TreeNode> queue1= new LinkedList<>();
        Queue<Integer> queue2= new LinkedList<>();
        queue1.offer(root);
        queue2.offer(sum);
        while(!queue1.isEmpty()){
            int len= queue1.size();
            for(int i=0;i<len;i++){
                TreeNode node =queue1.poll();
                Integer val= queue2.poll();
                if(node.left==null&&node.right==null&&node.val==val) return true;
                if(node.left!=null) {
                    queue1.offer(node.left);
                    queue2.offer(val-node.val);
                }
                if(node.right!=null) {
                    queue1.offer(node.right);
                    queue2.offer(val-node.val);
                }


            }
        }
        return false;
    }


}
