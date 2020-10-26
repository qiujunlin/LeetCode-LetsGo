package Tree;
import  java.util.*;
public class BinaryTreePreorderTraversal144 {

    List<Integer> list= new ArrayList<>();//返回值

    //方法一  递归
    public List<Integer> preorderTraversal(TreeNode root) {
          return  list;
    }
    public void preOrder(TreeNode root){
        if(root==null) return;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    //方法2  迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root==null) return  list;
        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            for(int i=0;i<num;i++){
                TreeNode node= queue.pop();
                list.add(node.val);
                if(node.right!=null) queue.push(node.right);
                if(node.left!=null) queue.push(node.left);
            }
        }
        return  list;
    }
    //方法3 通用
    //方法2  迭代
    public List<Integer> preorderTraversal3(TreeNode root) {
        if(root==null) return  list;
        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.pop();
            if(node!=null){
                if(node.right!=null) queue.push(node.right);
                if(node.left!=null) queue.push(node.left);
                queue.push(node);
                queue.push(null);

            }else{
                list.add(queue.pop().val);
            }

        }
        return  list;
    }
}
