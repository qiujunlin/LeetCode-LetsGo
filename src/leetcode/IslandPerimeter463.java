package leetcode;

public class IslandPerimeter463 {
    //第一遍
    public int islandPerimeter(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            int pre=0;
            int falg=0;
            int length=grid[i].length;
            for(int j=0;j<length;j++){
                if(grid[i][j]==1){
                    if(falg==0){
                        pre=j;
                        res=res+2;
                        falg=1;
                    }
                    if(j>pre+1)
                        res+=2;
                    pre=j;
                }
            }
        }
        for(int i=0;i<grid[0].length;i++){
            int pre=0;
            int falg=0;
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==1){
                    if(falg==0){
                        res=res+2;
                        falg=1;
                        pre=j;
                    }
                    if(j>pre+1)
                        res+=2;
                    pre=j;
                }
            }
        }
        return res;
    }

}
