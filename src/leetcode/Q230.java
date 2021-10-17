package leetcode;

import java.util.TreeMap;

public class Q230 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    int res =0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return  res;

    }
    void dfs(TreeNode root,int k){

        if(root==null) return;
        if(root.left!=null) dfs(root.left, k);
        k--;if(k==0) res=root.val;

        if(root.right!=null) dfs(root.right, k);
    }

}
