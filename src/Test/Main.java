package Test;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        Field[] fields = Student.class.getDeclaredFields();
        System.out.println(fields[0].getType()); // 输出 class java.lang.Object
        System.out.println(fields[0].getGenericType()); //输出 T
        Type genericType = fields[0].getGenericType();
        ParameterizedTypeImpl parameterTypeImpl = (ParameterizedTypeImpl) genericType;
        TypeVariable<? extends Class<?>>[] typeVariables = parameterTypeImpl.getRawType().getTypeParameters();
        Type[] actualTypeArguments = parameterTypeImpl.getActualTypeArguments();
        for (int i = 0; i < typeVariables.length; i++) {
            System.out.println(typeVariables[i].getName() + "  "+ actualTypeArguments[i].getTypeName());
        }
        System.out.println("Dsad");




    }

    class Student<T> {
        HashMap<Integer, T> age;
    }

}

