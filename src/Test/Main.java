package Test;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        String  s =  "-10";
        Scanner  scanner = new Scanner(System.in);

        while (true){
            s = scanner.nextLine();
            System.out.println(StringUtil.isNumer(s));
        }



    }


}

