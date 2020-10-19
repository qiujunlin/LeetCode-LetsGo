package Tree;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
//方法一  使用递归
public class NaryTreePreorderTraversal {
    List<Integer> list;
    public void tree(Node root){
        if(root==null) return;
        list.add(root.val);
        for (int i = 0; i < root.children.size();i++) {
            tree(root.children.get(i));

        }
    }
    public List<Integer> preorder(Node root) {
        list = new LinkedList<>();
        if (root == null) return list;
        tree(root);
         return list;
    }
    //方法2   使用迭代
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (stack.size() != 0) {
            Node node = stack.pop();
            res.add(node.val);
            Collections.reverse(node.children);
            for (Node nodes:
                 node.children) {
                stack.add(nodes);
            }

        }
        return res;
    }
}

