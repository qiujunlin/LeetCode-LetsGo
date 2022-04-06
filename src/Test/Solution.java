package Test;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner s  =new Scanner(System.in);
        int n  = s.nextInt();
        int m = s.nextInt();
        HashMap<String,Node>  map =new HashMap<>();
        s.nextLine();
        while (m>0){
            String title  = s.nextLine();
            String content  = s.nextLine();
            String [] arr1 = title.split("\\s+");
            for(String str :  arr1) map.computeIfAbsent(str,(key)->new Node(str)).count+=3;
            String [] arr2 = content.split("\\s+");
            for(String str :  arr2) map.computeIfAbsent(str,(key)->new Node(str)).count+=1;
            m--;
        }
        PriorityQueue<Node>  q = new PriorityQueue<>((a,b)->{
            Node n1 = (Node)a;Node n2 = (Node)b;
            if(n1.count==n2.count) return  n2.c  - n1.c;
             else   return  n1.count-n2.count;
        });
        for(String str : map.keySet()){
             q.offer(map.get(str));
             while (q.size()>n) q.poll();
        }
        LinkedList<String>  l =new LinkedList<>();
        Iterator<Node>  iterator = q.iterator();
        while (iterator.hasNext()) l.addFirst(iterator.next().s);
        String res =String.join(" ",l);
        System.out.println(res);
    }
    static int shunxu = 1;
    static  class  Node{
        String s ;int count =0;
        int c  =0;
        public  Node(String s){
            this.s = s; this.c =++shunxu;
        }
    }

}
