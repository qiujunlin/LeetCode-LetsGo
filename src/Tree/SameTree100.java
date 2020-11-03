package Tree;

import java.util.*;

/**
 * @Classname SameTree100
 * @Description:
 * @Date 2020/11/3 22:22
 * @Created by qiujunlin
 */
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p,q);
    }
    boolean compare(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        return p.val==q.val&&compare(p.left,q.left)&&compare(p.right,q.right);
   }
    //解法2 bfs
}
