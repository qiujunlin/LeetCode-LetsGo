package WeeklyContest;

public class DW31 {
    public static void main(String[] args) {

    }
    public int countOdds(int low, int high) {
       int a = high/2;
       if(high%2==1) a++;
       int b=low/2;
       return  a-b;
    }
    public int numOfSubarrays(int[] arr) {
        int odd =0;int eve  = 0;
        int mod  = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==1){
                eve=(eve+odd)%mod;
                odd++;
            }else{
                 odd  =(odd+eve)%mod;
                 eve++;
            }
        }
        return  odd;
    }
    public int numSplits(String s) {
        int a[] =new int[26];
        int count =0;
        for (int i = 0; i < s.length(); i++) {
           a[s.charAt(i)-'a']++;
           if(a[s.charAt(i)-'a']==1) count++;
        }
        int c1 = 0;
        int c2 =count;
        int b[] =new int[26];
        int res =0;
        for (int i = 0; i < s.length(); i++) {
           a[s.charAt(i)-'a']--;
           b[s.charAt(i)-'a']++;
           if(b[s.charAt(i)-'a']==1) c1++;
           if(a[s.charAt(i)-'a']==0) c2--;
           if(c1==c2) res++;
        }
        return  res;
    }
    public int minNumberOperations(int[] target) {
        int count  =0;
        int i  =0;
        while (i<target.length){
            if(i+1<target.length&&target[i]>target[i+1]){
                count+=target[i]-target[i+1];
            }
        }
        count+=target[target.length-1];
        return  count;
    }

}
