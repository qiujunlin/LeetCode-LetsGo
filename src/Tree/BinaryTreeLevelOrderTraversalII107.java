package Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists= new ArrayList();
        if(root==null) return lists;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int num= queue.size();
            for (int i=0;i<num;i++){
                TreeNode node= queue.poll();
                list.add(node.val);
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            lists.add(list);


        }
        Collections.reverse(lists);
        return  lists;
    }
}
