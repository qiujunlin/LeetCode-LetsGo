package Test;

import java.util.*;
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
        GreetingService tes = (mes)->System.out.println("speak:"+mes);
        //tes.sayMessage("卧槽");

     //Integer a  = new Integer(12222);
       //  new Test3().aa(a);
        //System.out.println(a);
    HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
    HashMap<Integer,Integer>  m = map.computeIfAbsent(1,q->new HashMap<>());
    m.put(2,3);
      //  System.out.println(map);
    }
    void aa(Integer a){
        a=3333;
    }

}
