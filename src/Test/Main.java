package Test;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Stack;
import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().findIntegers(5);

    }
    public int findIntegers(int n) {
        int  res =0;
        int pre =0;
        int dp[] =  new int[32];
        dp[0] =1;dp[1] =1;
        for(int i=2;i<=31;i++) {dp[i] = dp[i-1] + dp[i-2];}
        for(int i=30;i>=0;i--){
            int val =  1<<i;
            if((n&val)!=0){
                res+=dp[i+1];
                System.out.println(n+ " "+i);
                n-=val;
                if(pre==1) break;
                pre=1;
            }else{
                pre=0;
            }
        }
        return res;

    }
}

//
//    private static boolean judge(HashSet<Integer> set, boolean[] vis,int pre ){
//        for (int i = 1; i <vis.length ; i++) {
//            if(vis[i]&&i!=pre){
//                if(set.contains(i))  return  false;
//            }
//        }
//        return  true;
//    }
    /**
     *
     6 7
     1 2
     2 3
     3 4
     4 5
     5 6
     1 6
     3 6
     */







