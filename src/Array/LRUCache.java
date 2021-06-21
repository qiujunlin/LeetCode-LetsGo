package Array;

import java.util.HashMap;
class  Node{
    Node left =null;
    Node right=null;
    int val;
    int key;
    public  Node(int key,int val){
        this.val  = val;
        this.key = key;
    }
}
public class LRUCache {

    int capacity;
    HashMap<Integer,Node> map ;
    Node head;
    Node last;
    public  LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head =  new Node(0,0);
        last =  new Node(0,0);
        head.right = last;
        last.left=head;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            resort(key);
            return  map.get(key).val;
        }else{
            return  -1;
        }
    }

    private void resort(int key) {
        Node  node =map.get(key);
        node.left.right = node.right;
        node.right.left=node.left;
        addlast(node);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
             map.get(key).val  =value;
             resort(key);
        }else{
            Node newnpode =  new Node(key,value);
            if(map.size()==capacity){
                deletefirst();
                map.remove(key);
            }
            addlast(newnpode);
            map.put(key,newnpode);
        }
    }

    private void addlast(Node newnpode) {
        last.left.right =  newnpode;
        newnpode.left=last.left;
        newnpode.right=last;
        last.left=newnpode;
    }

    private void deletefirst() {

        head.right=head.right.right;
        head.right.left=head;
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
