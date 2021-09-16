package leetcode;

public class KuaiShuMI {
    public static void main(String[] args) {


    }
    public static  int[][] matrix_pow(int a[][],int n){
        int res[][] = {{1,0},{0,1}};
        while (n>0) {
            if (n % 2 == 1) a = matrix_multiply(res, a);
            n = n >> 1;
            a = matrix_multiply(a, a);
        }
        return  res;
    }
    public static  int[][] matrix_multiply(int[][] a,int [][] b){
        int m = a.length;
        int n = a[0].length;
        int p =b[0].length;
        int res[][] = new int[m][p];
        for(int i=0;i<m;i++){
            for(int j=0;j<p;j++){
                for(int k=0;i<n;k++){
                    res[i][j] = a[i][k] * b[k][j];
                }
            }
        }
        return  res;
    }


}
