package Contest.Lanqiao;

import java.util.Deque;
import java.util.LinkedList;

public class QG11B {
    public static void main(String[] args) {
        boolean grid[][] = new boolean[10000][10000];
        Deque<int[]> queue  = new LinkedList();
        int x1[] = new int[]{3000,3000};
        int x2[] = new int[]{3000+2020,3000+11};
        int x3[] = new int[]{3000+11,3000+14};
        int x4[] = new int[]{3000+2000,3000+2000};
        grid[x1[0]][x1[1]] =true;
        grid[x2[0]][x2[1]] =true;
        grid[x3[0]][x3[1]] =true;
        grid[x4[0]][x4[1]] =true;


        queue.offer(x1);
        queue.offer(x2);
        queue.offer(x3);
        queue.offer(x4);

        int  res =4;
        int count =2020;
        int direct[][]=  {{0,1},{0,-1},{1,0},{-1,0}};
        while (count>0){
            int size  = queue.size();
            while (size>0){
                int a[] = queue.poll();
                int x =  a[0];
                int y = a[1];
                for(int i=0;i<4;i++){
                    int newx  = x+direct[i][0];
                    int newy  = y + direct[i][1];
                    if(!grid[newx][newy]) {
                        res++;
                        grid[newx][newy] = true;
                        queue.offer(new int[]{newx, newy});
                    }
                }
                size--;
            }
            count--;
        }
        System.out.println(res);
    }

}
