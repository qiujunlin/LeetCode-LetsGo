package Array;

public class Q304 {
        int presunm[][];
        public Q304(int[][] matrix) {
         int m = matrix.length;
         int n = matrix[0].length;
         presunm =  new int[m+1][n+1];
         for(int i= 0;i<m;i++){
            for(int j =0;j<n;j++){
                presunm[i+1][j+1] = presunm[i][j+1]+presunm[i+1][j]-presunm[i][j] + matrix[i][j];
            }
         }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return presunm[row2+1][col2+1] - presunm[row1][col2+1] - presunm[row2+1][col1] + presunm[row1][col1];
        }
    }
