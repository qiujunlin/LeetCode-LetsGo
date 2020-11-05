package Array;

import java.util.*;

/**
 * @Classname MergeIntervals56
 * @Description:
 * @Date 2020/11/4 9:58
 * @Created by qiujunlin
 */
public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
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
}
