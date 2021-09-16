package Test;

import edu.princeton.cs.algs4.Stack;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer a[] = new Integer[10];
        System.out.println(a[0]==null);
        char c = 'a';
        String  s=   "";
        System.out.println(s+String.valueOf(c));
        ArrayList arrayList =  new ArrayList();
    }
}



  //  [] [] [] [] []  某次移动的 位置 和 为
    /**
     *  1.当移动为0的时候  第一个人向前
     *  2.不为0的时候 n
     *    1.如果之前没有人移动 ，后面的第一个人（不是第一个位置）移动第一位，只有将后面n个人移动到前面
     *    2.将站在第一位的人移开，后面的人向前
     */




