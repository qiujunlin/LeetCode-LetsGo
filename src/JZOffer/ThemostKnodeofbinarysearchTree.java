package JZOffer;


import java.util.*;

public class ThemostKnodeofbinarysearchTree {
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        preOrder(root);
        Collections.sort(list);
        return list.get(list.size()-k);
    }
    void preOrder(TreeNode root){
        if(root==null){
            return ;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    //方法2 使用后序遍历
    int cur;
    int res;
    int ta;
    public int kthLargest2(TreeNode root, int k) {
        ta=k;
        preOrder2(root);

        return res;

    }
    void preOrder2(TreeNode root){
        if(root==null){
            return ;
        }
        preOrder2(root.right);
        if(cur>ta) return;
        cur=cur+1;
        if(cur==ta) {
            res=root.val;
            return;
        }
        preOrder2(root.left);
    }
    public static void main(String[] args) {
        TreeNode noe1 = new TreeNode(3);
        TreeNode noe2 = new TreeNode(9);
        TreeNode noe3 = new TreeNode(20);
        TreeNode noe4 = new TreeNode(15);
        TreeNode noe5 = new TreeNode(7);
        noe1.left=noe2;
        noe1.right=noe3;
        noe3.left=noe4;
        noe3.right=noe5;
        System.out.println(new ThemostKnodeofbinarysearchTree().kthLargest2(noe1,3));
    }

}
