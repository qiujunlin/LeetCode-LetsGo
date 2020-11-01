package Tree;
import  java.util.*;
public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return compare(root.left,root.right);
    }
    boolean compare(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null) return true;
        if(node1==null||node2==null) return false;
        return (node1.val==node2.val)&&compare(node1.left,node2.right)&&compare(node1.right,node2.left);

    }
    //方法2  使用迭代
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if(root==null) return true;
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode leftnode= queue.poll();
            TreeNode rightnode= queue.poll();
            if(leftnode==null&&rightnode==null){
                continue;

            }else if((leftnode==null||rightnode==null||leftnode.val!=rightnode.val)){
                return false;
            }
            queue.offer(leftnode.left);
            queue.offer(rightnode.right);
            queue.offer(leftnode.right);
            queue.offer(rightnode.left);
        }
        return true;
    }
}
