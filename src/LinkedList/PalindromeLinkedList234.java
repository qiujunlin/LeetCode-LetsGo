package LinkedList;

import java.util.*;

/**
 * @Classname PalindromeLinkedList234
 * @Description:
 * @Date 2020/11/6 18:31
 * @Created by qiujunlin
 */
public class PalindromeLinkedList234 {
    //第一次
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        for(int i=0,j=list.size()-1;i<j;i++,j--){
            if(!list.get(i).equals(list.get(j))) return false;
        }
        return true;
    }

}
