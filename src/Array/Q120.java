package Array;
import  java.util.*;
public class Q120 {
    public int minimumTotal(List<List<Integer>> triangle) {
       int lne = triangle.size();
       int dp[] =new int[lne];
       dp[0] = triangle.get(0).get(0);
       for(int i=1;i<lne;i++){
           int len =i+1;
           dp[0] =  dp[0]+triangle.get(i).get(0);
           for(int j=i;j>0;j--){
               dp[j]=triangle.get(i).get(j)+Math.min(dp[j-1],dp[j]);
           }
       }
       int min =Integer.MAX_VALUE;
       for(int i=0;i<lne;i++){
           min =Math.min(dp[i],min);

       }
       return  min;
    }
}
