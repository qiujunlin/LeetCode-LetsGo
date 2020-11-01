package Tree;

import java.util.*;

/**
 * @Classname PathSumII113
 * @Description:
 * @Date 2020/11/1 15:56
 * @Created by qiujunlin
 */
public class PathSumII113 {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> list= new LinkedList<>();
        if(root==null) return res;
        preOrder(root,sum,list);
        return res;
    }
    void   preOrder(TreeNode node,int sum,LinkedList<Integer> list){
        if(node==null) return;
        list.add(node.val);
        if(node.left==null&&node.right==null&&node.val==sum){
            LinkedList<Integer> reslist= new LinkedList<>(list);
            res.add(reslist);
        }
        preOrder(node.left,sum-node.val,list);
        preOrder(node.right,sum-node.val,list);
        list.removeLast();
    }
    //层序遍历 第二种解法
    List<List<Integer>> res2= new ArrayList<>();
    Map<TreeNode,TreeNode> map = new HashMap<>();
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        if(root==null) return res;
        Queue<TreeNode> queue1= new LinkedList<>();
        Queue<Integer> queue2= new LinkedList<>();
        queue1.offer(root);
        queue2.offer(sum);
        while(!queue1.isEmpty()){
            int len= queue1.size();
            for(int i=0;i<len;i++){
                TreeNode node =queue1.poll();
                Integer val= queue2.poll();
                if(node.left==null&&node.right==null&&node.val==val) {
                    construct(node);
                    continue;
                };
                if(node.left!=null) {
                    queue1.offer(node.left);
                    queue2.offer(val-node.val);
                    map.put(node.left,node);
                }
                if(node.right!=null) {
                    queue1.offer(node.right);
                    queue2.offer(val-node.val);
                    map.put(node.right,node);
                }
            }
        }
        return res2;
    }
    void construct(TreeNode node){
        LinkedList<Integer> list = new LinkedList<>();
        while(node!=null){
            list.addFirst(node.val);
            node=map.get(node);
        }
        res2.add(list);
    }
}
