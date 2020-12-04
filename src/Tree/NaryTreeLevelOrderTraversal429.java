package Tree;

import java.util.*;

/**
 * @Classname NaryTreeLevelOrderTraversal429
 * @Description:
 * @Date 2020/11/13 20:54
 * @Created by qiujunlin
 */
class Node1 {
    public int val;
    public List<Node1> children;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, List<Node1> _children) {
        val = _val;
        children = _children;
    }
}
public class NaryTreeLevelOrderTraversal429 {

    public List<List<Integer>> levelOrder(Node1 root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Node1> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int num = queue.size();
            for(int i=0;i<num;i++){
                Node1 node=queue.poll();
                list.add(node.val);
                for(Node1 child:node.children){
                    queue.offer(child);
                }

            }
            res.add(list);
        }
        return res;
    }
}
