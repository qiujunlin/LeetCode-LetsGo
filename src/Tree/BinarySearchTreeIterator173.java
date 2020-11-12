package Tree;

import java.util.*;

/**
 * @Classname BinarySearchTreeIterator173
 * @Description:
 * @Date 2020/11/12 12:41
 * @Created by qiujunlin
 */
public class BinarySearchTreeIterator173 {
    //第一种思路 使用 linkedlist  很快  但是不符合题的要求 使用 O(H) h=树的高度 这样的空间复杂度
    //第一种思路很容易想出来 这里 就不贴代码了  主要是看第二种思路
    Stack<TreeNode> stack;
    void fun(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    public BinarySearchTreeIterator173(TreeNode root) {
        stack= new Stack<>();
        fun(root);

    }
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        fun(node.right);
        return  node.val;
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
