package Test;

import Tree.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import javax.print.attribute.EnumSyntax;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

public class TEST {

    public static void main(String[] args)
    {
        int a[] = new int[]{1,2,3,5,6,4,2,3,3,5,6,1};
      Arrays.sort(a,6,a.length-1);
        for (int c:
             a) {
            System.out.println(c);
        }
    }

    public int stoneGameVII(int[] stones) {
        LinkedList<Integer> list = new LinkedList();
        for(int num:stones){
            list.offer(num);
        }
        int ales=0;
        int bob=0;
        int flag=0;
        while(list.size()!=0){
            int left=list.getFirst();
            int right=list.getLast();
            if(left>right) {
                if(flag==0){
                    list.removeLast();
                    ales+=sum(list);
                    flag=1;
                }else{
                    list.removeFirst();
                    bob=bob+sum(list);
                    flag=0;
                }
            }else{
                if(flag==0){
                    list.removeFirst();
                    ales+=sum(list);
                    flag=1;
                }else{
                    list.removeLast();
                    bob=bob+sum(list);
                    flag=0;
                }


            }

          System.out.println("alex"+ales);
            System.out.println("bob"+bob);

        }
        int left=list.getFirst();
        int right=list.getLast();
        ales=ales+Math.max(left,right);
        bob=bob+Math.min(left,right);
        return ales-bob;
    }
    int sum(LinkedList<Integer> list) {
        int sum=0;
        for(Integer a:list){
            sum=sum+a;
        }
        return sum;
    }
    public int search1(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >  nums[right]) {
                  ;left=mid;
            } else {
                right=mid-1;
            }
        }
        return left;
    }
    public int Maximumlength (String x) {
       int max=0;
       for(int i=1;i<x.length()-1;i++){
           if(x.charAt(i)=='b'){
             int  lenb=1;
             int  right=i+1;
             while(right<x.length()&&x.charAt(right)=='b'){
                 lenb++;
                 right++;
             }
             int left=i-1;
             int lenab=0;
             while(left>=0&&right<x.length()&&x.charAt(left)=='a'&&x.charAt(right)=='c'){
                 left--;
                 right++;
                 lenab++;
             }
           //  if(lenb)
             if(lenb==lenab) max=Math.max(max,lenb);
             else i=right;
           }
       }
       return  max*3;
    }
    String isSame(int len){
       char s[]= new char[len*3];
       int i=0;
        for( i=0;i<len;i++){
           s[i]='a';
        } for( ;i<len*2;i++){
            s[i]='b';
        }
        for( ;i<len*3;i++){
            s[i]='c';
        }

        return  Arrays.toString(s);
    }
    public int countWine (int m, int n) {
        // write code here
        int res=0;
        n=n/m;
        int a=n;//瓶
        int b=n;//瓶盖

        while(a>=2||b>=4){
            res=res+n;
            n=a/2+b/4;

            a=a%2+n;
            b=b%4+n;
        }
        return res+n;
    }
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid =  left + (right - left) / 2 ;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                if(nums[left]>nums[right]) right=mid-1;
                else   left=mid+1;
            }else if(nums[mid]>target){
                if(nums[left]>nums[right])  left=mid+1;
                else   right=mid-1;
            }
        }
        if(nums[left]==target)
            return left;
        return -1;
    }
    List<Integer> res;
    public List<Integer> splitIntoFibonacci(String S) {
        res = new LinkedList<>();
        LinkedList list = new LinkedList();
        dfs(S,0,list);
       // Collections.reverse(res);
        return res;
    }
    void dfs(String s,int index,LinkedList<Integer> list){
          if(index==s.length()) {
              if(list.size()>=3)
              res=new ArrayList<>(list);
              return;
          }

        for(int i=index;i<s.length();i++){
            String  str= s.substring(index,i+1);
            if(str.length()>1&&str.charAt(0)=='0') continue;

            long a=Long.valueOf(str);
            if(a>Integer.MAX_VALUE) break;
            int num= (int)a;

            if(list.size()>=2) {
                Integer nums1 = list.getLast();
                Integer nums2 = list.get(list.size() - 2);
                if (num > nums1 +nums2) break;
                else if (num < nums1 + nums2) continue;
            }
            list.offer(num);
            dfs(s,i+1,list);
            list.removeLast();
        }
    }

    public double myPow(double x, int n) {
        int a=n>0?1:-1;
        long b=n;
        if(n<0) b=-b;
        double res=1;
        while(b>0){
            if((b&1)==1){
                res=res*x;
            }
            x=x*x;
            b=b>>1;
        }
        return a==1?res:(1.0/res);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
        int start1=0,start2=0;
        int pre=0,next=0;
        for(int i=0;i<=len/2;i++){
            pre=next;
            if(start2>=nums2.length||(start1<nums1.length&&nums1[start1]<nums2[start2])){
                next=nums1[start1];
                start1++;
            }else{
                next=nums2[start2];
                start2++;

            }
            //pre=next;
        }
        if(len%2==0) return (pre+next)/2;
        return next;
    }
    public int concatenatedBinary(int n) {
        String s="";
        for(int i=1;i<=n;i++){
            String a=toBinaryString(i);;
            s+=a;
            if(a.lastIndexOf(0)=='0') {
                a=s.substring(0,a.length()-1);
                a=a+"1";
                if(i+1<=n) {
                    s+=a;
                    i=i+2;
                }
            }
           // System.out.println(s);
        }
        int res=0;

        for(int i=s.length()-1,t=1;i>=0;i--,t=t*2%1000000007){
            char a=s.charAt(i);
            res= (res+((a-48)*t)%1000000007)%1000000007;
        }
        System.out.println(res);
        return res;

    }
    //String res="";
    void fun(StringBuilder str,int number){
          if(number/2==0) return ;
          else fun(str,number/2);
          str.append(number%2);

    }
    String toBinaryString(Integer number) {
        StringBuilder sb = new StringBuilder();
        for (int n = number; n > 0 ; n /= 2) {
            sb.append(n %  2);

        }
        sb=sb.reverse();
         return sb.toString();
    }
    public int string2 (int k, String s) {
        // write code here
        // write code here
        int maxlength=0;
        for(int i=0;i<s.length();i++){
            int length=1;
            int time=k;
            int index=i;
            while(time>0&&index+1<s.length()){
                int c=s.charAt(index+1)-s.charAt(index);
                time=time-c;
                if(time>=0)
                    length++;
                index++;
            }
            while(time==0&&index+1<s.length()&&s.charAt(index)+1==s.charAt(index+1)) length++;
            maxlength=Math.max(maxlength,length);
        }
        return maxlength;
    }
    public int solve (int a, int b, int n) {
        // write code here
        int max=0;
        int i=n;
        while(i<=n){
            if(i%a==b) {
                max=i;
               break;
            }else
            i--;
        }
    return max;
    }
    //int min=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            int res=amount+1;
            for(int j=0;j<coins.length;j++) {
                if (i >= coins[j]) {
                    int a = dp[i - coins[j]];
                    if (a != amount + 1 && res > a) res = a + 1;
                }
            }
            dp[i]=res==amount+1?amount+1:res                    ;
        }

        return dp[amount]==amount+1?-1:dp[amount];
        //return dfs(coins,dp,amount);
    }

    public String Probability (int n) {
        // write code here
        double x=2.0;
        double res=2/fun(x,n);
        String s = String.format("%.2f", res);
        return s ;

    }
    double fun(double x,long n){
        double res =1;
        while(n>0){
            if((n&1)==1){
                res=res*x;
            }
            n=n>>1;
            x=x*x;
        }

        return res;

    }
    private long mod = 1000000007;
    public long power(int x,long n) {
        if(n == 0){
            return 1;
        }
        long t = power(x,n/2);
        t = (t*t)%mod;
        if(n%2 == 1){
            t = (t*x)%mod;
        }
        return t%mod;
    }
    public int Answerforcn (long n) {
        // write code here
        // Cn = 15Cn-1

        return (int)(power(15,n-1)*14%mod);
    }
    public int Answerforcn2(long n) {
        // write code here
        System.out.println(fiba(n));
        return (int)(fiba(n)*fibb(n)%1000000007);
    }
    public double fiba(long N) {
        if(N==1) return 2;
        if(N==2) return 6;
        // if(N==2||N==1) return 1;
        //
        //    else return fib(N-1)+fib(N-2);
        double pre1=2;
        double pre2=6;
        //if(N==1)
        for(int i=3;i<=N;i++){
            double a=3*pre1%1000000007+2*pre2%1000000007;
            pre1=pre2;
            pre2=a;
        }
        return pre2;
    }
    public double fibb(long N) {
        if(N==1) return 7;
        if(N==2) return 35;
        double pre1=7;
        double pre2=35;
        //if(N==1)
        for(int i=3;i<=N;i++){
            double a=10*pre1%1000000007+3*pre2%1000000007 ;
            pre1=pre2;
            pre2=a;
        }
        return pre2%1000000007;
    }
    long fb(long n){

        if(n==1) return 7;
        if(n==2) return 35;
        return 3*fb(n-1)+10*fb(n-2);
    }
    public int Minimumdays (int n, int[] DEF) {
        // write code here
        Arrays.sort(DEF);
        int day=0;
        // int res=0;
        for(int i=0;i<DEF.length;i++){
            // res++;
            if(day<DEF[i] ){
                while(day<DEF[i]){
                    day++;
                }//day=i
                continue;
            }
            day++;
            // if(day==i)
        }
        return day;
    }
    public long tree4 (long n) {
        long res=0;
        int level=1;
        while(Math.pow(2,level)-1<n){
           level++;
        }

        int i=1;
        int num=1;
        while(i<level){
            for(int j=0;j<num;j++){
                res=res+i*(num+j);
            }
            i++;
            num*=2;
        }
        for(int j=0;j<n-Math.pow(2,level-1)+1;j++){
            res=res+level*(num+j);
        }

        return res%998244353;
    }


}
