package Tree;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//层序遍历
public class   PrintTreesFromTopToDown {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  lists= new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return  lists;
        queue.add(root);
        while(queue.size()!=0){
            List<Integer> list= new LinkedList<>();
            int size= queue.size();
            for(int i=0;i<size;i++){
                TreeNode node= queue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                list.add(node.val);
            }
            lists.add(list);
        }
    return lists;
    }

    public static void main(String[] args) {
        TreeNode noe1 = new TreeNode(3);
        TreeNode noe2 = new TreeNode(9);
        TreeNode noe3 = new TreeNode(20);
        TreeNode noe4 = new TreeNode(15);
        TreeNode noe5 = new TreeNode(17);
        noe1.left=noe2;
        noe1.right=noe3;
        noe3.left=noe4;
        noe3.right=noe5;
        System.out.println(new PrintTreesFromTopToDown().levelOrder(noe1));

    }

}
