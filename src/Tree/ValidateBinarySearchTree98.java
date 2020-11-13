package Tree;

import java.util.*;
/**
 * @Classname ValidateBinarySearchTree98
 * @Description:
 * @Date 2020/11/12 13:26
 * @Created by qiujunlin
 */
public class ValidateBinarySearchTree98 {
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }
    void dfs(TreeNode root){
        if(root==null) return ;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    //第一种翻方法的简化写法
    long  pre= Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if(root==null) return true;
        boolean left=isValidBST(root.left);
        if(root.val<=pre) {
            return false;
        }
        pre=root.val;
        boolean right = isValidBST(root.right);
        return left&&right;
    }


    public static void main(String[] args) {
        TreeNode noe1 = new TreeNode(5);
        TreeNode noe2 = new TreeNode(1);
        TreeNode noe3 = new TreeNode(4);
        TreeNode noe4 = new TreeNode(3);
        TreeNode noe5 = new TreeNode(6);
        noe1.left = noe2;
        noe1.right = noe3;
        noe3.left = noe4;
        noe3.right = noe5;
       ValidateBinarySearchTree98 a= new ValidateBinarySearchTree98();
       a.isValidBST(noe1);
        System.out.println(a.list);
    }
}
