package leetcode;

import java.util.*;

/**
 * @Classname InsertInterval57
 * @Description:
 * @Date 2020/11/5 11:20
 * @Created by qiujunlin
 */
public class InsertInterval57 {
    //第一次 参照56的写法
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int temp[][]= new int[intervals.length+1][2];
        System.arraycopy(intervals,0,temp,0,intervals.length);
        temp[intervals.length]=newInterval;
        intervals=temp;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        int len=-1;
        for(int i=0;i<intervals.length;i++){

            if(list.size()==0||list.get(len)[1]<intervals[i][0]){
                list.add(intervals[i]);
                len++;
            }else{
                list.set(len,new int[]{list.get(len)[0],Math.max(list.get(len)[1],intervals[i][1])});
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
    //解法2 最优解
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();


        int index=0;//记录intervals的下标
        while(index<intervals.length&&intervals[index][1]<newInterval[0]){
            list.add(intervals[index]);
            index++;
        }


        while(index<intervals.length&&intervals[index][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[index][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[index][1],newInterval[1]);
            index++;
        }

        list.add(newInterval);
        while(index<intervals.length){
            list.add(intervals[index++]);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
