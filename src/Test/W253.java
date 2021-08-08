package Test;

import java.util.*;

public class W253 {

    public boolean isPrefixString(String s, String[] words) {
        String ss = "";
        for (int i = 0; i < words.length; i++) {
            ss+=words[i];
            if(ss.equals(s)) return  true;
        }
        return  false;
    }
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<int[]>  queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (int i = 0; i < piles.length; i++) {
            queue.offer(new int[]{i,piles[i]});
        }
        while (k>0){
            int a[] =  queue.poll();
            a[1] = a[1]/2;
            queue.offer(a);
            k--;
        }
        int res  =0;
        for (int a[]:queue) {
            res+=a[1];
        }
        return  res;

    }

    public int minSwaps(String s) {
        int res = 0;
        int a[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i)=='['?0:1;
;        }
        return  0;


    }
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int res[] = new int[obstacles.length];
        int len[] = new int[obstacles.length];
        int index =0;
        res[0] =1;
        len[0] = obstacles[0];
        for (int i = 1; i <obstacles.length ; i++) {
            if(len[index]<=obstacles[i]) {
                 res[i] =index+2;
                 index++;
                 len[index] = obstacles[i];
            }else{
                int l  =0;
                int r  = index;
                while (l<r){
                    int mid  = (l+r)/2;
                    if(len[mid]<=obstacles[i]){
                        l = mid+1;
                    }else{
                        r= mid;
                    }
                }
                len[l] = obstacles[i];
                res[i] = l+1;
            }

        }
        return  res;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,2};
        System.out.println(new W253().longestObstacleCourseAtEachPosition(a));
    }



}
