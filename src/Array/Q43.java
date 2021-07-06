package Array;

public class Q43 {
    public String multiply(String num1, String num2) {
         int len1 = num1.length();
         int len2 = num2.length();
         int mut[][] = new int[len1][250];
         int a[] =  new int[len1];
        for (int i = 0; i < len1; i++) {
            a[i] = num1.charAt(i)-'0';
        }
         int b[] =  new int[len2];
        for (int i = 0; i < len2; i++) {
            b[i] = num2.charAt(i)-'0';
        }
        int row  =0;
        for (int i = len1-1; i >=0; i--) {// len2 * len1
            int  n =  a[i];
            int pre  =0;
            int  col  =0;
            for (int j = len2-1; j >= 0; j--) {
                 int res = pre+n*b[j];
                 mut[row][row+col] = res%10;
                 pre = res/10;
                 col++;
            }
            if(pre!=0) mut[row+1][col+row]=pre;
            row++;
        }
       StringBuilder re = new StringBuilder();
        int pre =0;
        for (int i = 0; i < 250; i++) {
            int sum =pre;
            for (int j = 0; j < len1; j++) {
                  sum+=mut[j][i];
            }
            if(sum==0) break;
            re.append(sum%10);
            pre = sum/10;
        }
        return re.reverse().toString();


    }

    StringBuilder get(int nums[],int n,int num,StringBuilder prestring){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<n;i++){
            s.append("0");
        }
        int pre =0;
        for(int i=nums.length-1;i>=0;i--){
            int a = nums[i]*num+pre;
            s.append(a%10);
            pre = a/10;
        }
        s.append(pre==0?"":pre);
        StringBuilder res=new StringBuilder();
        int pre2 =0;
        for(int i =0;i<s.length();i++){
            if(i<prestring.length()){
                int nn = prestring.charAt(i)-'0'+s.charAt(i)-'0'+pre2;
                res.append(nn%10);
                pre2 = nn/10;
            }else{
                int c = s.charAt(i)-'0'+pre2;
                res.append(c%10);
                pre2 = c/10;
            }
        }
        res.append(pre2==0?"":pre2);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q43().multiply("2","3"));
    }
}
