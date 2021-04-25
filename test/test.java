import Al4.Graph.KruskalMST;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.*;

public class test {
    @Test
    public  void test1(){
     List<Integer> lsit = new ArrayList<>();
     lsit.add(1);
     lsit.add(2);
     lsit.add(3);
     List<Integer> list2= new ArrayList<>(lsit);
     List<Integer> list3 = new ArrayList<>();
     list3.addAll(lsit);
     list3.set(1,200);
        Collections.addAll(lsit,9);
        List<Integer> list4 = new ArrayList<>();
        Collections.copy(list4,lsit);

     list2.set(1,100);
        System.out.println(lsit);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);


    }
    @Test
    public void test2(){
        int a[]= new int[100000];
        List<Integer> list = new ArrayList<>();
        for(int i=a.length-1;i>=0;i--) {
            a[i]=i;
            list.add(i);
        }

       // Collections.addAll(list,a);
        long startTime = System.currentTimeMillis();     //获取开始时间
        Arrays.sort(a);
        long overTime = System.currentTimeMillis();      //获取结束时间
        System.out.println("程序运行时间为："+(overTime-startTime)+"毫秒");
         startTime = System.currentTimeMillis();     //获取开始时间
       // Arrays.sort(a);
        PriorityQueue<Integer> queue = new PriorityQueue<>(list);
         overTime = System.currentTimeMillis();      //获取结束时间
        System.out.println("程序运行时间为："+(overTime-startTime)+"毫秒");
    }
}
