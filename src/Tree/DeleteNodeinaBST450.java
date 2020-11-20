package Tree;

import java.util.*;

/**
 * @Classname DeleteNodeinaBST450
 * @Description:
 * @Date 2020/11/20 9:16
 * @Created by qiujunlin
 */
public class DeleteNodeinaBST450 {
    /**
     * 第一种 将node节点的值换为
     */
    TreeNode pre=null;
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
    TreeNode delete(TreeNode node,int key){
        if(node==null) return null;
        //dfs(node.left);
        if(node.val<key) node.right=delete(node.right,key);
        else if(node.val>key) node.left=delete(node.left,key);
        else {
            //寻找下一个节点 有三种情况
            //1.
            if(node.left==null) return node.right;
            if(node.right==null) return node.left;
            TreeNode min=findmin(node.right);
            node.right=deletemin(node.right);
            node.val=min.val;

        }
        return node;
    }
    TreeNode deletemin(TreeNode node){
        if(node.left==null) return node.right;
        node.left=deletemin(node.left);
        return node;
    }
    TreeNode findmin(TreeNode node){
        while(node.left!=null) node=node.left;
        return node;
    }
/**
 * 第二种方法  将node节点左边部分放到node的下一个节点的左边
 */
    //TreeNode pre=null;
    public TreeNode deleteNode2(TreeNode root, int key) {
        return delete(root,key);
    }
    TreeNode delete2(TreeNode node,int key){
        if(node==null) return null;
        //dfs(node.left);
        if(node.val<key) node.right=delete(node.right,key);
        else if(node.val>key) node.left=delete(node.left,key);
        else {
            //寻找下一个节点 有三种情况
            //1.
            if(node.left==null) return node.right;
            if(node.right==null) return node.left;
            TreeNode min=findmin(node.right);
            // node.right=deletemin(node.right);
            //node.val=min.val;
            min.left=node.left;
            return node.right;
        }
        return node;
    }
    // return node;
/*
    TreeNode deletemin(TreeNode node){
        if(node.left==null) return node.right;
        node.left=deletemin(node.left);
        return node;
    }
    TreeNode findmin(TreeNode node){
        while(node.left!=null) node=node.left;
        return node;
    }*/

}
