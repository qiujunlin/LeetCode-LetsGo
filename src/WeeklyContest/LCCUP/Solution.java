package WeeklyContest.LCCUP;

import  java.util.*;
public class Solution {
int mod=1000000007;
     public int purchasePlans(int[] nums, int target) {
        long res=0;
        Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                if(nums[i]>target) break;
                for(int j=nums.length-1;j>i;j--){
                    long x  =  (nums[i]+nums[j]);
                    if(x<=target){
                        res=(res+(j-i))%mod;
                        break;
                    }
                }
            }
            return  (int)res%mod;

    }
    public int orchestraLayout(int num, int xPos, int yPos) {
        int direction[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int orient =0;
        int n = num;
        int x =0;
        int y =0;
        int count=0;
        boolean vis[][] = new boolean[n][n];
        int number =1;
        while (count!=num*num){
            if(x==xPos&&y==yPos) return  number;
            number++;
            if(number==10) number=1;
            vis[x][y] = true;
            int newx =x+direction[orient][0];
            int newy =y+direction[orient][1];
            if(newx>=n||newy>=n||newx<0||newy<0||vis[newx][newy]) {
                orient = (orient + 1) % 4;
            }
            x = x+direction[orient][0];
            y = y+direction[orient][1];

        }
        return  0;

    }
    public int orchestraLayout2(int num, int xPos, int yPos) {



    }
        public List<Integer> spiralOrder(int[][] matrix) {
            //for(int i=0;i<m/2)
            List<Integer> list = new ArrayList<>();
            int count=0;
            int m=matrix.length;
            int n=matrix[0].length;
            while(list.size()!=m*n){
                int i=count;
                int j=count;
                for(j=count;j<=n-count-1;j++){
                    list.add(matrix[i][j]);
                }
                j--;
                if(list.size()==m*n) break;
                for(i=count+1;i< m-count-1;i++){
                    list.add(matrix[i][j]);
                }
                if(list.size()==m*n) break;
                for(j=n-count-1;j>= count;j--){
                    list.add(matrix[i][j]);
                }
                j++;
                if(list.size()==m*n) break;
                for(i=m-count-2;i>count;i--){
                    list.add(matrix[i][j]);
                }
                count++;
            }
            System.out.print(list);
            return list;
        }

}
