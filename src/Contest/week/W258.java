package Contest.week;

import java.math.BigDecimal;
import java.util.HashMap;

public class W258 {
    public static void main(String[] args) {

    }
    public String reversePrefix(String word, char ch) {
   int  index =  word.indexOf(ch);
   if(index==-1) return  word;
    String a =  word.substring(0,index+1);
     String c =  new StringBuffer(a).reverse().toString();
     return  c+word.substring(index+1,word.length());

    }
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double,Integer>  map =  new HashMap<>();

        for(int a[] : rectangles){
            map.put((double) (a[0]/a[1]),map.getOrDefault((double)a[0]/a[1],0)+1);
        }
        int res =0 ;
        for(double key: map.keySet()){
            int count = map.get(key);
            res+=(count*(count-1))/2;
        }
        return  res;
    }
    public int maxProduct(String s) {
           int len =  s.length();
           int a = 0;
           int res =0;
           for(int  i =0;i<(1<<12);i++){
               StringBuilder s1 = new StringBuilder();
               StringBuilder s2 = new StringBuilder();
               for (int k = 0; k <len; k++) {
                   if((i&1)==1){
                       s1.append(s.charAt(len-k-1));

                   }else{
                       s2.append(s.charAt(len-k-1));
                   }
                   i=i>>1;
               }
               res= Math.max(get(s1.toString())*get(s2.toString()),res);
           }

        return  res;
    }

    public int get(String s) {
        System.out.println("");
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=n; i>0; i--){
            for(int j=i; j<=n; j++){
                if(i==j){
                    dp[i][j] = 1;
                }else if(s.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[1][n];
    }




}
