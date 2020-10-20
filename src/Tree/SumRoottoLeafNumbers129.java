package Tree;

import java.util.*;

public class SumRoottoLeafNumbers129 {
    int res=0;
    //方法一  前序遍历
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        preorder(root,0);
        return res;
    }
    public void preorder(TreeNode node,int sum){
        if(node==null)  return ;
        int temp=sum*10+node.val;
        if(node.left==null&&node.right==null) {
            res=res+sum;
            return;
        }

        preorder(node.left,temp);
        preorder(node.right,temp);
    }
    //方法2  迭代 层序遍历
    public int sumNumbers2(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue1= new LinkedList<>();
        Queue<Integer> queue2= new LinkedList<>();
        queue1.offer(root);
        queue2.offer(root.val);
        while(!queue1.isEmpty()){
            int sum = queue1.size();
            for(int i=0;i<sum;i++){
                TreeNode node = queue1.poll();
                int curval=queue2.poll();
                if(node.left==null&&node.right==null)
                    res=res+curval;
                if(node.left!=null){
                    queue1.offer(node.left);
                    queue2.offer(curval*10+node.left.val);
                }
                if(node.right!=null){
                    queue1.offer(node.right);
                    queue2.offer(curval*10+node.right.val);
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        TreeNode noe1 = new TreeNode(1);
        TreeNode noe2 = new TreeNode(2);
        TreeNode noe3 = new TreeNode(3);


        noe1.left=noe2;
        noe1.right=noe3;
        System.out.println(new SumRoottoLeafNumbers129().sumNumbers2(noe1));
    }
}
