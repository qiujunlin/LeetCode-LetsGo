package Test;

/*
FE65CDBA
2147483647e
4268084666
 */
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) throws UnknownHostException {

    }
    int  getNum(int arrs[][]){
         int grid[][]  = new int[1001][1001];
         for(int a[] :  arrs) grid[a[0]][a[1]]++;
         int sum1[][] = new  int[2003][2003];
         int sum2[][] = new  int[2003][2003];
         for (int i = 1; i <= 1000; ++i) {
            for (int j = 1; j <= 1000; ++j) {
                sum1[i][j] = sum1[i - 1][j - 1] + grid[i - 1][j - 1];
                sum2[i][j] = sum2[i - 1][j + 1] + grid[i - 1][j - 1];
            }
        }
        int res =0;
        for (int i = 1; i <=1000 ; i++) {
            int a = sum1[1000][i]+sum1[i][1000]+sum2[i][1]+sum2[1000][i];
            res+=(a*(a-1))/2;
        }
        return  res;


    }
    int[] getMax(String s) {
        char ch[] = s.toCharArray();
        int pre[] = new int[s.length() + 1];
        int res[] = new int[s.length()];
        Arrays.fill(res, 1);
        for (int i = 0; i < ch.length; i++) {
            pre[i + 1] = pre[i] + ch[i] - '0';
            if (pre[i + 1] % 2 == 0 && i % 2 == 0) {
                List<Integer> list = get(i);
                for (int k = list.size() - 1; k >= 0; k--) {
                    if (check(i ,k,pre)) {
                        res[i] = k;
                        break;
                    }
                }
            }
        }
        return  res;
    }

     List<Integer> get(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;i <= Math.sqrt(n);i++) {
            if(n%i == 0)
                list.add(i);
        }
        return  list;
    }

    private boolean check(int i,int temp,int sum[]) {
        int one = sum[temp]-sum[1];;
        for (int j = 0; j <=i ; j+=temp) {
           if(sum[j+temp]-sum[j+1]!=one) return  false;
        }
        return  true;
    }


    void init(){
        int gride2[][] = {{1,1},{1,1}};
        int gride[][] = {{1,1,1,1,0},{0,1,0,1,0},{1,1,2,1,1},{0,2,0,0,1}};
        int men[][] = new int[gride.length][gride[0].length];
        for (int i = 0; i <men.length ; i++) {
            Arrays.fill(men[i],Integer.MAX_VALUE);
        }
        boolean vis[][] = new boolean[gride.length][gride[0].length];
        vis[0][0] = true;
        System.out.println(dfs(gride,men,0,0,vis));
    }
    int direct[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    int dfs(int gride[][],int men[][] ,int i  ,int j ,boolean vis[][] ){
        if(i==gride.length-1&&j==gride[0].length-1){
            if(gride[i][j]==1) return  1;
            if(gride[i][j]==0) return  2;
            if(gride[i][j]==2) return  -1;
        }
        if(men[i][j]!=Integer.MAX_VALUE) return men[i][j];
        int val =0;
        if(gride[i][j]==2) return -1;
        else if(gride[i][j]==1) val = 1;
        else  val = 2;
        int min  =Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
             int x = i+direct[k][0];
             int y  =j+direct[k][1];
             if(x>=0&&y>=0&&x<gride.length&&y<gride[0].length&&!vis[x][y]){
                 vis[x][y] = true;
                 int res = dfs(gride,men,x,y,vis);
                 if(res!=-1) {
                     min=Math.min(res+val,min);
                 }
                 vis[x][y] = false;
             }
        }
       return men[i][j]=min==Integer.MAX_VALUE?-1:min;
    }



}
