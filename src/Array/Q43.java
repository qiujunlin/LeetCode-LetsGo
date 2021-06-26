package Array;

public class Q43 {
    public String multiply(String num1, String num2) {
        int a[]=  new int[num1.length()];
        int b[] = new int[num2.length()];
       // num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for(int i=0;i<num1.length();i++){
            a[i] =num1.charAt(i)-'0';
        }
        for(int i=0;i<num2.length();i++){
            b[i] =num2.charAt(i)-'0';
        }

        //  List<String> list =new ArrayList();
        StringBuilder pre = new StringBuilder();
        for(int  i=0;i<num2.length();i++){
            pre = get(a,i, b[i],pre);
        }

        return new StringBuilder(pre.substring(0,pre.length())).reverse().toString();
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
