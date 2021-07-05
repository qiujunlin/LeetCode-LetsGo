package Array;

public class Q23 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
   //  return  null;
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if(l==r) return  lists[l];
        //if(l>r) return ;
        int mid  = (l+r)/2;
        if(l>r) return  null;
        ListNode left  = merge(lists,l,mid);
        ListNode right  = merge(lists,mid+1,r);
        return hebing(left,right);
    }

    private ListNode hebing(ListNode left, ListNode right) {
        ListNode head =  new ListNode(0);
        ListNode cur  = head;
        while (left!=null||right!=null){
            if(left==null) {cur.next= right;break;}
            if(right==null) {cur.next = left;break;}
            if(left.val>right.val) {cur.next = right;right=right.next;}
            else {cur.next=left;left=left.next;}
            cur = cur.next;
        }
        return  head.next;
    }
}
