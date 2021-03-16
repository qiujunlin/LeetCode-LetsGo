package WeeklyContest;

import java.util.*;

/**
 * @Classname Week231
 * @Description:
 * @Date 2021/3/7 10:18
 * @Created by qiujunlin
 */
public class Week231 {

    public boolean checkOnesSegment(String s) {
      char ch[] = s.toCharArray();
      for(int i=0;i<s.length()-1;i++){
          if(ch[i]=='1'&&ch[i+1]=='1')return  true;
      }
      return  false;
    }
    public int minElements(int[] nums, int limit, int goal) {
        int sum=0;
        for(int a : nums) sum+=a;
        int count=0;
        if(sum==goal) return  count;
        if(sum!=goal){
            int cha = Math.abs(sum-goal);
            cha=cha-limit;
            count++;
            if(cha<=0) return  count;
        }
        return  count;
    }
    public int countRestrictedPaths(int n, int[][] edges) {
     int  tu[][]= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tu[i][j]=500000;
            }
        }
     for (int a[] : edges){
         int x =a[0];
         int y =a[1];
         tu[x-1][y-1]=a[2];
     }

     int shortPath[] = dijsktra(tu,n-1);

        System.out.println(0);
      return  0;
    }
    public  int[] dijsktra(int[][] weight,int start){
        //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
        //返回一个int[] 数组，表示从start到它的最短路径长度
        int n = weight.length;        //顶点个数
        int[] shortPath = new int[n];    //存放从start到其他各点的最短路径
        int[] visited = new int[n];        //标记当前该顶点的最短路径是否已经求出,1表示已求出

        //初始化，第一个顶点求出
        shortPath[start] = 0;
        visited[start] = 1;

        for(int count = 1;count <= n - 1;count++)        //要加入n-1个顶点
        {
            int k = -1;    //选出一个距离初始顶点start最近的未标记顶点
            int dmin = Integer.MAX_VALUE;
            for(int i = 0;i < n;i++)
            {
                if(visited[i] == 0 && weight[start][i] < dmin)
                {
                    dmin = weight[start][i];
                    k = i;
                }
            }

            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = dmin;
            visited[k] = 1;


            //以k为中间点想，修正从start到未访问各点的距离
            for(int i = 0;i < n;i++)
            {
                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i])
                    weight[start][i] = weight[start][k] + weight[k][i];
            }

        }

        return shortPath;
    }


    public static void main(String[] args) {
       int  edges[][] = {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};

        System.out.println(new Week231().countRestrictedPaths(5,edges));
    }
}
