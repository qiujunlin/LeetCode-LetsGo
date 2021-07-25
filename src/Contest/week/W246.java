package Contest.week;

public class W246 {
  public static void main(String[] args) {
  }
  public String largestOddNumber(String num) {
     int len = num.length();
     String res ="";
     for(int j=len-1;j>=0;j--){
         char a =  num.charAt(j);
         if(a%2==1){
           return  num.substring(0,j+1);
         }
       }
     return  res;
  }
  public int numberOfRounds(String startTime, String finishTime) {
    String s1[] = startTime.split(":");
    String s2[] = finishTime.split(":");
    int h1 = Integer.valueOf(s1[0]);
    int h2 = Integer.valueOf(s2[0]);
    int min1= Integer.valueOf(s1[1]);
    int min2= Integer.valueOf(s2[1]);
    int res =0;
    if(h1<=h2) {
      if (h1 < h2) {
        res+=(h2-h1-1)*4;
        res+=(min2)/15;
        res+=(60-min1)/15;
      }else {
        if (min1 > min2) {
          res += 23 * 4;
          res += (min2) / 15;
          res += (60 - min1) / 15;
        } else {
          if (min1 > 0 && min1 < 15) {
            min1 = 15;
          } else if (min2 > 15 && min1 < 30) {
            min1 = 30;
          } else if (min1 > 30 && min1 < 45) {
            min1 = 45;
          } else if (min1 > 45 && min1 < 60) {
            min1 = min2;
          }
          res += (min2 - min1) / 15;
        }
      }
    }else{
      res +=  (24-h1-1)*4;
      res+=(60-min1)/15;
    //  System.out.println(res);
      res+=(h2)*4;
      res+=(min2)/15;
    }
    return  res;
  }

  int res = 0;
  int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
  boolean is =  false;
  public int countSubIslands(int[][] grid1, int[][] grid2) {
  int  m = grid1.length;
  int n  =grid1[0].length;
  boolean vis[][] = new boolean[m][n];
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if(!vis[i][j]&&grid2[i][j]==1){
        dfs(vis,grid2,i,j,grid1);
         if(!is){
          res++;
         }
        is = false;
      }
    }
  }
        return  res;
}
  private void dfs(boolean[][] vis,int grids[][],int i, int j,int[][] grid1) {
    if(grid1[i][j]==0) is=false;
    int newx  = 0;
    int newy =0;
    vis[i][j] = true;
    for(int t=0;t<4;t++){
      newx = i+dir[t][0];
      newy = j+dir[t][1];
      if(newx>=0&&newy>=0&&newx<grids.length&&newy<grids[0].length){
        if(grids[newx][newy]==1&&!vis[newx][newy])
          dfs(vis,grids,newx,newy,grid1);
      }
    }

  }



}





