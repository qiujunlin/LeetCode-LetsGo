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

}
