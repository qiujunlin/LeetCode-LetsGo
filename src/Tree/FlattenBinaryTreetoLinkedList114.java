package Tree;

import java.util.Collections;
import java.util.Stack;

public class FlattenBinaryTreetoLinkedList114 {
    //解法1  使用迭代
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        if(root==null) return;
        TreeNode cur= new TreeNode(0);
        while(stack.size()!=0){
            TreeNode node1 = stack.pop();
            if(node1.right!=null) stack.push(node1.right);
            if(node1.left!=null) stack.push(node1.left);
            cur.right=node1;
            node1.left=null;
            cur=cur.right;

        }

    }
//    解法2  使用后序遍历 绝了
TreeNode pre =null;
    public void flatten2(TreeNode root) {
        if(root==null) return ;
        flatten(root.right);
        flatten(root.left);
        root.right=pre;
        root.left=null;
        pre=root;
    }
    //解法3

    public void flatten1(TreeNode root) {
        if(root==null) return ;
        TreeNode curnode = root;
        while(curnode!=null) {
            if(curnode.left==null) {
                curnode=curnode.right;
                continue;
            }
            TreeNode last = curnode.left;
            while(last.right!=null){
                last=last.right;
            }
            last.right=curnode.right;
            curnode.right=curnode.left;
            curnode.left=null;
            curnode=curnode.right;
        }
    }
}
