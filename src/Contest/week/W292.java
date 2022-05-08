package Contest.week;

public class W292 {
    public static void main(String[] args) {
        System.out.println("dsada");

    }
    public String largestGoodInteger(String num) {
       int i =0;
       String res  = "";
       while (i<num.length()){
           char c =  num.charAt(i);
           int j  =i;
           while (j<num.length()&&num.charAt(j)==c) j++;
           if(j-i>3) {
               String t =  num.substring(i,i+3);
               System.out.println(t);
               if (res.length() == 0 || Integer.valueOf(res) < Integer.valueOf(t)) {
                   res = t;
               }
           }
           i = j;
           }
       return  res;
    }
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    int res  =0;
    public int averageOfSubtree(TreeNode root) {
        int c[]  =  dfs(root);
        return  res;


    }

    private int[] dfs(TreeNode root) {
        if(root==null)  return  new  int[]{0,0};
        if(root.left==null&&root.right==null) {
            res++;
            return  new int[]{1,root.val};
        }
        int left[] ;
        int right[];
         left = dfs(root.left);
         right =dfs(root.right);
         int sum  =left[1]+right[1] + root.val;
        int c = left[0] +right[0] +1;
        if(sum/c==root.val)res++;
        return  new int[]{c,sum};

    }
    public int countTexts(String pressedKeys) {

        int i =0;
        int mod  =1000000007;
        long res =1;
        while (i<pressedKeys.length()){
            int j=i;
            while (j<pressedKeys.length()&&pressedKeys.charAt(i)==pressedKeys.charAt(j)) j++;
            int num  = pressedKeys.charAt(i)-'0';
            int len = j-i;

            long dp[] = new long[len+1];
            dp[0]=dp[1] =1;dp[2] =2;dp[3] = 4;
            int length =  3;
             if(num==7||num==9)  length=4;
            for (int k = length; k <=len ; k++) {
                for (int l = k-1; l >=1&&k-l+1<=length ; l--) {
                     dp[k] = (dp[k] + dp[l] * dp[k-l])%mod;
                }
            }
            res = (res * dp[len])%mod;
        }
        return  (int)(res%mod);
    }

}
