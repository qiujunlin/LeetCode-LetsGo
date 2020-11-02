package Tree;

import java.util.*;

/**
 * @Classname ConstructBinaryTreefromInorderandPostorderTraversal106
 * @Description:
 * @Date 2020/11/1 16:58
 * @Created by qiujunlin
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    Map<Integer,Integer> map = new HashMap<>();
    int back;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        back=postorder.length-1;
        TreeNode node=construct(0, postorder.length-1,inorder,postorder);
        return node;
    }
    TreeNode  construct(int left,int right,int[] inorder,int[] postorder){
        if(left>right) return null;
        if(left==right) {
            back--;
            return new TreeNode(inorder[left]);
        }
        TreeNode node  = new TreeNode(postorder[back]);
        int index= map.get(postorder[back]);
        back--;
        node.right=construct(index+1,right,inorder,postorder);
        node.left=construct(left,index-1,inorder,postorder);
        return node;
    }
}
