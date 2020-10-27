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
    //迭代2
    public List<Integer> inorderTraversal3(TreeNode root){
        LinkedList<Integer> list= new LinkedList<>();
        Stack<TreeNode> stack= new Stack<>();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                TreeNode node=stack.pop();
                list.add(node.val);
                root=node.right;

            }
        }
        return  list;
    }
//使用迭代 万能
        public List<Integer> inorderTraversal4(TreeNode root) {
            if(root==null) return  list;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node!=null){
                    if(node.right!=null) stack.push(node.right);
                    stack.push(node);
                    stack.push(null);
                    if(node.left!=null) stack.push(node.left);
                }else{
                    list.add(stack.pop().val);
                }

            }
            return  list;
        }
    }

