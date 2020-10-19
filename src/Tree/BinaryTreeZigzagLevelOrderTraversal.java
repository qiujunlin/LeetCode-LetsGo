package Tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists= new ArrayList();
        if(root==null) return lists;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        int temp=0;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int num= queue.size();
            for (int i=0;i<num;i++){
                TreeNode node= queue.poll();
                list.add(node.val);
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            if(temp%2==1) {
                Collections.reverse(list);
            }
            lists.add(list);
            temp+=1;
            //System.out.println(queue);

        }
     return  lists;
    }
   /* public LinkedList reverse(LinkedList queue){

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2=new LinkedList<>();
        Collections.copy(queue,queue2);
        while(!queue.isEmpty()){
            queue2.offer((TreeNode) queue.poll());

        }

        while(!queue2.isEmpty()){
              queue1.offer((TreeNode) queue2.getLast());
              queue2.removeLast();
        }
        return  queue1;
    }*/
    public static void main(String[] args) {
        TreeNode noe1 = new TreeNode(3);
        TreeNode noe2 = new TreeNode(9);
        TreeNode noe3 = new TreeNode(20);
        TreeNode noe4 = new TreeNode(15);
        TreeNode noe5 = new TreeNode(7);
        noe1.left=noe2;
        noe1.right=noe3;
        noe3.left=noe4;
        noe3.right=noe5;
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(noe1));
    }
}
