package Test.Dichen;

import edu.princeton.cs.algs4.In;

import java.lang.reflect.*;
import java.util.HashMap;

public class MethodDemo {

    public static void main(String[] args) {
    //    System.out.println(new Integer(2)==new Integer(2).);
     //   processMethod();
    }
   static  void processFiled(){

       Field[] fields = SampleClass.class.getDeclaredFields();
       for (int i = 0; i < fields.length; i++) {
           System.out.println(fields[i].getType());
           System.out.println(fields[i].getGenericType());

       }
       Method[]  methods = SampleClass.class.getMethods();
       methods[0].getParameterTypes();

    }
    static  void processMethod(){
        Method[] methods = SampleClass.class.getDeclaredMethods();
        for (int i = 0; i <methods.length ; i++) {
            Type[]  types =  methods[i].getParameterTypes();
            Type[]  types1 =  methods[i].getGenericParameterTypes();
            Type[]  types2 = methods[i].getTypeParameters();
            Class[] classes =  methods[i].getParameterTypes();

            for(int j  = 0;j<types1.length;j++){
                Type type =   types1[j];
                Class c =  classes[j];
                System.out.println(type instanceof  ParameterizedType);
               // System.out.println();
                System.out.println(c.getCanonicalName());
                if(!(type instanceof  ParameterizedType)) continue;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArgs = parameterizedType.getActualTypeArguments();
                for (Type type1 :  actualTypeArgs){
                    System.out.println(type1.getTypeName());
                }
            }
            System.out.println(1);
        }
    }
}

class SampleClass <E>{
    private String sampleField;
    HashMap<E,Integer> map;
    HashMap map2;
    E a;

//    public String getSampleField() {
//        return sampleField;
//    }

    public void setSampleField(HashMap map1, HashMap<Integer,String> map) {
        this.sampleField = sampleField;
    }
}
