package leetcode;

/**
 * @Classname MiddleoftheLinkedList876
 * @Description:
 * @Date 2020/11/6 18:08
 * @Created by qiujunlin
 */
public class MiddleoftheLinkedList876 {
    //第一次 百分之百
    public ListNode middleNode(ListNode head) {
        int len=0;
        ListNode cur =head;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        len= len/2;
        cur=head;
        while(len>0){
            cur=cur.next;
            len--;
        }
        return cur;
    }
}
