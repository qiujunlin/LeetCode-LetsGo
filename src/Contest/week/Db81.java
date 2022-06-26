package Contest.week;

import java.util.Arrays;
import java.util.HashMap;

public class Db81 {
    public static void main(String[] args) {
        System.out.println(new Db81().distinctSequences(4));
    }
    public int countAsterisks(String s) {
         int res =0;
         int i =0;
         while (i<s.length()){
             char c = s.charAt(i);
             if(c=='|'){
                 int j =i+1;
                 while (j<s.length()&&s.charAt(j)!='|') j++;
                 if(j==s.length()) i= i+1;
                 else i =j;
             }
             if(c=='*') res++;
         }
         return  res;
    }
    public class Union {
        private  int parent[];
        int count  =0 ;
        public Union(int n ){
            this.count = n ;
            this.parent =  new int[n];
            for (int  i =0;i<n;i++) {
                this.parent[i] = i;
            }
        }
        public  void merge(int x,int y){
            int newx = find(x);
            int newy = find(y);
            if(newx==newy) return;
            else{
                parent[newx] = newy;
                count--;
            }
        }
        public int find(int x){
            return  x==parent[x]?(x):(parent[x] = find(parent[x]));
        }
        public boolean isconnected(int x,int y){
            return  find(x) ==find(y);
        }
    }
    // 4 2 1     8  +  2
    public long countPairs(int n, int[][] edges) {
        Union union = new Union(n);
        for(int a[] :  edges) {
            union.merge(a[0],a[1]);
        }
        HashMap<Integer,Integer>  m
                =new HashMap<>();
        for (int i = 0; i <n ; i++) {
           int a = union.find(i);
           m.put(a,m.getOrDefault(a,0)+1);
        }
        int siz =m.size();
        int a[] =new int[siz];
        long res =0;
        for(int c :m.values()){
            long b =c;
             res += b*(n-c);
        }
        return  res;



    }
    public int maximumXOR(int[] nums) {
        int res =0;
        for (int i = 0; i <31 ; i++) {
             int c =0;
            for (int j = 0; j <nums.length ; j++) {
                if(((nums[j]>>i)&1)==1) c++;
            }
            if(c!=0) {
                res|= (1<<i);
            }
        }
        return  res;
 //   1:6  2:4  3:5 4:3 5:6 6:2
    }
    public int distinctSequences(int n) {
        long dp[][] = new long[n+1][7];
        //Arrays.fill(dp[1],1);
        for (int i = 1; i <=6 ; i++) {
            for (int j = 1; j <=6 ; j++) {
                if(GCD(i,j)==1&&i!=j)
                dp[i][j] =1;
            }
        }
        int mod =1000000007;
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=6 ; j++) {
                for (int k = 1; k <=6 ; k++) {
                        for (int l = 1; l <=6 ; l++) {
                            if(GCD(k,l)==1&&k!=l&&j!=l){


                        }
                    }
                }
            }

        }
        long res =0;
        for (int i = 1; i <=6 ; i++) {
            res =(res+dp[n][i])%mod;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=6 ; j++) {
                System.out.print(dp[i][j]+"    ");
            }
            System.out.println();
        }
        return (int) res;


    }
    public int GCD(int x,int y){
        int a = Math.min(x,y);
        int b = Math.max(x,y);
        while (b%a!=0){
            int c = b%a;
            b = a;
            a = c;
        }
        return  a;
    }
}
