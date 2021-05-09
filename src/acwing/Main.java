package acwing;

import java.util.*;

/**
 * @Classname Main
 * @Description:
 * @Date 2021/5/5 1:57
 * @Created by qiujunlin
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int p = scanner.nextInt();
            long mart[][] = {{1, 1}, {1, 0}};
            long fm =1;
            long res=1;
            for(int i=2;i<=n;i++){
               long c = matrix_pow(mart, i - 1)[0][0];
               if(i==m) fm =c;
               res+=c;
            }

            System.out.println((res % fm)% p);
        }
    }
    public static  long[][] matrix_pow(long a[][],long n){
        long res[][] = {{1,0},{0,1}};
        while (n>0) {
            if (n % 2 == 1) res = matrix_multiply(res, a);
            n = n >> 1;
            a = matrix_multiply(a, a);
        }
        return  res;
    }
    public static  long[][] matrix_multiply(long[][] a,long [][] b){
        int m = a.length;
        int n = a[0].length;
        int p =b[0].length;
        long res[][] = new long[m][p];
        for(int i=0;i<m;i++){
            for(int j=0;j<p;j++){
                for(int k=0;k<n;k++){
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return  res;
    }
}
