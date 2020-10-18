package Tree;

public class BalancedBinaryTree {
    //方法一 指定向下
    int build(TreeNode  node){
        if(node==null) return 0;
        return Math.max(build(node.left)+1,build(node.right)+1);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return (Math.abs(build(root.right)-build(root.left))<=1)&&isBalanced(root.left)&&isBalanced(root.right);
    }

    /*
    方法二 自底向上
     */
    int build2(TreeNode  node){
        if(node==null) return -1;
        int left = build2(node.left);
        if(left==-1) return -1;
        int right = build2(node.right);
        if(right==-1) return -1;
        return Math.abs(left-right)<=1?Math.max(left,right)+1:-1;

    }
    public boolean isBalanced2(TreeNode root) {
        return build2(root)==-1?false:true;
    }
}


