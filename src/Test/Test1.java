package Test;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

class Test{
    public static void main(String[] args) {
        int a = 4; //分别执行以下五种情况
   a++=a++;

    }

    int mod= 1000000007;
    public int countPairs(int[] deliciousness) {
        int count =0;
        int dp[]=new int[10000000];
        int d=1;
        for(int i =1;i<=21;i++){
            d=d*2;
            dp[d]=1;
            System.out.println(d);
        }
        for(int i=0;i<deliciousness.length;i++){
            for(int j=i+1;j<deliciousness.length;j++){
                int sum=deliciousness[i]+deliciousness[j];
                if(isPowerOfTwo(sum)) {
                    System.out.println(sum);
                    count=(count+1)%mod;
                }
            }
        }
        return count%mod;
    }
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public int candy(int[] ratings) {
        int left[] = new int[ratings.length];
        Arrays.fill(left,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) left[i]+=left[i-1];
            else left[i] = 1;
        }
        int right=1,res=0;
        for(int i=ratings.length-1;i>0;i++){
            System.out.print(i);
            if(ratings[i]>ratings[i-1]) right++;
            else right=1;
            res+=Math.max(right,left[i]);
        }
        return res;
    }

    public char findTheDifference(String s, String t) {
        int len=s.length();
        int  hash1[]=new int[26];
        int hash2[]= new int[26];
        for(int  i =0;i<len;i++){
            hash1[s.charAt(i)-'a']++;
            hash2[t.charAt(i)-'a']++;
        }
        hash2[t.charAt(len)-'a']++;
        for(int i=0;i<26;i++){
            if(hash1[i]!=hash2[i]) return (char)(i+'a');
        }
        return 'a';
    }
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public int solve(int n, int[] a) {
        // write code here
        LinkedList<Integer> list = new LinkedList();
        Arrays.sort(a);
        dfs(a, 0, list,0);
        return max - min;
    }

    void  dfs(int[] nums, int left, LinkedList<Integer> list,int sum) {
        if (list.size() == 3) {
            int a = list.get(0);
            int b = list.get(1);
            int c = list.get(2);
            if (valid(a, b, c)) {
                max = Math.max(max, sum);
                min = Math.min(min, sum);

            }
        }
        for (int i = left; i < nums.length; i++) {
            list.offer(nums[i]);
            if(list.size()==3&&sum<nums[i]) {
                list.removeLast();
                break;
            }
            dfs(nums, i + 1, list,sum+nums[i]);
            list.removeLast();
        }
    }

    boolean valid(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            return false;
        }
    }

}
