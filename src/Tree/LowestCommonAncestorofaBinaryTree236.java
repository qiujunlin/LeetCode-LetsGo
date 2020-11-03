package Tree;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/11/3
 * 递归解析：
 * 终止条件：
 * 当越过叶节点，则直接返回 nullnull ；
 * 当 rootroot 等于 p, qp,q ，则直接返回 rootroot ；
 * 递推工作：
 * 开启递归左子节点，返回值记为 leftleft ；
 * 开启递归右子节点，返回值记为 rightright ；
 * 返回值： 根据 leftleft 和 rightright ，可展开为四种情况；
 * 当 leftleft 和 rightright 同时为空 ：说明 rootroot 的左 / 右子树中都不包含 p,qp,q ，返回 nullnull ；
 * 当 leftleft 和 rightright 同时不为空 ：说明 p, qp,q 分列在 rootroot 的 异侧 （分别在 左 / 右子树），因此 rootroot 为最近公共祖先，返回 rootroot ；
 * 当 leftleft 为空 ，rightright 不为空 ：p,qp,q 都不在 rootroot 的左子树中，直接返回 rightright 。具体可分为两种情况：
 * p,qp,q 其中一个在 rootroot 的 右子树 中，此时 rightright 指向 pp（假设为 pp ）；
 * p,qp,q 两节点都在 rootroot 的 右子树 中，此时的 rightright 指向 最近公共祖先节点 ；
 * 当 leftleft 不为空 ， rightright 为空 ：与情况 3. 同理；
 *
 */
public class LowestCommonAncestorofaBinaryTree236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root.val==p.val||root.val==q.val) return root;
        TreeNode left= lowestCommonAncestor(root.left,p,q);
        TreeNode right= lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) return root;
        if(left!=null) return  left;
        if(right!=null) return right;
        return null;
    }
}
