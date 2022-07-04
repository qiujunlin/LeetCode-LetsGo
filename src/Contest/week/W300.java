package Contest.week;

import java.util.HashMap;

public class W300 {

    public String decodeMessage(String key, String message) {
        HashMap<Character,Character> map=new HashMap<>();
        char  index='a';
        for (int i = 0; i <key.length() ; i++) {
             char c= key.charAt(i);
             if(Character.isLetter(c)&&!map.containsKey(c)) {
                 map.put(c,index);index++;
             }
        }
        char ch[] = message.toCharArray();
        for (int i = 0; i <ch.length ; i++) {
            if(Character.isLetter(ch[i])){
                ch[i] = map.get(ch[i]);
            }
        }
        return  new String(ch);

    }
    public class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        boolean vis[][] =new boolean[m][n];
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int x  =0;int y =0;int i =0;
        int res[][] = new int[m][n];
        int c =0;
        while(head!=null||c!=m*n){
            if(head!=null)
            res[x][y]= head.val;
            else res[x][y]=-1;
            vis[x][y]=true;
            int newx = x+dir[i][0];
            int newy =y+dir[i][1];
            if(newx<0||newy<0||newx>=m||newy>=n||vis[newx][newy]){
                i = (i+1)%4;
            }
            x = x+dir[i][0];
            y =y+dir[i][1];
            c++;
        }
        return res;


    }

    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
          long dp[] =new long[n*2];//chafen
          long dpc[] =new long[n*2];//jian
          int mod = 1000000007;
          dp[1] +=1;
          dp[forget+1+1] -=1;
        long sum[] =new long[dp.length];//yigong
        for (int i = 2; i <=n; i++) {
            // 当前需要分享的有多少人
            // 当前减少的有多少人
            // 当前有多少人
            int num = (int)dp[i];
            dp[num+delay+1] =(dp[num+delay+1] +1)%mod;
            dp[num+forget+1] =(dp[num+forget+1] -num)%mod;
            sum[i] =(sum[i-1] +dp[i]);

        }
        for (int i = 0; i <=n; i++) {
            System.out.print(sum[i] + " ");
        }
        return  (int)sum[n];
    }
    public static void main(String[] args) {
        System.out.println("fdsfadnvdkajf");
        new W300().peopleAwareOfSecret(6,2,4);
    }
    int m ;int n;
    public int countPaths(int[][] grid) {
        int res  =0;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int men[][] =new int[grid.length][grid[0].length];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                 vis[i][j]=true;
                 res = (dfs(grid,men,i,j,vis) +res)%mod;
                 vis[i][j]=false;
            }
        }
        return  res;
    }
    int dir[][] ={{0,1},{0,-1},{-1,0},{1,0}};
    int mod =1000000007;
    int  dfs(int grid[][],int men[][],int i,int j,boolean vis[][]){
          if(men[i][j]!=-1) return men[i][j];
          int res =1;
          for(int a[] :dir){
              int x = i+a[0];
              int y = i+a[1];
              if(x>=0&&x<m&&y<0&&y>=n&&!vis[x][y]&&grid[x][y]>grid[i][j]) {
                  vis[x][y]=true;
                  res = (res + dfs(grid, men, x, y, vis))%mod;
                  vis[x][y]=false;
              }
          }
       return    men[i][j]=res;
    }
}
