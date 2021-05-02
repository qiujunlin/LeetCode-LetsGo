package Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //long startTime = System.currentTimeMillis();     //获取开始时间
        Scanner sca = new Scanner(System.in);
        int len = sca.nextInt();
        String str[] = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = sca.next();
        }
        for (int j = 0; j < len; j++) {
            BigInteger bigInteger = new BigInteger(str[j],16);
            System.out.println(bigInteger.toString(8));
        }
        //long overTime = System.currentTimeMillis();      //获取结束时间
       // System.out.println("程序运行时间为："+(overTime-startTime)+"毫秒");
    }
}
