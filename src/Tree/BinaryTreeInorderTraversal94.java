package Tree;
import  java.util.*;

public class BinaryTreeInorderTraversal94 {
    List<Integer> list = new ArrayList<Integer>();
    //使用递归
    public void inorderTraversal1(TreeNode root){
        if(root==null) return;
        list.add(root.val);
        inorderTraversal1(root.left);
        inorderTraversal1(root.right);
    }
    public List<Integer> inorderTraversal2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode node= stack.pop();
            list.add(node.val);
            root=node.right;
        }
        return list;
    }
//使用迭代 万能
        public List<Integer> inorderTraversal3(TreeNode root) {
            if(root==null) return  list;
            Stack<TreeNode> queue = new Stack<>();
            queue.push(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.pop();
                if(node!=null){
                    if(node.right!=null) queue.push(node.right);
                    queue.push(node);
                    queue.push(null);
                    if(node.left!=null) queue.push(node.left);
                }else{
                    list.add(queue.pop().val);
                }

            }
            return  list;
        }
    }

