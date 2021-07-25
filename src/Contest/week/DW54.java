package Contest.week;

public class DW54 {
    public static void main(String[] args) {

    }
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean b[] = new boolean[right];
        for(int a[]:ranges){
            int l  = a[0];
            int r =a[1];
            for(int i=l;i<=r&&i<=right;i++){
                b[i] =true;
            }
        }
        for(int i=left;i<=right;i++){
            if(b[i]==false) return  false;
        }return  true;
    }
    public int chalkReplacer(int[] chalk, int k) {
       int sum= 0;
       for(int a:chalk){
           sum+=a;
       }
       sum = k%sum;
       for(int i=0;i<chalk.length;i++){
           if(sum>=chalk[i]) sum-=chalk[i];
           else return  i;
       }
       return  0;


    }
    public int largestMagicSquare(int[][] grid) { 
        int n = grid[0].length;
        int m =grid.length;
      int dp[][] = new int[m+1][n+1];
      int dp1[][]  = new int[m+1][n+1];
      int dp2[][] = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i+1][j+1] = dp[i+1][j]+grid[i][j];
                dp1[i+1][j+1]=dp1[i][j]+grid[i][j];
                dp2[i+1][j+1]=dp1[i][j+2]+grid[i][j];
            }
        }
        int max =1;
        for (int i = 1; i < m; i++) {
            int sum[] = new int[n];
            //枚举下边
            for(int j=i;j<m;j++){
                int len = j-i+1;
                if(len<max) continue;
                boolean bool = false;
                 for(int k=0;k<n;k++) {
                     sum[k] += grid[j][k];
                 }
                 //枚举每个顶点
                 for(int h=len-1;h<=n;h++){
                     for(int d =h-1;d>h-1-len;d--){
                         if(sum[d]!=sum[h]) {
                             bool = true;
                             break;
                         }
                     }
                     if(bool) break;
                     //行
                     for(int hang =i+1;hang<=j;hang++) {
                         if (dp[hang][h + 1] - dp[hang][h + 1 - len] != (dp[i][h + 1] - dp[i][h + 1 - len])) {
                             bool = true;
                             break;
                         }

                     }
                     if (bool) break;
                     //斜边
                     if(dp1[j+1][h+1]-dp1[j+1-len][h+1-len]!=dp2[j+1][h+1]-dp2[j+1-len][h+1+len]) {
                       break;
                     }

                 }
                if (bool) break;
                if(max<len) {
                    max = Math.max(max, len);
                }
                break;

            }


        }
        return  max;

    }
    public boolean makeEqual(String[] words) {
        int hash[] = new int[26];
        for(String s:words){
            for (int i = 0; i < s.length(); i++) {
                hash[s.charAt(i)-'a']++;
            }
        }
        int len = words.length;
        for (int i = 0; i < 26; i++) {
            if(hash[i]%len!=0) return  false;

        }
        return  true;

    }
    public int maximumRemovals(String s, String p, int[] removable) {
      int r =  removable.length-1;
      int l =0;
      while (l<r){
          int mid  = (l+r)/2;
          if(judge(s,p,removable,mid)){
              l = mid;
          }else{
              r =mid-1;
          }
      }
      return  l;
    }

    private boolean judge(String s, String p, int[] removable, int mid) {
        boolean b[] = new boolean[p.length()];
        for(int i=0;i<=mid;i++){
            b[removable[i]] =true;
        }
        int index =0;
        for(int i=0;i<s.length();i++){
            if(!b[i]&&s.charAt(i)==p.charAt(index)){
                index++;
            }
        }
        return  index==p.length();
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
int dp[][] = new int[triplets.length][3];
int index=0;
        for (int i = 0; i < triplets.length; i++) {
            if(triplets[i][0]<=target[0]&&triplets[i][1]<=target[1]&&triplets[i][2]<=target[2]){
                dp[index] = triplets[i];
                index++;
            }
        }
        boolean  b1 = false;
        boolean  b2 = false;
        boolean  b3 = false;
        for(int i=0;i<index;i++){
            if(dp[i][0]==target[0]) b1=true;
            if(dp[i][1]==target[1]) b2=true;
            if(dp[i][2]==target[2]) b3=true;

        }
        if(b1&&b2&&b3) return  true;
        return  false;

    }


}
