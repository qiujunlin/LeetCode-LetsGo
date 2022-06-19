package Contest.week;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.HashSet;

public class W298 {
    public static void main(String[] args) {
       // System.out.println("gfsg");
       // System.out.println("001010101011010100010101101010010".length());
       //System.out.println(Integer.parseInt("001010101011010100010101101010010",2));
        System.out.println((long)Math.pow(2,100));
    }
    public String greatestLetter(String s) {
        HashSet<Character>  set = new HashSet<>();
        for(char c:s.toCharArray()) set.add(c);
        char max  = '*';
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(c>='a'&&c<='z') {
                if(set.contains(Character.toUpperCase(c))){
                    if(max=='*'||max<Character.toUpperCase(c)){
                        max =Character.toUpperCase(c);
                    }
                }
            }else {
                if(set.contains(Character.toLowerCase(c))){
                    if(max=='*'||max<c){
                        max=c;
                    }
                }
            }
        }
        return  max=='*'? "":String.valueOf(max);

    }
    public int minimumNumbers(int num, int k) {

        for (int i = 1; i <=num; i++) {
            int c = i*k;
            if(c>num) return  -1;
            if((num-c)%10==0) return   i;
        }
        return   -1;
    }
//    public long sellingWood(int m, int n, int[][] prices) {
//
//    }
    public int longestSubsequence(String s, int k) {
        String tar = Integer.toBinaryString(k);


        int r = s.length();
        int l  = 0;

        while (l<r){
            int mid  =(l+r+1)/2;
            if(check(s,k,mid)){
                l =mid;
            }else{
                r =mid-1;
            }
        }
        return  l;


    }

    /**
     * "001010101011010100010101101010010"
     * 93951055
     * 31
     * "111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101"
     * 11713332
     * 96
     * @param s
     * @param k
     * @param mid
     * @return
     */
    private boolean check(String s, int k, int mid) {
        //if()
        long dp[][] = new long[s.length()+1][mid+1];
        for (int i = 0; i <s.length() ; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i <s.length() ; i++) {
            dp[i][0] =  0;
            for (int j = 1; j <=mid; j++) {
                if(s.charAt(i)=='0')
                    dp[i+1][j] =Math.min(dp[i][j],dp[i][j-1]);
                else  {
                    long  nu = (long)Math.pow(2,mid-j);
                     if(nu>Integer.MAX_VALUE) {
                         dp[i+1][j] =dp[i][j];
                         continue;
                     }
                    dp[i+1][j] =Math.min(dp[i][j],dp[i][j-1]+nu);
                }

            }
        }
        return  dp[s.length()][mid]<=k;
    }
    public int longestSubsequence2(String s, int k) {
        int c =0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0')c++;
        }
        int sum  =0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)=='1') {
                long n = (long) Math.pow(2, s.length() - i - 1);
                if (sum + n <= k) {
                    sum += n;
                    c += 1;
                } else {
                    return c;
                }
            }
        }
        return  c;
    }
}
