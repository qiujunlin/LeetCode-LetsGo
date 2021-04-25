package Test;

import java.util.*;

import Al4.Graph.KruskalMST;
import  edu.princeton.cs.algs4.*;

/**
 * @Classname Test3
 * @Description:
 * @Date 2021/3/26 19:43
 * @Created by qiujunlin
 */

@FunctionalInterface
interface GreetingService
{
    void sayMessage(String message);
}
public class Test3 {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i=0;i<100000;i++){
            list1.addLast(i);
            list2.add(i);
        }
        long startTime = System.currentTimeMillis();     //获取开始时间
        for(int i =0;i<list1.size();i++) list1.get(i);
        long overTime = System.currentTimeMillis();      //获取结束时间
        System.out.println("程序运行时间为："+(overTime-startTime)+"毫秒");
         startTime = System.currentTimeMillis();     //获取开始时间
        for(int i =0;i<list2.size();i++) list2.get(i);
         overTime = System.currentTimeMillis();      //获取结束时间
        System.out.println("程序运行时间为："+(overTime-startTime)+"毫秒");



    }
}
