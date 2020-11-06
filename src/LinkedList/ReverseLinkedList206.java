package LinkedList;

import java.util.*;

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
}
