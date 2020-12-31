## 区间问题

### 56 合并区间

这道题的思路其实就是排序，然后遍历，挨着挨着遍历

```java
 public int[][] merge(int[][] intervals) {
       List<int[]> list = new ArrayList();
       Arrays.sort(intervals,(a,b)->a[0]-b[0]);
       int []a=intervals[0];
       for(int i=0;i<intervals.length;){
           while(i<intervals.length&&intervals[i][0]<=a[1]){
              a[1]=Math.max(intervals[i][1],a[1]);
              i++;
           }
           list.add(a);
           if(i==intervals.length) break;
           a=intervals[i];
       }
       return list.toArray(new int[list.size()][2]);
    }
```



### 57 插入区间

![](images/57.png)

解题思路：本文的解题方法按照三个步骤

区间加入一共有三种情况，第一种，在interviewing区间的 左边

第二招 和newInterval区间有重叠，重叠的情况包括 右边界等于newInterval左边界， 左边界等于newInterval右边界的情况

第三种情况为区间都在newInterval区间的右边

根据这三种情况，需要进行三次运算，其中第二次运算的逻辑比较重要。直接将newInterval数组改变，可以避免很多的问题。

[题解](https://leetcode-cn.com/problems/insert-interval/solution/bi-xu-miao-dong-li-kou-qu-jian-ti-mu-zhong-die-qu-/)

```java 
 public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int index=0;
        while(index<intervals.length&&intervals[index][1]<newInterval[0]){
            list.add(intervals[index]);
            index++;
        }
        while(index<intervals.length&&intervals[index][0]<=newInterval[1]){
            newInterval[1]=Math.max(intervals[index][1],newInterval[1]);
            newInterval[0]=Math.min(intervals[index][0],newInterval[0]); 
            index++;
        }
        list.add(newInterval);
        while(index<intervals.length){
            list.add(intervals[index]);
            index++;
    
        }
        return list.toArray(new int[list.size()][2]);
    }
```

