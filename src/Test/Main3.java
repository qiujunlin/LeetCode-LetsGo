package Test;
import com.sun.org.apache.xerces.internal.xs.StringList;
import edu.princeton.cs.algs4.Stack;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import  java.util.*;
public class Main3 {
    public static void main(String[] args) throws  Exception{
        Base<String>  ba = new Base<String>();
        for(Field field :ba.getClass().getFields()){
            Type gtype = field.getGenericType();
            Type type[] = ((ParameterizedType) gtype).getActualTypeArguments();
            System.out.println(type[0].getTypeName());
            System.out.println("定义的泛型："+field.getGenericType()+" 实际的类型： " + field.getType());
        }
    }
}
class Base<T >{
    public T  t;
    public HashMap<T,T> map;
    public  List<T> list;

    public  void test(T t){
        System.out.println(t);
    }
}



