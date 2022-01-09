package Contest.week;

import Test.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class DW69 {


    public String capitalizeTitle(String title) {
        String s[]=  title.split(" ");
        StringBuilder  res = new StringBuilder();
        for(int j=0;j<s.length;j++){
            String ss =  s[j];
            if(ss.length()>2){
                char ch[] = ss.toCharArray();
                for (int i = 0; i <ch.length ; i++) {
                    ch[i] = Character.toLowerCase(ch[i]);
                }
                ch[0] = Character.toUpperCase(ch[0]);
                res.append(new String(ch));
            }else{
                char ch[] = ss.toCharArray();
                for (int i = 0; i <ch.length ; i++) {
                    ch[i] = Character.toLowerCase(ch[i]);
                }
                res.append(new String(ch));
            }
            if(j!=s.length-1)res.append(" ");
        }
        return  res.toString();

    }
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public int pairSum(ListNode head) {
        ArrayList<Integer> l = new ArrayList<>();
        while (head!=null){
            l.add(head.val);

        }
        int max  =0;
        int len = l.size();
        for (int i = 0; i <(len/2)-1 ; i++) {

            max  = Math.max(max,l.get(i)+l.get(len-i-i));
        }
        return  max;


    }

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int  m  = grid.length;
        int  n = grid[0].length;
        int dis[][][] = new int[m][n][4];

        for (int i = 0; i <m ; i++) {
            // 距离左边
            dis[i][0][0] = grid[i][0]==0?1:0;
            for (int j = 1; j < n; j++) {
                if(grid[i][j]==1){
                    dis[i][j][0]=0;
                }else{
                    dis[i][j][0] = dis[i][j-1][0] +1;
                }
            }
            // 右边
            dis[i][n-1][0] = grid[i][n-1]==0?1:0;
            for (int j = n-2; j >=0; j--) {
                if(grid[i][j]==1){
                    dis[i][j][1]=0;
                }else{
                    dis[i][j][1] = dis[i][j+1][0] +1;
                }
            }

        }
        // 列
        for (int i = 0; i < n ; i++) {
            // 上边
            dis[0][i][2] = grid[0][i]==0?1:0;
            for (int j = 1; j < m; j++) {
                if(grid[j][i]==1){
                    dis[j][i][2]=0;
                }else{
                    dis[j][i][2] = dis[j-1][i][2] +1;
                }
            }
            dis[m-1][i][3] = grid[m-1][i]==0?1:0;
            for (int j = m-2; j >=0; j--) {
                if(grid[j][i]==1){
                    dis[j][i][3]=0;
                }else{
                    dis[j][i][3] = dis[j+1][i][3] +1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                if(grid[i][j]==1) continue;
                else{
                    System.out.println(dis[i][j][0] +" " +dis[i][j][1] +" "+dis[i][j][2]+" "+dis[i][j][3]);
                    //if(max<stampHeight) return  false;
                }
            }
        }

        return  true;

    }


    public static void main(String[] args) {
        int arr[][] ={{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0}};
        new DW69().possibleToStamp(arr,4,3);
    }


}
