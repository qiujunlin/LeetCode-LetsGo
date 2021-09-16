package Test;

import edu.princeton.cs.algs4.Stack;
import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
           Scanner scanner =  new Scanner(System.in);
           String s1 =  scanner.nextLine();
           String s2 =  scanner.nextLine();
           int len =  new Main().longestCommonSubsequence(s1,s2);
           System.out.println(s2.length()-len);


    }

        public int longestCommonSubsequence(String text1, String text2) {
            int m = text2.length(), n = text1.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                char c1 = text2.charAt(i - 1);
                for (int j = i; j <= n; j++) {
                    char c2 = text1.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }


  //  [] [] [] [] []  某次移动的 位置 和 为
    /**
     *  1.当移动为0的时候  第一个人向前
     *  2.不为0的时候 n
     *    1.如果之前没有人移动 ，后面的第一个人（不是第一个位置）移动第一位，只有将后面n个人移动到前面
     *    2.将站在第一位的人移开，后面的人向前
     */




}