package Tree;

import java.util.*;

/**
 * @Classname RecoverBinarySearchTree99
 * @Description:
 * @Date 2020/11/13 8:58
 * @Created by qiujunlin
 */
public class RecoverBinarySearchTree99 {
    //第一种思路  迭代
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack= new Stack<>();
        TreeNode cur = root;
        TreeNode first=null,second=null;
        TreeNode pre=null;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node = stack.pop();
            if(pre!=null&&pre.val>node.val&&first==null)  first=pre;
            if(pre!=null&&pre.val>node.val&&first!=null)  second=node;
            pre =node;
            cur=node.right;

        }
        int temp =first.val;
        first.val=second.val;
        second.val=temp;

    }
    //第二种思路 也是迭代 ，中间改了一点小思路
    public void recoverTree2(TreeNode root) {
        Stack<TreeNode> stack= new Stack<>();
        TreeNode cur = root;
        TreeNode first=null,second=null;
        TreeNode pre=null;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node = stack.pop();
            if(pre!=null&&pre.val>node.val){
                second=node;
                if(first==null){
                    first=pre;
                }
            }
            pre =node;
            cur=node.right;
        }
        int temp =first.val;
        first.val=second.val;
        second.val=temp;

    }
}
