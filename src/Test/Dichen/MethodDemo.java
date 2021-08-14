package Test.Dichen;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;

public class MethodDemo {

    public static void main(String[] args) {
  processMethod();
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
        Method[] methods = SampleClass.class.getMethods();
        for (int i = 0; i <methods.length ; i++) {
            Type[]  types =  methods[i].getParameterTypes();
            Type[]  types1 =  methods[i].getGenericParameterTypes();
            Type[]  types2 = methods[i].getTypeParameters();
            System.out.println(1);
        }
    }
}

class SampleClass <E>{
    private String sampleField;
    HashMap<E,Integer> map;

    public String getSampleField() {
        return sampleField;
    }

    public void setSampleField(String sampleField, HashMap<Integer,String> map) {
        this.sampleField = sampleField;
    }
}
