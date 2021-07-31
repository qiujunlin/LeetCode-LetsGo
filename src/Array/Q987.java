package Array;
import  java.util.*;
public class Q987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        TreeMap<Integer,List<TreeNode>> map = new TreeMap<>();
        HashMap<TreeNode ,Integer> m = new HashMap<>();
        m.put(root,0);
        map.computeIfAbsent(m.get(root),(key)->new ArrayList<>()).add(root);
        HashMap<TreeNode,Integer> row  = new HashMap<>();
        int level =0;
        while (!deque.isEmpty()){
            int size  = deque.size();
            TreeNode pre = null;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                int col = m.get(node);
                if(node.left!=null){
                    map.computeIfAbsent(col-1,(key)->new ArrayList<>()).add(node.left);
                    deque.offer(node.left);
                    m.put(node.left,col-1);
                    pre  = node.left;
                    row.put(node.left,level);
                }
                if(node.right!=null){
                    map.computeIfAbsent(col+1,(key)->new ArrayList<>()).add(node.right);
                    deque.offer(node.right);
                    m.put(node.right,col+1);
                    pre=node.right;
                    row.put(node.right,level);
                }
            }
        }
        List<List<Integer>> res  = new ArrayList<>();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            int key = (int) iterator.next();
            List<TreeNode> l = map.get(key);
            Collections.sort(l,(a,b)->row.get(a)==row.get(b)?a.val-b.val:row.get(a)-row.get(b));
            ArrayList<Integer> re  = new ArrayList<>();
            for (TreeNode node :l) re.add(node.val);
            res.add(re);

        }
        return  res;
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        new Q987().verticalTraversal(treeNode);

    }
}
