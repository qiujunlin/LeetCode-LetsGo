package Tree;

public class IncreasingOrderSearchTree {
    /*
    方法1使用中序遍历，建立额外的树来解决问题
     */
    TreeNode node;
    TreeNode cur ;
    public TreeNode increasingBST(TreeNode root) {
      if(root==null) return root;
      node= new TreeNode(root.val);
      cur=node;
      inorder(root);

      return node.right;

    }

    public void inorder(TreeNode treeNode){
        if(treeNode==null) return;
        inorder(treeNode.left);
        cur.right=new TreeNode(treeNode.val);
        cur=cur.right;
        inorder(treeNode.right);

    }
    /*
      方法2 使用中序遍历，更改数据的连接方式
     */
    public   TreeNode increasingBST2(TreeNode root){
        TreeNode node = new TreeNode(0);
        cur=node;
        if(root==null) return root;
        inorder2(root);
        return  node.right;
    }

    private void inorder2(TreeNode root) {
        if(root==null) return;
        inorder2(root.left);
         node.left=null;
         cur.right=root;
         cur=cur.right;
        inorder2(root.right);
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
        System.out.println(new IncreasingOrderSearchTree().increasingBST(noe1));
    }
}
