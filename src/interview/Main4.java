package interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main4 {
    static  class A{
        int val =1;
        static  int b =1;

    }
    static  class B extends A{

    }
    public static void main(String[] args) {
      B b =new B();
      System.out.println(b.b);
    }
}
