package leetcode;

/**
 * @Classname ReverseLinkedList206
 * @Description:
 * @Date 2020/11/6 19:57
 * @Created by qiujunlin
 */
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        ListNode newhead=head,cur=null;
        while(head!=null){
            newhead=head;
            head=head.next;
            newhead.next=cur;
            cur=newhead;
        }
        return cur;
    }
    //通过递归的方式翻转连表
    public ListNode reverseList2(ListNode head) {
        if(head==null||head.next==null){
            return head;

        }
        ListNode node = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;

    }
}
