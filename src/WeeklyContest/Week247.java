package WeeklyContest;

import java.util.Arrays;

public class Week247 {
    public static void main(String[] args) {
          int a[][] =  {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
          int b[][] = {{10,1,4,8},{6,6,3,10},{7,4,7,10},{1,10,6,1},{2,1,1,10},{3,8,9,2},{7,1,10,10},{7,1,4,9},{2,2,4,2},{10,7,5,10}};

          new Week247().rotateGrid(b,1);
    }

    int m ;
    int n ;
    public int[][] rotateGrid(int[][] grid, int k) {
            m  = grid.length;
            n = grid[0].length;
           int res[][] = new int[m][n];
           int min = Math.min(m,n);
           int count  = 0;
        for (int i = 0; i < min/2; i++) {
            int a  = (m-i*2)*2+(n-2-i*2)*2;
            int arr[] = new int[a];
            get(grid,i,arr);
            int b = k%a;
            int arr1[] = new int[a];
            int index =  0;
            for(int j = k;j<b;j++){
                arr1[index]=arr[j];
                index++;
            }
            for (int j = 0; j < k; j++) {
                arr1[index] = arr[j];
                index++;
            }
            back(res,i,arr1);
        }
        return  res;
    }

    private void back(int[][] grid, int count, int[] arr) {
        int index =0;
        for(int j=count;j<n-count;j++){
            grid[count][j]= arr[index] ;
            index++;
        }
        for(int j=count+1;j<m-count-1;j++){
            grid[j][m-count-1]= arr[index]  ;
            index++;
        }
        //j=2
        for(int j=n-count-1;j>=count;j--){
            grid[m-count-1][j]= arr[index]  ;
            index++;
        }
        for(int j=m-count-2;j>count;j--){
            grid[j][count]=arr[index]  ;
            index++;
        }
    }

    // n - count m -count
    private void get(int[][] grid, int count, int[] arr) {
        int index =0;
        for(int j=count;j<n-count;j++){
            arr[index] = grid[count][j];
            index++;
        }
        //j=1 m-
        for(int j=count+1;j<m-count-1;j++){
            arr[index] = grid[j][n-count-1];
            index++;
        }
        for(int j=n-count-1;j>=count;j--){
            arr[index] = grid[m-count-1][j];
            index++;
        }
        for(int j=m-count-2;j>count;j--){
            arr[index] = grid[j][count];
            index++;
        }
    }


}
