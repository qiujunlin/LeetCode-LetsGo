package leetcode;

public class Skiplist {

    int maxlevel = 32;
    double possble  = 0.25;
    int curmaxlevel =1;
    Node head =new Node(null,maxlevel);
    public Skiplist() {

    }

    public boolean search(int target) {

        for (int i = curmaxlevel-1; i >=0 ; i--) {
            // 查找节点  1. 当前层的节点为空 2. 查找到了 当前层的节点的下一个节点不为空
            Node curnode  = searchnext(head,i,target);
            if(curnode.next[i]!=null) {
                if(curnode.next[i].val==target) return  true;

            }

        }
        return  false;

    }

    public void add(int num) {
        int level =  randLevel(); //当前节点dlevel
        Node addnode  = new Node(num,level);
        for (int i = curmaxlevel-1; i >=0 ; i--) {
            Node curnode  = searchnext(head,i,num);
            if(i+1<=level){
                if(curnode.next[i]==null)
                curnode.next[i] =  addnode;
                else{
                    Node temp = curnode.next[i];
                    curnode.next[i] = addnode;
                    addnode.next[i] = temp;

                }
            }

        }
        if(level>curmaxlevel){
            for (int i = curmaxlevel; i <level ; i++) {
                head.next[i] = addnode;
            }
            curmaxlevel = level;
        }
    }
   //
    public boolean erase(int num) {
         boolean flag = false;
        for (int i = curmaxlevel-1; i >=0 ; i--) {
            // 查找节点  1. 当前层的节点为空 2. 查找到了 当前层的节点的下一个节点不为空
            Node curnode  = searchnext(head,i,num);
            if(curnode.next[i]!=null&&curnode.next[i].val==num) {
                curnode.next[i] = curnode.next[i].next[i];
                 flag = true;
            }

        }
        return  flag;


    }
    //寻找从当前节点node 开始 ，下一个节点不大于val的节点或者是当前level开始
    // level 是指当前节点所在的level
    // 返回值可能是当前节点
    public  Node searchnext(Node node,int level,int val){
        while (node.next[level]!=null&&node.next[level].val>val){
            node = node.next[level];
        }
        return  node;

    }
    public  int randLevel(){
        int level = 1;
        while (Math.random()<possble&&level<=maxlevel)level++;
        return  level;
    }
    class Node{
        Integer val;
        Node next[];
        public  Node(Integer val,int lev){
            this.val = val;
            this.next =new Node[lev];
        }
    }
}
