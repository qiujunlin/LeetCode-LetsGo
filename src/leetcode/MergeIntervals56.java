package leetcode;

import java.util.*;

/**
 * @Classname MergeIntervals56
 * @Description:
 * @Date 2020/11/4 9:58
 * @Created by qiujunlin
 */
public class MergeIntervals56 {
    /*解法思路
1.首先是将数组进行一个排序
2. 将1个数据加入到里面，开始比较，p,q,如果p的p.left<q.left ,p.right= max(p.right,q.right)
   p.left>q.left,
* */
    public int[][] merge(int[][] intervals) {
        //第一次写法
        if(intervals.length==0) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return  o1[0]-o2[0];
            }
        });
        List<int[]>  list = new ArrayList<>();

        list.add(intervals[0]);
        int i=1;
        int j=0;
        while(i<intervals.length){
            if(list.get(j)[1]<intervals[i][0]){
                list.add(intervals[i]);
                j++;
            }else{
                list.set(j, new int[]{list.get(j)[0], Math.max(list.get(j)[1], intervals[i][1])});
            }
            i++;
        }

        return  list.toArray(new int[list.size()][2]);
    }
    //第二次写法
    public int[][] merge2(int[][] intervals) {
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
