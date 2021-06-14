package Array;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
    //解法1  使 用递归
    public List<TreeNode> generateTrees(int n) {
        //  List<TreeNode> ndoe = new ArrayList<>();
        if(n==0) return new ArrayList<TreeNode>();
        return dfs(1,n);

    }
    public List<TreeNode> dfs(int left,int right){
        List<TreeNode> res= new ArrayList<>();
        if(left>right) {
            res.add(null);return res;
        }
        if(left==right) {
            res.add(new TreeNode(left));
            return res;
        }
        List<TreeNode> leftlist= new ArrayList<>();
        List<TreeNode> rightlist= new ArrayList<>();

        for(int i=left;i<=right;i++){
            //TreeNode node=new TreeNode(i);
            //ndoe.left=dfs(left,i-1);
            //ndoe.right=dfs(i+1,right);
            leftlist=dfs(left,i-1);
            rightlist=dfs(i+1,right);
            for(TreeNode leftnode:leftlist){
                for(TreeNode rightnode:rightlist){
                    TreeNode node= new TreeNode(i);
                    node.right=rightnode;
                    node.left=leftnode;
                    res.add(node);
                }
            }
        }
        return res;
    }
    //解法 2  使用动态规划
//使用动态数组的方法

    class Solution {
        public TreeNode clone(TreeNode root,int n){
            if(root==null) return null;
            TreeNode node = new TreeNode(root.val+n);
            TreeNode leftnode=clone(root.left,n);
            TreeNode rightnode=clone(root.right,n);
            node.left=leftnode;
            node.right=rightnode;
            return node;
        }
        public List<TreeNode> generateTrees(int n) {
            ArrayList<TreeNode> res[]= new ArrayList[n+1];
            res[0]=new ArrayList<>();
            if(n==0) {
                return res[0];
            }
            res[0].add(null);//这一行必须加
            for(int i=1;i<=n;i++){
                ArrayList<TreeNode> list=new ArrayList<>();
                for(int j=1;j<=i;j++){
                    int left=j-1;
                    int right=i-j;
                    for(TreeNode leftnode:res[left]){
                        for(TreeNode rightnode:res[right]){
                            TreeNode node = new TreeNode(j);
                            TreeNode left1 = leftnode;
                            TreeNode right1=clone(rightnode,j);
                            node.left=left1;
                            node.right=right1;
                            list.add(node);
                        }
                    }

                }
                res[i]=list;
            }
            return res[n];
        }

    }
}
