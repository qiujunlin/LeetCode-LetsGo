package Test;

import java.util.*;



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
        Random random = new Random();
        for(int i=0;i<100;i++) System.out.println( random.nextInt(2));
        long overTime = System.currentTimeMillis();      //获取结束时间
        System.out.println("程序运行时间为："+(overTime-startTime)+"毫秒");


    }
   static void te(int x) {
        System.out.println(x);
    }
}
