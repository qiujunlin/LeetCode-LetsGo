package Tree;

import java.util.LinkedList;
import java.util.List;

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
}

