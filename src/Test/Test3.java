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

        long startTime = System.currentTimeMillis();     //获取开始时间
        int arr[] = new int[3];
        int a =2;
        arr[a--] = a;
         for (int x:arr) System.out.print(x + " ");
        long overTime = System.currentTimeMillis();      //获取结束时间
        System.out.println("程序运行时间为："+(overTime-startTime)+"毫秒");


    }
   static void te(int x) {
        System.out.println(x);
    }
}
