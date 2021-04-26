package Test;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        PriorityQueue<Integer> q  = new PriorityQueue<>((a,b)->a-b);
        ArrayList<Integer>  list[] = new ArrayList[10];
        for(int i=0;i<5;i++)list[i]= new ArrayList<>();
        ArrayList<Integer> a = list[0];
        a.add(1);
        // List<Integer>[] li2 = new ArrayList<Integer>[10];
        q.offer(1);
        System.out.println(a);

        ArrayList<Object> arrayList1= new ArrayList<>();
    }
}
