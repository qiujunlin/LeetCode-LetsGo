package Tree;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/11/3
 */
public class PopulatingNextRightPointersinEachNodeII117 {
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
}
