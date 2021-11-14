package Contest.week;
import  java.util.*;
public class W267 {
    public static void main(String[] args) {

    }
   // HashMap<Integer,Integer> map =new HashMap<>();
   public int timeRequiredToBuy(int[] tickets, int k) {
        int res  =0;
        while (true) {
            for (int i = 0; i < tickets.length; i++) {
               // if(i==)
                if (tickets[i]!=0){
                    res++;
                    tickets[i]--;
                    if(i==k){
                        if(tickets[i]==0) return  res;
                    }
                }

            }
        }
      //  return  res;

   }

    /**
     *[0,4,2,1,3]  [0,2,4,1,3]  [0,2,4,3,1]
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int  count  =0;
        ListNode cur  =new ListNode();
        cur.next = head;
       // head = cur.next;
        boolean  isOld =false;
        ListNode pre  = cur;
        int time = 1;
        ListNode preNode  = cur;
        while (head!=null){
            //head=head.next;
            count++;
            if(count>=time){
             if(count%2!=0){ //jisu
                count=0;
              //  count++;
                isOld = true;
                pre =head;
             }else{ //oushu
                ListNode next =  head.next;
                head.next =null;
                ListNode temp = pre.next;
                pre.next =null;
                ListNode node =  reverseList(temp);
                pre.next = node;
                temp.next =  next;
                head=  temp;
                isOld= false;
                pre = temp;
                count=0;
                 System.out.println(head.next);
             }
             time++;
            }
            preNode =head;
            head =head.next;

        }
        if(count%2==0){
            ListNode temp = pre;
            ListNode node =pre.next;
            pre.next=null;
            temp.next=reverseList(node);
        }
        return  cur.next;


    }
    public ListNode reverseList(ListNode node) {
        if(node==null||node.next==null){
            return node;
        }
        ListNode head = reverseList(node.next);
        node.next.next =  node;
        node.next = null;
        return head;
    }

    /**
     * "ch   ie   pr"
     * 3
     * "cipher"
     * @param encodedText
     * @param rows
     * @return
     */
    public String decodeCiphertext(String encodedText, int rows) {
        if(encodedText.length()==0) return "";
        int len = encodedText.length();
        int w = len/rows;
        StringBuilder res= new StringBuilder();

        for (int i = 0; i < w; i++)          {

            int y = rows; int x =i-1;
            for (int j = 0; j < rows ; j++) {
                 y--;
                 x++;
                 if(x>w-1) break;
                 int index = (rows-1-y)*w + x;
                 res.append(encodedText.charAt(index));
            }
        }
     // while ()
        String ress = res.toString();
        int index =res.length()-1;
        while (ress.charAt(index)==' ') index--;
      return  ress.substring(0,index+1);


    }

    /**
     *
     * 8
     * [[6,4],[7,5],[2,6],[1,5],[6,7],[6,5],[0,3],[5,4],[0,4],[2,7],[0,2]]
     * [[6,3],[0,2],[0,5],[0,3],[6,4],[2,4],[1,0],[2,1],[2,5],[6,7],[7,0],[3,2],[3,5],[2,1],[1,6],[7,4],[6,3],[1,3],[6,5],[3,7],[7,0],[6,5],[0,5],[0,4],[7,5],[7,0],[7,0],[1,3]]
     * [true,false,true,false,false,true,false,true,false,false,false,false,false,true,false,false,true,false,false,false,false,false,true,false,false,false,false,false]
     */
    public class Union {
        private  int parent[];
        int count  =0 ;
        HashMap<Integer,HashSet<Integer>> map =new HashMap<>();
        public Union(int n ){
            this.count = n ;
            this.parent =  new int[n];
            for (int  i =0;i<n;i++) {
                this.parent[i] = i;
            }
            for (int i = 0; i < n; i++) {
                map.computeIfAbsent(i,(key)->new HashSet()).add(i);
            }
        }
        public  boolean merge(int x,int y){
            int newx = find(x);
            int newy = find(y);

            if(newx==newy) return true;
            else{
                HashSet<Integer> set1 =map.get(newx);
                HashSet<Integer> set2 =map.get(newy);
                for(int c:set1) {
                    if (mapConnet.get(c) != null) {
                        for (int a : mapConnet.get(c)) {
                            if (set2.contains(a)) return false;
                        }
                    }
                }
                for(int c:set2) {
                    if (mapConnet.get(c) != null) {
                        for (int a : mapConnet.get(c)) {
                            if (set1.contains(a)) return false;
                        }
                    }
                }
               // for(int a:set1.addAll())

                parent[newx] = newy;
                count--;
                map.get(newy).addAll(map.get(newx));
                map.get(newx).addAll(map.get(newy));
                return  true;
            }
        }
        public int find(int x){
            return  x==parent[x]?(x):(parent[x] = find(parent[x]));
        }
        public boolean isconnected(int x,int y){
            return  find(x) ==find(y);
        }
    }
    HashMap<Integer,HashSet<Integer>> mapConnet =new HashMap<>();
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {

              for(int a[]:restrictions){
                  mapConnet.computeIfAbsent(a[0],(key)->new HashSet<>()).add(a[1]);
                  mapConnet.computeIfAbsent(a[1],(key)->new HashSet<>()).add(a[0]);
              }
              boolean[] res =new boolean[requests.length];
              Union u =new Union(n);

        for (int i = 0; i <requests.length ; i++) {
         res[i]=    u.merge(requests[i][0],requests[i][1]);
        }
        return  res;

    }
}
