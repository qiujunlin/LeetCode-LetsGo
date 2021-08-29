package Test;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.*;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {
        final Pattern sqlCommentPattern = Pattern.compile("'.*(or|union|--|#|/*|;)", Pattern.CASE_INSENSITIVE);
        String s ="w#";
        System.out.println(sqlCommentPattern.matcher(s).matches());


    }


}

