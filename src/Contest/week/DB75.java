package Contest.week;

public class DB75 {
    public static void main(String[] args) {
        System.out.println("dsad");
    }
    public int minBitFlips(int start, int goal) {
       int c =0;
        for (int i = 0; i < 32; i++) {
             if((goal>>i&1)!=(start>>i&1)) c++;
        }
        return  c;
    }
    public int triangularSum(int[] nums) {
        for (int i = nums.length-1; i>=1; i--) {
            for (int j = 0; j <i ; j++) {
                 nums[j] =(nums[j] +nums[j+1])%10;
            }
        }
        return  nums[0];

    }
    public long numberOfWays(String s) {
        long pre[] =new long[s.length()+1];
        int pre2[] =new int[s.length()];
        long c =s.charAt(0)=='1'?1:0;

        for (int i = 1; i <s.length(); i++) {
            pre[i] =c;
            if(s.charAt(i)=='1') c++;
        }

        long res  =0;

        for (int i = 1; i < s.length()-1; i++) {
             if(s.charAt(i)=='1') {
                 long l  = i-pre[i];
                 long r  = (s.length()-1-i)-(c-pre[i+1]);
                 res+=(l*r);

             }else{
                 long l  = pre[i];
                 long r  =  c-pre[i+1];
                 res+= (l*r);
             }
        }
        return  res;

    }




}
