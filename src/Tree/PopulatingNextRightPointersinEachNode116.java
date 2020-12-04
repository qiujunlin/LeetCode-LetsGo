package Tree;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/11/3
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class PopulatingNextRightPointersinEachNode116 {
    //使用层序遍历
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            for(int i=1;i<=num;i++){
                Node node=queue.poll();
                if(i==num){
                    node.next=null;

                }else{
                    node.next=  queue.element();
                }

                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return root;
    }
    //解法2  性能最好  ！！！！
    public Node connect2(Node root) {
        Node leftmost= root;
        while(leftmost!=null&&leftmost.left!=null){
            Node cur = leftmost;
            while(cur!=null){
                cur.left.next=cur.right;
                if(cur.next!=null){
                    cur.right.next=cur.next.left;
                }
                cur=cur.next;
            }
            leftmost=leftmost.left;

        }
        return root;
    }
}
