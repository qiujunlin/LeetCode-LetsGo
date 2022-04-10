package Contest.week;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class W288 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE<1E10);
    }
    public int largestInteger(int num) {
      String s =  String.valueOf(num);
      char ch[] =s.toCharArray();
        ArrayList<Integer>  l1 =new ArrayList<>();
        ArrayList<Integer>  l2 =new ArrayList<>();
        while (num>0){
            int c =  num%10;
            num=num/10;
            if(c%2==0){
                l1.add(c);
            }else{
                l2.add(c);
            }
        }
        Collections.sort(l1);
        Collections.sort(l2);
        Collections.reverse(l1);
        Collections.reverse(l2);
        System.out.println(l1);
        System.out.println(l2);
        int i =0;int j=0;
        for (int k = 0; k <s.length() ; k++) {
            int a = s.charAt(k)-'0';
            System.out.println(a);
            if(a%2==0){
                ch[i] = (char)(l1.get(i)+'0');
                i++;
            }else{
                ch[i] = (char)(l2.get(j)+'0');
                j++;
            }
        }
        return  Integer.valueOf(new String(ch));
    }
    public String minimizeResult(String expression) {
        int i =  expression.indexOf('+');
        int max  =0;
        int maxl = 0;
        int maxr = 0;
        for (int j = 0; j < max ; j++) {
            for (int k = max+1; k <expression.length() ; k++) {
                   int a = j==0?1:Integer.valueOf(expression.substring(0,j));
                   int b =  Integer.valueOf(expression.substring(j,i));
                   int c =  Integer.valueOf(expression.substring(i+1,k));
                   int d =  k==expression.length()-1?1:Integer.valueOf(expression.substring(k+1,expression.length()));
                   int res  =  a*(b+c)*d;
                   if(res>max){
                       maxl =j;
                       maxr =k;
                       max=res;
                   }
                System.out.println(res);
            }
        }
        StringBuilder res =new StringBuilder();
        for (int j = 0; j <expression.length(); j++) {
            if(j==maxl) res.append('(');
            res.append(expression);
            if(j==maxr) res.append(')');
        }
        return  res.toString();

    }
    public int maximumProduct(int[] nums, int k) {
        long res =1;
        int mod =1000000007;
        PriorityQueue<Long>q = new PriorityQueue((a,b)-> {
            Long s = (Long)a;
            Long r = (Long)b;
            return  ((Long) a).compareTo(r);
        });
        int countzero =0;
        for(int a:nums) {
            if(a==0) countzero ++;
            if(a!=0){
                res =(res*a)%mod;
            }
            q.offer((long)a);
        }
        long max  =0;
        if(countzero>k) return   0;
        while (k>0){
            long min =q.poll();
            if(min==0) {
                countzero --;
                q.offer(1L);
                k--;
                continue;
            }
            q.offer(min+1);
            k--;
        }
        for(long a :q){
            res =(res*a)%mod;
        }
        return  (int)((res)%mod);


    }

}
