package JZOffer;

public class Q26 {
      class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
          TreeNode(int x) { val = x; }
  }
  boolean res =false;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
          if(B==null) return   false;
          int  val = B.val;
          predfs(A,val,B);
          return  res;
    }
    private void predfs(TreeNode a, int val,TreeNode B) {
       if(a==null) return;
       if(a.val==val) {
           if(judge(a,B)){
            res = true;
            return;
           }
       }
       if(a.left!=null) predfs(a.left,val, B);
       if(a.right!=null) predfs(a.right,val, B);
      }

    private boolean judge(TreeNode a, TreeNode b) {
       if(a==null) return  false;
       if(a.val!=b.val) return  false;
       boolean r = true;
       if(b.left!=null) {
           r&=judge(a.left,b.left);
       }
       if(b.right!=null){
           r&=judge(a.right,b.right);
       }
       return  r;
    }
}
