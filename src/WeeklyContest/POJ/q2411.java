package WeeklyContest.POJ;

import java.util.Arrays;
import java.util.Scanner;

public class q2411 {
    static  long[][] dp= new long[13][2100];
    static  int  m =0;
    static  int  n =0;
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        while (scanner.hasNext()){
            m =scanner.nextInt();
            n =scanner.nextInt();
            if(m==0&&n==0) break;
            for(int i=0;i<dp.length;i++){
                Arrays.fill(dp[i],0);
            }
            dp[1][0]=1;
            for(int j =1;j<=n;j++){
                //遍历每一种情况
                for(int state=0;state<(1<<m);state++){
                    if(dp[j][state]>0)
                    dfs(0, j,state,0);
                }
            }
            System.out.println(dp[n+1][0]);
        }

    }
    /**
     * @param i  高度
     * @param j  列数
     * @param state  当前状态
     * @param nextstate  下一个状态
     */
    private static void dfs(int i, int j, int state, int nextstate) {
        if(i==m){//
            dp[j+1][nextstate] += dp[j][state];
            return;
        }
        //如果当前位置没有  尝试横着放
        if(((state>>i)&1)==0){
            dfs(i+1,j,state,nextstate|(1<<i))   ;
        }
        if(i+1<m&&((state>>i+1)&1)==0&&((state>>i)&1)==0){
            dfs(i+2,j,state,nextstate);
        }
        if(((state>>i)&1)==1){
            dfs(i+1,j,state,nextstate);
        }

    }
}
