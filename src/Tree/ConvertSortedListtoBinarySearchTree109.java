package Tree;

import java.util.*;

/**
 * @Classname ConvertSortedListtoBinarySearchTree109
 * @Description:
 * @Date 2020/11/7 15:45
 * @Created by qiujunlin
 */
public class ConvertSortedListtoBinarySearchTree109 {
    //第一次 只超过 百分之20
    public TreeNode sortedListToBST(ListNode head) {
        ListNode cur = head;
        int len=0;
        int a[]= new int[100000];
        while(cur!=null){
            a[len]=cur.val;
            len++;
            cur=cur.next;
        }

        return dfs(0,len-1,a);

    }
    TreeNode dfs(int left,int right,int nums[]){
        if(left>right) return null;
        int mid=(right+left)/2;
        TreeNode node =new TreeNode(nums[mid]);
        node.left=dfs(left,mid-1,nums);
        node.right=dfs(mid+1,right,nums);
        return node;
    }
}
