package Tree;

import java.util.*;

/**
 * @Classname ConstructBinaryTreefromPreorderandInorderTraversal105
 * @Description:
 * @Date 2020/11/2 18:53
 * @Created by qiujunlin
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    int  index=0;
    Map<Integer,Integer> map =new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode res= construct(0,inorder.length-1,preorder,inorder);
        return res;
    }
    TreeNode construct(int left,int right,int[] preorder,int[] inorder){
        if(left>right) return null;
        if(left==right){
            index++;
            return new TreeNode(inorder[right]);

        }
        TreeNode node = new TreeNode(preorder[index]);
        int cur=index;
        index++;
        node.left= construct(left,map.get(preorder[cur])-1,preorder,inorder);
        node.right=construct(map.get(preorder[cur])+1,right,preorder,inorder);
        return node;
    }

    public static void main(String[] args) {
       int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        new ConstructBinaryTreefromPreorderandInorderTraversal105().buildTree(preorder,inorder);

    }

}
