package Contest.week;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class WeekMicrosoft {
    public static void main(String[] args) {

    }
    public int leastMinutes(int n) {
       int kuan = 1;
       int time =0;
       if(n<=3) return n;
       while (kuan<n/2){
           kuan  = kuan*2;
           time++;
       }
          kuan +=2;
       return  kuan;
    }
    public int halfQuestions(int[] questions) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int a:questions){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        PriorityQueue<Integer>  queue = new PriorityQueue<>((a,b)->b-a);
        for(int key:map.keySet()){
            queue.offer(map.get(key));
        }
        int sum =0;
        int res =0;
        while (sum<questions.length/2){
            sum +=queue.poll();
            res++;
        }
        return res;
    }
    int max = 0;
    int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    int count  =0;
    boolean is =  false;
    public int largestArea(String[] grid){
        int  m = grid.length;
        int n  =grid[0].length();
        boolean vis[][] = new boolean[m][n];
        boolean near[][] = new boolean[m][n];
        int grids[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
              grids[i][j] = grid[i].charAt(j)-'0';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if(!vis[i][j]){
                   dfs(vis,grids,i,j,grids[i][j]);
                   if(is){
                       max= Math.max(max,count);
                   }
               }
            }
        }
        return  max;
    }

    private void dfs(boolean[][] vis,int grids[][],int i, int j,int key) {
         if(!vis[i][j]&&grids[i][j]==key){
             int newx  =  0;
             int newy =0;
             count++;
             for(int t=0;t<4;t++){
                 newx = i+dir[t][0];
                 newx = j+dir[t][1];
                 if(newx>=0&&newy>=0&&newx<grids.length&&newy<grids[0].length){
                     if(grids[newx][newy]==key){
                         is =true;
                     }else{
                         dfs(vis,grids,newx,newy,key);
                     }
                 }else{
                      is = true;
                 }
             }
         }
    }
}
