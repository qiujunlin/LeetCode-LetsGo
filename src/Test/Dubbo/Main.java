package Test.Dubbo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: weq
 * @author: qiujunlin
 * @create: 2021-09-20 21:05
 */
public class Main {
    public static void main(String[] args) throws Exception {
         //  parent.say();
        Class<People> peopleClass =  People.class;
        Method method =  peopleClass.getMethod("say",String.class);
    //    People people =  (People) peopleClass.getConstructor().newInstance();
        method.invoke(peopleClass.newInstance(),"哈哈哈");
        System.out.println();

    }

}
class  People{
    public  void say(String s){
        System.out.println( "say：" +s );
    }
}
