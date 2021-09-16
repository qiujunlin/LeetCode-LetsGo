package leetcode;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/7
 */
public class ScoreAfterFlippingMatrix861 {
    public int matrixScore(int[][] A) {
        for(int i=0;i<A.length;i++){
            if(A[i][0]==0){
                for(int j=0;j<A[i].length;j++){
                    A[i][j]=A[i][j]==0?1:0;
                }
            }
        }
        int res=0;
        for(int i=1;i<A[0].length;i++){
            int num0=0,num1=0;
            for(int j=0;j<A.length;j++){
                if(A[j][i]==1) num1++;
                else num0++;
            }
            if(num1<num0)  fun2(A,i);
        }
        for(int i=0;i<A.length;i++){
            int  row=0;
            for(int j=0;j< A[i].length;j++){
                row=(row<<1)+A[i][j];
            }
            System.out.println(row);
            res+=row;
        }
        return res;
    }
    void fun2(int[][] A,int col){
        for(int i=0;i<A.length;i++){
            A[i][col]=A[i][col]==0?1:0;
        }
    }

    public static void main(String[] args) {
        new ScoreAfterFlippingMatrix861().matrixScore(new int[][]{{1,0},{1,1}});
    }
}
