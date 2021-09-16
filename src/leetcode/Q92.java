package leetcode;

/**
 * @Classname Q92
 * @Description:
 * @Date 2021/3/19 20:24
 * @Created by qiujunlin
 */

public class Q92 {
    public  void reverse(ListNode node){
        //ListNode head  = null;
        ListNode cur = node;
        ListNode head = null;
        while (cur!=null){
           ListNode temp = cur.next;
           cur.next= head;
           head =cur;
           cur = temp;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentry =  new ListNode();
        ListNode pre = null;
        ListNode first = null,last =null,reversefirst = null,reverselast =null;
        ListNode cur  = sentry;
        pre =sentry;
        //寻找左边节点
        for(int i= 0;i<left;i++){
            cur = cur.next;
            pre =cur;
        }
        first = pre;
        first.next = null;
        reversefirst = cur;
        for(int i = 0 ;i < right-left;i++){
            cur = cur.next;
            pre = cur;
        }
        last =  cur.next;
        reverselast = cur;
        reverselast.next = null;
        reverse(reversefirst);

        first.next  =  reverselast;
        reversefirst.next = last;
        return  sentry.next;

}
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode sentry =  new ListNode();
        ListNode pre = null;
        ListNode first = null,last =null;
        ListNode cur  = sentry;
        pre =sentry;
        //寻找左边节点
        for(int i= 0;i<left;i++){
            cur = cur.next;
            pre =cur;
        }
        first = pre;
        first.next = null;
        pre =null;
        for(int i = 0 ;i < right-left;i++) {
            ListNode temp = cur.next;
            cur.next =pre;
            pre = cur;
            cur =temp;
        }
        first.next = pre;
        return  sentry.next;

    }



}
