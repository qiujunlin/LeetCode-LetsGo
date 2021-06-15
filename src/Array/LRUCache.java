package Array;

import java.util.HashMap;
class  Node{
    Node left =null;
    Node right=null;
    int val;
    int key;
    public  Node(int val,int key){
        this.val  = val;
        this.key = key;
    }
}
public class LRUCache {

    int capacity;
    HashMap<Integer,Node> map ;
    Node last;
    Node head;
    public  LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        //  head = new Node(-1,0);
    }
    public int get(int key) {
        if(map.containsKey(key)) {
            int  res =map.get(key).val;
            Node node = map.get(key);
            if(map.size()==1) return  res;
            //是头结点
            if(head==node) {
                head=node.right;
                node.right=null;
                head.left=null;
                last.right=node;
                node.left=last;
                last =node;
            }else if(node.left!=null){
                node.left.right=node.right;
                node.right.left =node.left;
                node.left=last;
                last.right=node;
                node.right =null;
                last = node;
            }
            return  res;
        }
        else return  -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val=value;
            //cap =1
            if(capacity==1){
                map.clear();
                map.put(key,node);
                return;
            }
            if(map.size()==1){
                node.val=value;
                return;
            }
            if(node==last) return;
            //是头结点
            if(head==node) {
                head=node.right;
                node.right=null;
                head.left=null;
                last.right=node;
                node.left=last;
                last =node;
            }else if(node.left!=null){
                node.left.right=node.right;
                node.right.left =node.left;
                node.left=last;
                last.right=node;
                node.right =null;
                last = node;
            }
        }else{
           // System.out.println(map);

            Node node = new Node(value,key);
            if(capacity==1||map.size()==0){
                map.clear();
                map.put(key,node);
                head=node;
                last =node;
                return;
            }
            if(map.size()==1){
                map.put(key,node);
                head.right =node;
                node.left =head;
                last=node;
                return;
            }
            if(map.size()==capacity) {
                // System.out.println(head.val);
                map.remove(head.key );
                head=head.right;
                head.left=null;

            }
            last.right = node;
            node.left=last;
            last = node;
            // System.out.println(last.val);
            map.put(key,node);
        }

    }

    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.put(1,1);
        l.put(2,2);
        System.out.println(l.get(1));
        l.put(3,3);
        System.out.println(l.get(2));
        l.put(4,4);
        System.out.println();

    }
}



/**
 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
 * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
