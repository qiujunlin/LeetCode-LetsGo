package Tree;
import sun.plugin.javascript.navig.Link;

import  java.util.*;
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
    public List<TreeNode> generateTrees2(int n) {
        ArrayList<TreeNode> list[] = new ArrayList[n+1];
        if(n==0)
            return list[0];
        return  null;
    }

}
