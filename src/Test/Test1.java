package Test;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;



class Test1 {
    static Integer a[] =null;

    public static void main(String[] args) {
        //int a[][] = new int[][];
        Integer a[] =  new Integer[]{};

        System.out.println(a);
        System.out.println(a.length);





    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0;
        int right=0;
        int len = nums.length;
        int count =1;
        int res =0;
        while(right<len){
            count*=nums[right];
            while(count>=k){
                count/=nums[left];
                left++;
                res++;
            }
            res++;
            right++;
        }
        res+=len-left;
        return res;
    }
    public int subarraysWithKDistinct(int[] A, int K) {
        int left =0;
        int right=0;
        int count =0;
        int len = A.length;
        int  res=0;
        HashMap<Integer,Integer> map = new HashMap();
        while(left<len){
            if(right!=0){
                if(map.get(A[left])>1){
                    map.put(A[left],map.get(A[left])-1);
                    //res++;
                }else{
                    map.remove(A[left]);
                    count--;
                }
                left++;
                if(count==K) res++;
            }
            while(right<len&&(count<K||map.containsKey(A[right]))){
                map.put(A[right],map.getOrDefault((A[right]),0)+1);
                if(map.get(A[right])==1){
                    count++;
                }
                if(count==K) {
                    res++;
                }
                right++;
                if(right<len&&count==K&&!map.containsKey(A[right])) break;
            }
          //  left++;
        }
        return res;

    }
    public int equalSubstring(String s, String t, int maxCost) {
        int left =0,right=0;
        int count =0;
        int res = 0;
        int dp[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            dp[i]=Math.abs(s.charAt(i)-t.charAt(i));
            System.out.print(dp[i]+" ");
        }
        while(left<s.length()){
            if(left!=0){
                count-=dp[left-1];
            }
            while(right<s.length()&&count+dp[right]<=maxCost){
                count+=dp[right];
                right++;
            }
            System.out.print(right+" "+left);
            res=Math.max(res,right-left);
            left++;
        }
        return res;
    }

    int mod = 1000000007;

    public int countPairs(int[] deliciousness) {
        int count = 0;
        int dp[] = new int[10000000];
        int d = 1;
        for (int i = 1; i <= 21; i++) {
            d = d * 2;
            dp[d] = 1;
            System.out.println(d);
        }
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int sum = deliciousness[i] + deliciousness[j];
                if (isPowerOfTwo(sum)) {
                    System.out.println(sum);
                    count = (count + 1) % mod;
                }
            }
        }
        return count % mod;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public int candy(int[] ratings) {
        int left[] = new int[ratings.length];
        Arrays.fill(left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) left[i] += left[i - 1];
            else left[i] = 1;
        }
        int right = 1, res = 0;
        for (int i = ratings.length - 1; i > 0; i++) {
            System.out.print(i);
            if (ratings[i] > ratings[i - 1]) right++;
            else right = 1;
            res += Math.max(right, left[i]);
        }
        return res;
    }

    public char findTheDifference(String s, String t) {
        int len = s.length();
        int hash1[] = new int[26];
        int hash2[] = new int[26];
        for (int i = 0; i < len; i++) {
            hash1[s.charAt(i) - 'a']++;
            hash2[t.charAt(i) - 'a']++;
        }
        hash2[t.charAt(len) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (hash1[i] != hash2[i]) return (char) (i + 'a');
        }
        return 'a';
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public int solve(int n, int[] a) {
        // write code here
        LinkedList<Integer> list = new LinkedList();
        Arrays.sort(a);
        dfs(a, 0, list, 0);
        return max - min;
    }

    void dfs(int[] nums, int left, LinkedList<Integer> list, int sum) {
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
            if (list.size() == 3 && sum < nums[i]) {
                list.removeLast();
                break;
            }
            dfs(nums, i + 1, list, sum + nums[i]);
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
