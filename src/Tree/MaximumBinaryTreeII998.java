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
    //方法2  使用递归 参考 有点难懂
    public  TreeNode insertIntoMaxTree2(TreeNode root,int val){
        if(root.val<val){
              TreeNode node= new TreeNode(val);
              node.left=root;
              return  node;
        }else{
            if(root.right==null) root.right=new TreeNode(val);
            else{
                root.right=insertIntoMaxTree(root.right,val);
            }

        }
        return  root;



    }
}
