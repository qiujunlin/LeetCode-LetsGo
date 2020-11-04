package Tree;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/11/3
 */
public class SerializeandDeserializeBinaryTree297 {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        queue.offer(root);
        list.add(String.valueOf(root.val));
        while (!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                //list.add(String.valueOf(node.val));
                if (node.left != null) {
                    queue.offer(node.left);
                    list.add(String.valueOf(node.left.val));
                } else {
                    list.add("#");
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    list.add(String.valueOf(node.right.val));
                } else {
                    list.add("#");
                }
            }
        }
        return String.join(" ", list);

    }
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.asList(data.split(" "));

        Queue<TreeNode> queue = new LinkedList();
        int i=0;
        TreeNode root = new TreeNode(Integer.parseInt(list.get(i++)));
        queue.offer(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            for(int j=0;j<num;j++){
                TreeNode node=queue.poll();
                String val1=list.get(i++);
                String val2=list.get(i++);
                if(!"#".equals(val1)){
                    TreeNode left= new TreeNode(Integer.parseInt(val1));
                    queue.offer(left);
                    node.left=left;
                }else{
                    node.left=null;
                }
                if(!"#".equals(val2)){
                    TreeNode right= new TreeNode(Integer.parseInt(val2));
                    queue.offer(right);
                    node.right=right;
                }else{
                    node.right=null;
                }
            }
        }

    return  root;

    }

    public void inorderTraversal1(TreeNode root){
        if(root==null) return;
        System.out.println(root.val);
        inorderTraversal1(root.left);
        inorderTraversal1(root.right);
    }
    public static void main(String[] args) {

            TreeNode noe1 = new TreeNode(1);
            TreeNode noe2 = new TreeNode(2);
            TreeNode noe3 = new TreeNode(3);
            TreeNode noe4 = new TreeNode(4);
            TreeNode noe5 = new TreeNode(5);
            noe1.left = noe2;
            noe1.right = noe3;
            noe3.left = noe4;
            noe3.right = noe5;
       SerializeandDeserializeBinaryTree297 a= new SerializeandDeserializeBinaryTree297();
       a.inorderTraversal1(a.deserialize(a.serialize(noe1)));

    }
}
