package LinkedList;

import java.util.*;

/**
 * @Classname OddEvenLinkedList328
 * @Description:
 * @Date 2020/11/13 9:24
 * @Created by qiujunlin
 */
public class OddEvenLinkedList328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode(0),even=new ListNode(0),cur = head;
        int index=1;
        ListNode curodd=odd;
        ListNode cureven=even;
        while(cur != null){
            if(index%2==1) {
                curodd.next=cur;
                curodd=curodd.next;
            }
            else  {
                cureven.next=cur;
                cureven=cureven.next;
            }

            index++;
            cur=cur.next;
        }
        cureven.next=null;
        curodd.next=null;
        cureven =even.next;
        while(cureven!=null){
            curodd.next=cureven;
            cureven=cureven.next;
            curodd=curodd.next;
        }
        return odd.next;
    }
}
