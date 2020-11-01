package Tree;

public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return compare(root.left,root.right);
    }
    boolean compare(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null) return true;
        if(node1==null||node2==null) return false;
        return (node1.val==node2.val)&&compare(node1.left,node2.right)&&compare(node1.right,node2.left);

    }
}
