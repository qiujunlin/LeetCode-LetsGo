package leetcode;

import java.util.*;

/**
 * @Classname KClosestPointstoOrigin973
 * @Description:
 * @Date 2020/11/9 11:36
 * @Created by qiujunlin
 */
public class KClosestPointstoOrigin973 {
    //暴力法   超过百分之50
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points,(a,b)->a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]);
        int a[][]= new int[K][2];
        for(int i=0;i<K;i++){
            a[i]=points[i];
        }
        return a;
    }
    //解法2  使用优先队列
    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int []>(){


            public int compare(int a1[], int a2[]){
                return  a2[0] - a1[0];
            }

        });
        for(int i = 0 ; i < K ; i++){
            queue.offer(new int[]{points[i][0]*points[i][0]+points[i][1]*points[i][1],i});

        }
        for(int i=K;i<points.length;i++){
            int len= points[i][0]*points[i][0]+points[i][1]*points[i][1];
            if(queue.element()[0]>len){
                queue.poll();
                queue.offer(new int[]{len,i});
            }
        }
        int res[][]= new int[K][2];
        for(int i=0;i<K;i++){
            res[i]=points[queue.poll()[1]];
        }
        return res;

    }
    }

