package template.DataStructure;



public class Skiplist {
    int curmaxlevel  = 1;
    int MAXLEVEL = 32;
    double factor =  0.25;
    Node head ;
    public Skiplist() {
        this.head = new Node(0,MAXLEVEL);
    }
    public int  randomLevel(){
        int level =1;
        while (Math.random()<factor&&level<MAXLEVEL){
            level++;
        }
        return  level;
    }
    //目的是为了找到 level层中，第一个大于等于num的节点。返回的节点是第一个大于等于num的节点的前一个节点。
    public  Node findnext(int level ,Node node,int num){
        // Systrem.out.print(curmaxlevel)
        while (node.next[level]!=null&&node.next[level].val<num){
            node = node.next[level];
        }
        return  node;
    }

    public boolean search(int target) {

        for (int i = curmaxlevel; i >=1 ; i--) {
            Node  node = findnext(i-1,head,target);
            if(node.next[i-1]!=null&&node.next[i-1].val==target){
                return  true;

            }
        }
        return  false;



    }

    public void add(int num) {
        int levl = randomLevel();
        Node addnode = new Node(num,levl);
        Node srarchnode = head;
        // 插入的时候其实也是一层一层的插入。 每一层插入的过程和链表一样。
        //  i为第几层，实际的下标为层数减一
        for (int i = curmaxlevel; i >=1 ; i--) {
            srarchnode = findnext(i-1,srarchnode,num);
            if(levl >= i){

                if(srarchnode.next[i-1]==null){
                    srarchnode.next[i-1]=addnode;
                }else{
                    Node temp =  srarchnode.next[i-1];
                    srarchnode.next[i-1] = addnode;
                    addnode.next[i-1] = temp;
                }

            }
        }
        if(levl>curmaxlevel) curmaxlevel = levl;
        while (levl>curmaxlevel){
            head.next[levl-1] =  addnode;
            levl--;
        }

    }
    //删除的时候，其实就是一层一层的找到num节点的前一个值，一层一层的删除。
    public boolean erase(int num) {
        boolean hash=false;
        Node eraseNode=  head;
        for (int i = curmaxlevel; i >=1 ; i--) {
            eraseNode = findnext(i-1,eraseNode,num);
            if(eraseNode.next[i-1]!=null&&eraseNode.next[i-1].val==num){
                eraseNode.next[i-1] = eraseNode.next[i-1].next[i-1];
                hash =true;
            }

        }
        return  hash;


    }
    class Node{
        Node next[];
        int val;
        public  Node(int val ,int level){
            this.val =val;
            this.next = new Node[level];
        }
    }

    public static void main(String[] args) {

    }
}
