package Tree;
import  java.util.*;
public class BinaryTreeRightSideView199 {
    //解法1 层序遍历
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if(root==null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int num= queue.size();
            for (int i=0;i<num;i++){
                TreeNode node= queue.poll();
                list.add(node.val);
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            res.add(list.getLast());
            //System.out.println(queue);

        }
        return  res;
    }
    //解法2 递归
    List<Integer> list ;
    public List<Integer> rightSideView2(TreeNode root) {
        list= new LinkedList<>();
        if(root==null) return list;
        preorder(root,0);
        return list;
    }
    public void preorder(TreeNode node,int depth){
        if(node==null) return ;
        if(depth==list.size()){
            list.add(node.val);

        }
        depth++;
        preorder(node.right,depth);
        preorder(node.left,depth);


    }

}
