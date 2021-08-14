package Array;

import java.util.HashMap;
import java.util.HashSet;

public class Q1853 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
         int order[][]=  new  int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n-1 ; j++) {
                order[i][preferences[i][j]] = j;
            }
        }
        HashMap<Integer,Integer>  map = new HashMap<>();
        for(int arr[] :pairs){
            map.put(arr[0],arr[1]);
            map.put(arr[1],arr[0]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int pairi  =  map.get(i);//获取和x 配对的孩子
            int index  = order[i][pairi];//获取与x配对的人  的坐标
            for (int j = 0; j < index; j++) { // 遍历与x更亲近的人
                int pairj  =  map.get(j); // 获取与x更亲近的人j 的配对
                // 这个时候 以及瞒住第一个条件  x 与 j 的亲近程度 大于 x 与pair 1、
                // 需要瞒住的条件是  j与x的亲近成都 必须要大于 parij
                if(order[j][i]>order[j][pairj]){
                    res++;
                    break;
                }

            }

        }
        return  res;
    }


}
