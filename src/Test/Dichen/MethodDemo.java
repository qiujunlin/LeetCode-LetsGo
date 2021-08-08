package Test.Dichen;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;

public class MethodDemo {

    public static void main(String[] args) {
        Method[] methods = SampleClass.class.getMethods();
        Type[] parameters = methods[1].getGenericParameterTypes();
      //  Type[] parameters2 = methods[1].getTypeParameters();
        Field[] fields = SampleClass.class.getDeclaredFields();
        System.out.println(fields[1].getType()); // 输出 class java.lang.Object
        System.out.println(fields[1].getGenericType());
        Type[] parameters3 = methods[1].getParameterTypes();
        TypeVariable[] typeVariables = SampleClass.class.getTypeParameters();
        System.out.println(typeVariables[0]);
        for (int i = 0; i < parameters.length; i++) {
            System.out.println(parameters[i]);
            //System.out.println(parameters2[i]);
            System.out.println(parameters3[i]);
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
