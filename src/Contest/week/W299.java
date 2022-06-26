package Contest.week;

public class W299 {
    public static void main(String[] args) {
        System.out.println("Dasfsd");
    }
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
         boolean vis[][] = new boolean[n][n];

        for (int k = 0; k <n ; k++) {
            if(grid[k][k]==0) return  false;
            vis[k][k]=true;
        }
        for (int i = 0, j = n-1; i <n; i++,j--) {
            if(grid[i][j] ==0) return  false;

            vis[i][j] =true;
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(vis[i][j]) continue;
                if(grid[i][j]!=0)return  false;
            }
        }
        return  true;


    }
    public int countHousePlacements(int n) {
        int dp[][][]= new int[n][2][2];
        dp[0][1][0] = 1; // l t
        dp[0][1][1] =1;
        dp[0][0][0] =1;
        dp[0][0][1] =1;
        int mod =1000000007;
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <2 ; j++) {
                for (int k = 0; k <2 ; k++) {
                    dp[i][0][0] =(dp[i][0][0] + dp[i-1][i][j])%mod;
                }
            }
            dp[i][1][0] = (dp[i][1][0]+dp[i-1][0][1])%mod;
            dp[i][1][0] = (dp[i][1][0]+dp[i][0][0])%mod;

            dp[i][0][1] = (dp[i][0][1]+dp[i][0][0])%mod;
            dp[i][0][1] = (dp[i][0][1]+dp[i][1][0])%mod;

            dp[i][1][1] = (dp[i][1][1]+dp[i][0][0])%mod;
        }
        int res =0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <2 ; j++) {
                res= (res +dp[n][i][j])%mod;
            }
        }
        return  res;
    }
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
          int sum1 = 0;
          int sum2 = 0;
          for(int a :nums1) sum1+=a;
          for(int a :nums2) sum2+=a;
          int dp[] =new int[nums1.length];
          int dp2[] =new int[nums1.length];
        for (int i = 0; i <nums1.length ; i++) {
            dp[i] =nums1[i]-nums2[i];
            dp2[i] =nums2[i]-nums1[i];
        }
        int max1  = getMax(dp);
        int max2 = getMax(dp2);
        int res1 = Math.max( sum2 + max1,sum1-max1);
        int res2 =Math.max(sum1+max2,sum2-max2);
        return  Math.max(res1,res2);
    }

    private int getMax(int[] dp) {
        int sum  =0;
        int max  =0;
        for (int i = 0; i <dp.length ; i++) {
            sum =Math.max(sum+dp[i],dp[i]);
            max  =Math.max(max,sum);
        }
        return  max;

    }

}
