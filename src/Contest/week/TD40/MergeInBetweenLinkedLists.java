package Contest.week.TD40;

/**
 * @Classname MergeInBetweenLinkedLists
 * @Description:
 * @Date 2020/11/29 11:22
 * @Created by qiujunlin
 */
class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res=list1;

        ListNode first=null,second=null;
        int num=0;
        // int pre=list1;

        while(list1!=null){
            num++;
            if(num==a){
                first=list1;
            }
            if(num-2==b){
                second=list1;
            }
            list1=list1.next;

        }
        first.next=list2;
        ListNode l2=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=second;
        return res;
    }
}
