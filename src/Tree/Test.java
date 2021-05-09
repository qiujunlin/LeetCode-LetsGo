package Tree;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        LinkedList<Integer> queue2 = new LinkedList<>();
        queue2.removeLast();
        Collections.copy(queue2,queue);
        System.out.println(queue2);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
          List<Integer> list1 = new ArrayList<>();
          List<Integer> list2 = new ArrayList<>();
          dfs(root1,list1);
          dfs(root2,list2);
          if(list1.size()!=list2.size()) return  false;
          for(int i=0;i<list1.size();i++){
              if(list1.get(i)!=list2.get(i)) return false;
          }
          return  true;


    }

    private void dfs(TreeNode root1, List<Integer> list1) {
       if(root1.right==null&&root1.left==null){
           list1.add(root1.val);
           return;
       }
       if(root1.left!=null) dfs(root1.left,list1);
       if(root1.right!=null) dfs(root1.right,list1);
    }
}
