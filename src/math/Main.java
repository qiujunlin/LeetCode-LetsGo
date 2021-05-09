package math;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
class  Node{
    int id;
    Node next;
    public  Node(int val){
        this.id=  val;
        this.next=null;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  num = scanner.nextInt();
        int  time = scanner.nextInt();
        int arr[][] = new int[time][2];
        for(int i=0;i<num;i++){
            arr[i][0]=scanner.nextInt();
            arr[i][1]=scanner.nextInt();
        }
        Node head = new Node(0);
        Node cur = head;
        HashMap<Integer,Node> map = new HashMap<>();
        for(int i=1;i<=num;i++){
            cur.next = new Node(i);
            map.put(i,cur);
            cur = cur.next;
        }

        for(int i=0;i<num;i++){
            int a =  arr[i][0];
            int b  =arr[i][1];
            Node pre = map.get(a);
            Node first =map.get(a).next;
            Node last = first;
            while (b>0&&last!=null){
                last=last.next;
            }
            Node last2 =null;
            if(last==null) last2=null;
            else last2 = last.next;
            last.next =  head.next;
            pre.next= last2;
            head.next=first;
        }
        cur =head.next;
        while (head!=null){
            System.out.print(cur.id+" ");

        }
    }
}
