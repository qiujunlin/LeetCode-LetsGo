package Contest.week;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class W311 {
    public static void main(String[] args) {
        System.out.println("66666666");
    }
    public int longestContinuousSubstring(String s) {
        int max =1;
        int  i =0;
        while (i<s.length()){
            int  j=i+1;
            while (j<s.length()&&s.charAt(j)==s.charAt(j-1)+1) j++;
            max = Math.max(j-i,max);
            i = j;
        }
        return  max;
    }
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode reverseOddLevels(TreeNode root) {

        LinkedList<TreeNode>  q =new LinkedList<>();
        q.offer(root);
        int levl =0;
        while (!q.isEmpty()){
            ArrayList<TreeNode>   l =new ArrayList<>();
            int size =q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.removeFirst();
                l.add(n);
                if(n.left!=null) q.offerLast(n.left);
                if(n.right!=null) q.offerLast(n.right);
            }
            if(levl%2==1) {
                for (int i = 0; i < l.size() / 2; i++) {
                    TreeNode a = l.get(i);
                    TreeNode b = l.get(l.size() - 1 - i);
                    int temp = a.val;
                    a.val = b.val;
                    b.val = temp;
                }
            }
            levl++;
        }
        return  root;


    }
    public int[] sumPrefixScores(String[] words) {
        long  p =131;
        long res =1;
        HashMap<Long,Integer>  map =new HashMap<>();
        for(String s :words){
            for (int i = 0; i <s.length() ; i++) {
               res =res*p +  s.charAt(i);
                map.put(res,map.getOrDefault(res,0)+1);
            }
        }
        int rs[] =new int[words.length];
        res =1;
        for (int i = 0; i < words.length; i++) {
            int c =0;
            for (int j = 1 ;j <words[i].length() ; j++) {
                res =res*p +  words[i].charAt(j);
                c +=  map.getOrDefault(res,0)+1;
            }
            rs[i] =c;
        }
        return  rs;

    }
}
