package Contest.LCCUP;

public class LCCUP22 {
    public static void main(String[] args) {
        System.out.println("gds");
    }
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int res =0;
        for(int a[] : fruits){
            int t = time[a[0]];
            if(a[1]%limit==0) res+=a[1]/limit * t;
            else res+= (a[1]/limit+1)*t;
        }
        return  res;
    }
    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
         int l =0;
         this.m = matrix.length;
         this.n  =matrix[0].length();
         this.ch =  new char[m][n];
         startx =start[0];
         starty =start[1];
         endx =start[0];
         endy =start[1];
        for (int i = 0; i <ch.length ; i++) {
            ch[i] = matrix[i].toCharArray();
        }
         int r = Math.abs(start[0]-end[0]) +Math.abs(start[1] -end[1]);
         while (l<r){
              int mid  =(l+r)/2;
             if(check(mid)){
                 r  = mid;
             }else{
                  l =mid+1;
             }

         }
         return  l;

    }
    int m  ;
    int n ;
    char ch[][];
    int endx;
    int endy;
    int startx;
    int starty;
    boolean vis[][];
    private boolean check(int mid) {
        vis = new boolean[m][n];
        vis[startx][starty] =true;
        boolean res =dfs(mid,startx,starty);
        return  res;
    }
    int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
    private boolean dfs(int mid, int i, int j) {
        if(mid<=0) return  false;
        char cur = ch[i][j];
        for(int k =0;k<4;k++){
            int a[] = dir[k];
            int newx =  a[0]+i;
            int newy =  a[1]+j;
            if(newx>=0&&newy>=0&&newx<m&&newy<n&&!vis[newx][newy]){
                char c = ch[newx][newy];
                vis[newx][newy] =true;
                if(newx==endx&&newy==endy){
                     return  true;
                }
                if(k==0&&cur=='^'||k==1&&cur=='v'||k==2&&cur=='<'||k==3&&cur=='>') {
                    if(dfs(mid,newx,newy)){
                        return  true;
                    }
                }else {
                    if(dfs(mid-1,newx,newy)) return true;
                }
                vis[newx][newy] =false;
            }
        }
        return  false;
    }
}
