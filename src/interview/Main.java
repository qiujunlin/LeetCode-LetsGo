package interview;



import java.util.*;

public class Main {


    public static void main(String[] args) {



    }
    Node max ;
    HashMap<String,Node> map =new HashMap<>();
    Node first = new Node(-1);
    Node last = new Node(-1);
    public  Main(){
        first.next =last;
        last.pre=first;
    }
    public void inc(String key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            if(n.next==last){
                Node newnode =new Node(n.count+1);
                newnode.pre =n;
                last.pre =newnode;
                newnode.next=last;
            }
            n.cur.remove(key);
            n.next.cur.add(key);
            if(n.cur.size()==0) remove(n);
        }else{
            if(first.next==last){
                Node n  =new Node(1);
                first.next=n;
                n.pre =first;
                n.next =last;
                last.pre=n;
                n.cur.add(key);
                map.put(key,n);
            }else{
                Node  n =  first.next;
                n.cur.add(key);
                map.put(key,n);
            }

        }
    }

    private void remove(Node n) {
        n.pre.next =n.next;
        n.next.pre = n.pre;
    }

    public void dec(String key) {
        Node n = map.get(key);
        n.cur.remove(key);
        if(n.count!=1) {
            if (n.pre.count != n.count - 1) {
                Node newnode = new Node(n.count - 1);
                newnode.pre = n.pre;
                n.pre.next = newnode;
                newnode.next = n;
                n.pre = newnode;
            } else {
                n.pre.cur.add(key);
            }
        }
        if(n.cur.size()==0) {
            remove(n);
        }

    }

    public String getMaxKey() {
         if(last.pre!=first) return  last.pre.cur.iterator().next();
         else return  "";
    }

    public String getMinKey() {
        if(first.next!=last) return  first.next.cur.iterator().next();
        else return  "";
    }
    static class Node {
        Integer count ;
        HashSet<String> cur;
        Node pre;
        Node next;

        public  Node(int a){
            this.count =0;
            this.cur =new HashSet<>();
        }

    }

}