package Tree;

public class MaximumBinaryTreeII998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root.val<val){
            node.left=root;
            return node;
        }
        TreeNode cur  = root;
        while(cur.right!=null&&cur.right.val>val){
            cur=cur.right;
        }
        node.left=cur.right;
        cur.right=node;
        return root;

    }
}
