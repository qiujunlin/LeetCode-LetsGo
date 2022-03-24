package Contest.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DW74 {
    public static void main(String[] args) {
        System.out.println("Das");
    }
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer>  map =new HashMap<>();
        for(int a :nums) map.put(a,map.getOrDefault(a,0)+1);
        for(int a :map.values()){
            if(a%2!=0) return  false;
        }
        return  true;
    }
    public long maximumSubsequenceCount(String text, String pattern) {
      //  long res =0;
        char c1 = pattern.charAt(0);
        char c2 = pattern.charAt(1);
        long dp2[] =new long[text.length()];
        long count =0;
        dp2[text.length()-1] = text.charAt(text.length()-1)==c2?1:0;
      //  System.out.println(dp2[text.length()-1]);
        for (int i = text.length()-2; i >=0 ; i--) {
                 if(text.charAt(i)==c2) dp2[i] =dp2[i+1] +1;
                 else dp2[i] =dp2[i+1];

        }

        long res  =1;
        for (int i = 0; i < text.length(); i++) {
             if(text.charAt(i)==c1) res +=dp2[i+1];
        }
        long max  =res;
        max = Math.max(max,dp2[0]+max);
        max = Math.max(max,count+max);
        System.out.println(max);
        if(c1==c2) max =Math.max(max,(count+1)*(count)/2);
        return  max;




    }
    public int halveArray(int[] nums) {
        PriorityQueue<Double> q= new PriorityQueue<>((a,b)->b.compareTo(a));
        for(int a  : nums) q.offer(Double.valueOf(a));
        double sum =0;
        for(int a :nums)sum+=a;
        double max =sum;
        int res  =0;
        while (true){
            double a  =q.poll();
            max  -= a/2;
            res++;
            q.offer(a/2);
            if(max<=sum/2) return  res;

        }
      //  return   res;
//
    }
    public long numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        long dp[][] =  new long[len1+1][len2+1];
        //   dp[0][0] =1;
        //  dp[i][j] = dp[i-1][j-1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0]=1;
        }
        for(int i =0;i<len1;i++){
            for(int j =0;j<len2;j++){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                }else{
                    dp[i+1][j+1] =dp[i][j+1];
                }
            }
        }
        return dp[len1][len2];

    }
    int res = Integer.MAX_VALUE;
    int men[][];
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {

        int pre[] =new int[floor.length()+1];
        int count =0;
        for (int i = 0; i <floor.length() ; i++) {
            if(floor.charAt(i)=='1')
            pre[i+1] = pre[i] +1;
            else {pre[i+1] =pre[i];count++;}
        }

        this.men =new int[floor.length()][numCarpets];
        for (int i = 0; i < men.length; i++) {
            Arrays.fill(men[i],-1);
        }
        if(count==floor.length())return  0;
        if(carpetLen==1) return  Math.max(count-numCarpets,0);

      //  if(count)

     dfs(floor,pre, 0,carpetLen,numCarpets,pre[floor.length()]);
     return  res;
    }

    private int  dfs(String floor, int[] pre, int i, int carpetLen, int numCarpets,int count) {
        if(numCarpets==0||i>=floor.length()) {
            res =Math.min(count,res);return count<0?0:count;
        }
        System.out.println(count);
        int min =Integer.MAX_VALUE;
        if(  men[i][numCarpets] !=0) return   men[i][numCarpets];
        for (int j = i; j <floor.length() ; j++) {
            if(floor.charAt(i)=='1') {
              int c = pre[Math.min(floor.length() - 1, i + carpetLen - 1) + 1] - pre[i];
              int s =  dfs(floor, pre, i + carpetLen, carpetLen, numCarpets - 1, count - c);
              min =Math.min(min,s);
            }
        }
      return   men[i][numCarpets] =min;

/**
 *
 "100011111001110111111110001100011101111011111111111001001011"
 2
 3
 35

 "1000000000001000000100111100001101111000000001001111110000000000"
 6
 4
 3
 */
    }





}
