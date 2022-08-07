package template.mianshi.bytedance;



import java.util.Scanner;

public class BIgCHnegfa {



    public static void main(String[] args)  {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String cur = "1";
            String res = "1";
            while (!cur.equals(s)) {
                String next = addStrings(cur, "1");
                res = multiply(res, next);
                cur = next;
            }
            System.out.println(res);
        }
    }
    public static  String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 =num2.length();
        int dp[] =new int[len1+len2];
        for(int i  =len1-1;i>=0;i--){
            int a = num1.charAt(i)-'0';
            for(int j=len2-1;j>=0;j--){
                int b = num2.charAt(j) -'0';
                int s = a*b + dp[i+j+1];
                dp[i+j] +=  s/10;
                dp[i+j+1] = s%10;
            }
        }
        StringBuffer s =new StringBuffer();
        int i =0;
        while(i<dp.length&&dp[i]==0) i++;
        for(;i<dp.length;i++){
            s.append(dp[i]);
        }
        return s.length()==0?"0":s.toString();
    }
    public static  String addStrings(String num1, String num2) {
        StringBuilder s =new StringBuilder();
        int i =num1.length()-1;int  j=num2.length()-1;
        int pre =0;
        while(i>=0||j>=0){

            int a = i<0?0:num1.charAt(i)-'0';
            int b =j<0?0: num2.charAt(j)-'0';

            s.append((a+b+pre)%10);
            pre = (a+b+pre)/10;
            i--;j--;
        }
        if(pre!=0)s.append(pre);
        return s.reverse().toString();

    }
}







