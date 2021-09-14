package Test;

import edu.princeton.cs.algs4.Stack;
import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner=  new Scanner(System.in);
        int Q =  scanner.nextInt();
        int n = scanner.nextInt();
        int arr[] =  new int[n];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = scanner.nextInt();
        }
        int res[] = new  int[n];
        LinkedList<Integer> stack =   new LinkedList<>();
        int cur  = 0;//指向队伍人数
        for (int i = 0; i <n ; i++) {
            int step = 0;
            if(stack.isEmpty()){
                 step+=cur;
                 cur++;
            }else{
                int a = stack.pollFirst();
                step+=a;
            }
            int num =  arr[cur];
            if(num==0){
                continue;
            }else{
                int nums = num;
                if(stack.size()>=num){
                    for (int j = 0; j < num; j++) {
                        step+=stack.pollFirst()-j;
                    }
                }else{
                    int size  =stack.size();
                    for (int j = 0; j < size; j++) {
                        step+=stack.pollFirst()-j;
                    }
                    int cha  =  num-stack.size();
                    for (int j = 0; j < cha; j++) {
                        step+=cur-size-j;
                        cur++;
                    }

                }
                for (int j = 1; j <=num; j++) {
                    stack.addFirst(i);
                }
            }
            res[i] =step;

        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
      //模拟
      //


    }
  //  [] [] [] [] []  某次移动的 位置 和 为
    /**
     *  1.当移动为0的时候  第一个人向前
     *  2.不为0的时候 n
     *    1.如果之前没有人移动 ，后面的第一个人（不是第一个位置）移动第一位，只有将后面n个人移动到前面
     *    2.将站在第一位的人移开，后面的人向前
     */




}