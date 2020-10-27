package Tree;
import org.omg.PortableInterceptor.INACTIVE;

import  java.util.*;
public class BinaryTreePostorderTraversal145 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal1(TreeNode root) {
        postorder(root);
        return list;
    }

    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }
    //后序遍历迭代
    public List<Integer> postorderTraversal2(TreeNode root){
         LinkedList<Integer> list= new LinkedList<>();
         Stack<TreeNode> stack= new Stack<>();
         while(root!=null||!stack.isEmpty()){
            if(root!=null){
                list.addFirst(root.val);
                stack.push(root);
                root=root.right;
            }else{
                TreeNode node=stack.pop();
                root=node.left;

            }
         }
         return  list;
    }
    //通用写法
    public List<Integer> postordderTraversal3(TreeNode root){
            List<Integer> list= new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode>  stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node= stack.pop();
            if(node!=null){
                stack.push(node);
                stack.push(null);

                if(node.right!=null) stack.push(node.right);
                if(node.left!=null) stack.push(node.left);
            }
            else{
                list.add(stack.pop().val);
            }
        }
        return list;
    }


}
