package Tree;

import java.util.*;

/**
 * @Classname BinaryTreePaths247
 * @Description:
 * @Date 2020/11/15 12:39
 * @Created by qiujunlin
 */
public class BinaryTreePaths247 {
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return list;

    }
    void dfs(TreeNode root,String s){
        if(root==null) return;
        s=s+root.val;
        if(root.left==null&&root.right==null){
            list.add(s);
            return;
        }
        if(root.left!=null) dfs(root.left,s+"->");
        if(root.right!=null) dfs(root.right,s+"->");
    }

    public static void main(String[] args) {
        TreeNode noe1 = new TreeNode(1);
        TreeNode noe2 = new TreeNode(2);
        TreeNode noe3 = new TreeNode(3);
        TreeNode noe4 = new TreeNode(5);
        noe1.left=noe2;
        noe1.right=noe3;
        noe2.right=noe4;
        System.out.println(new BinaryTreePaths247().binaryTreePaths(noe1));
    }
}
