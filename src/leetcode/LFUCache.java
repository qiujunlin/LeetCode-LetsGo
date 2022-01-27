package leetcode;
import  java.util.*;
class LFUCache {
    class Node{
        int key;int val;
        int use=0;
        public Node(int key,int val){
            this.key =key;
            this.val =val;
        }
    }
    int capacity;
    // count
    // HashMap<Node,Integer> map =new HashMap();
    HashMap<Integer,Node> h = new HashMap();
    // 最久未使用
    HashMap<Integer,LinkedList<Node>> l  =new HashMap();
    public LFUCache(int capacity) {
        this.capacity =capacity;
    }

    public int get(int key) {
        if(!h.containsKey(key)) return -1;
        Node n = h.get(key);
        addlast(n);
        return n.val;

    }

    public void put(int key, int value) {
        if(h.containsKey(key)){
            //1. 取出node
            Node n = h.get(key);
            n.val =value;

        }else{
            Node n = new Node(key,value);
            h.put(key,n);
            // 1. 加入计数
            LinkedList<Node> temp = l.computeIfPresent(0,(key)->new LinkedList());

            // 2. 加入链表
            temp.addLast(n);

        }

    }
    void addlast(Node n){
        //2. 使用+1，删除节点 加入链表
        LinkedList<Node>  temp = l.get(n.use);
        temp.remove(n);
        n.use++;
        LinkedList<Node> newtemp=l.computeIfPresent(n.use,(key,b)->new LinkedList());
        newtemp.addLast(n);
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> map =new HashMap<>();
        map.computeIfAbsent(1,(a)->new Integer(1));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */