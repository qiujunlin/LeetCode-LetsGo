package Contest.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class W281 {
    public static void main(String[] args) {
        System.out.println("das");
    }
    public int countEven(int num) {
        int res =0;
        for (int i = 1; i <=num ; i++) {
            int c =0;
            int n =i;
            while (n>0){
                c+=n%10;
                n/=10;
            }
            if(c%2==0) res++;

        }
        return  res;

    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeNodes(ListNode head) {
        ListNode cur =head.next;
        ListNode pre =head;
        ListNode res =new ListNode(0);
        ListNode tt =res;
        while (cur!=null){
            int n =0;
            while (cur.val!=0) {
                n +=cur.val;
                cur=cur.next;
            }
            ListNode t =new ListNode(n);
            tt.next =t;
            tt=tt.next;
            cur =cur.next;
        }
        return  head;

    }
    public String repeatLimitedString(String s, int repeatLimit) {
        int hash[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            if(hash[i]!=0){
                q.offer(new int[]{i,hash[i]});
            }
        }
        //int min = Math.min(hash[i],repeatLimit);
        while (q.size()>0) {
            int a[] = q.poll();
            if (a[1] > repeatLimit) {
                append(repeatLimit, res, a[0]);
                a[1] -= repeatLimit;
            } else {
                append(a[1], res, a[0]);
                continue;
            }
            if (q.size() == 0) break;
            int b[] = q.poll();
            append(1, res, b[0]);
            b[1]--;
            if (b[1] != 0) q.offer(b);
            q.offer(a);
        }
        return res.toString();
    }

    /**
     * [8,10,2,5,9,6,3,8,2]
     * 6
     * 18
     * [3,9,6,5]
     * 1
     * 6
     * [5,9,5,5,10,9,2,6,7]
     * 2
     * 21
     * @param repeatLimit
     * @param res
     * @param i
     */
    private void append(int repeatLimit, StringBuilder res, int i) {
        char c = (char)(i+'a');
        while (repeatLimit>0){
            res.append(c);repeatLimit--;
        }
    }
    public long coutPairs(int[] nums, int k) {
        if(nums.length<1) return  0;
        if(k==1) {
            int n =nums.length;
            return  n*(n-1)/2;

        }

        return  res;



    }

    ArrayList<Integer> fenjie(int num){

      ArrayList<Integer> res =new ArrayList<>();
        HashSet<Integer> set =new HashSet<>();
        int i = 2;

        while (i <= num) {
            if (num % i == 0) {

              set.add(i);
                num = num / i;

                i = 2;
            } else {
                i++;
            }
        }
        for(int a:set)res.add(a);
        return  res;

    }
}
