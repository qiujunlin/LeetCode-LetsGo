package Array;
import   java.util.*;
public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean row[] = new boolean[n];
        boolean col[] = new boolean[n];
        char que[][] = new char[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) que[i][j]='.';
        dfs(res,row,col,0,0,n,que);
        return  res;
    }

    private void dfs(List<List<String>> res, boolean[] row, boolean[] col, int r, int c,int n,char que[][]) {
        if(c==n){
            c=0;
            r++;
        }
        if(r==n&&c==0){
            addres(que,res,n);
        }

        for(int k=0;k<=1;k++) {
            if(k==0) {
                dfs(res,row,col,r,c+1,n,que);
            }
            if (row[r]) {
                return;
            }
            if(col[c]) return;
            // 检查 45度角是否有皇后
            for (int i = r - 1, j = c - 1; i >=0 && j >= 0; i--, j--) {
                if (que[i][j] == 'Q') {
                    return ;
                }
            }
            // 检查 135度角是否有皇后
            for(int i = r - 1, j = c +  1; i >= 0 && j < n; i--, j++) {
                if (que[i][j] == 'Q') {
                    return ;
                }
            }
            row[r] =true;
            col[c] =true;
            dfs(res,row,col,r,c+1,n,que);
            row[r] =false;
            col[c] =false;
        }
    }

    private void addres(char[][] que, List<List<String>> res,int n) {
        List<String> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            String a = "";
            for(int j=0;j<n;j++){
                a+=que[i][j];
            }
            l.add(a);
        }
        res.add(l);
    }
}
