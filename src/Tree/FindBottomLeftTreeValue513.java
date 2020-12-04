package Tree;

import java.util.*;

/**
 * @Classname FindBottomLeftTreeValue513
 * @Description:
 * @Date 2020/11/20 9:51
 * @Created by qiujunlin
 */
public class FindBottomLeftTreeValue513 {
    /**
     * 思路：  采用先序遍历的形式，函数参数里传递每层节点的高度，用一个最大值和高度值来保存结果，遇见更深的结果就更新
     * 原因： 先序遍历首先访问到的节点肯定是最深的节点
     */
    int  maxlevel=0;
    int res=0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,1);
        return res;
    }
    void dfs(TreeNode node,int level){
        if(node==null) return;
        //dfs(node.left,level+1);
        //dfs(node.right,level+1);
        if(node.left==null&&node.right==null){
            if(level>maxlevel){
                res=node.val;
                maxlevel=level;
            }
            return;
        }
        dfs(node.left,level+1);
        dfs(node.right,level+1);
        return ;

    }

    /**
     * 第二种思路  使用层序遍历 ，每次都取当前层的最前面那个节点。
     * @param root
     * @return
     */
    public int findBottomLeftValue2(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        int res=0;
        while(queue.size()!=0){
            int num=queue.size();
            res=queue.element().val;
            for(int i=0;i<num;i++){
                TreeNode node = queue.poll();

                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return res;
    }

}
