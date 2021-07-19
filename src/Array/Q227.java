package Array;

import java.util.*;

/**
 * @Classname Q227
 * @Description:
 * @Date 2021/5/26 15:35
 * @Created by qiujunlin
 */
public class Q227 {
    public int calculate(String s) {
         char ch[] = s.toCharArray();
         int i =0;
         Stack<Integer> stack = new Stack<>();
         int pre=1;
         while (i<s.length()){
             if(ch[i]==' '){
                 i++;
             }else if(ch[i]=='+'){
                 pre=1;i++;
             }else if(ch[i]=='-'){
                 pre=2;i++;
             }else if(ch[i]=='*'){
                 pre=3;i++;
             }else if(ch[i]=='/'){
                 pre=4;i++;
             }else {
                 int num =0;
                 while (i<s.length()&&Character.isDigit(ch[i])){
                     num = num*10+ch[i]-'0';
                     i++;
                 }
                 if(pre==1) stack.push(num);
                 else  if(pre==2)stack.push(-num);
                 else if(pre==3) stack.push(stack.pop()*num);
                 else if(pre==4)stack.push(stack.pop()/num);
             }
         }
         int res= 0;
         for(int a:stack) res+=a;
         return  res;
    }
    public int countTriples(int n) {
        int count  =0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if(i*i+j*j==k*k)count++;
                }

            }
            
        }
        return  count;

    }
    int max = 0;
    int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        boolean vis[][] = new  boolean[maze.length][maze[0].length];
         vis[entrance[0]][entrance[1]]=true;
          dfs(vis,maze,entrance[0],entrance[1],1);
          return  max;

    }
    private void dfs(boolean[][] vis,char grids[][],int i, int j,int len) {
        if(i==0||j==0||i==grids.length-1||j==grids[0].length-1){
            if(len!=1) max= Math.min(len,max);
        }
            int newx = 0;

            int newy =0;
            for(int t=0;t<4;t++){
                newx = i+dir[t][0];
                newy = j+dir[t][1];
                if(newx>=0&&newy>=0&&newx<grids.length&&newy<grids[0].length&&!vis[newx][newy]&&grids[i][j]=='.'){
                       vis[newx][newy] = true;
                        dfs(vis,grids,newx,newy,len+1);
                     vis[newx][newy] = false;
                }

        }
    }

    public static void main(String[] args) {
         new Q227().calculate("3+2*2");
    }
}

