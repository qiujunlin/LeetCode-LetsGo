package Contest.week;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class W286 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> l =new ArrayList<>();
        HashSet<Integer> set1 =new HashSet<>();
        HashSet<Integer> set2 =new HashSet<>();
        for(int a:nums1) set1.add(a);
        for(int a:nums2) set2.add(a);
        ArrayList<Integer> l1 =new ArrayList<>();
        for(int a :set1) {
            if(!set2.contains(a)) l1.add(a);
        }
        ArrayList<Integer> l2 =new ArrayList<>();
        for(int a :set2) {
            if(!set1.contains(a)) l2.add(a);
        }
        l.add(l1);l.add(l2);
        return  l;

    }
    public int minDeletion(int[] nums) {
          int l =0;
          int r   =1;
          int i =0;
          int c =0;
          while (l<nums.length-1&&r<nums.length){
              if(nums[l]==nums[r]) {
                  c++;
                  l = r;
                  r =r+1;
              }else{
                  l = r+1;
                  r = r+2;
              }
          }
          if(l==nums.length-1) c++;
          return  c;

    }
    public long[] kthPalindrome(int[] queries, int intLength) {
         long[] res  =new long[queries.length];
        for (int i = 0; i <queries.length ; i++) {
            if(intLength==1) res[i] =queries[i];
            else if(intLength==2) res[i] = Long.valueOf(String.valueOf(queries[i])+String.valueOf(queries[i]));
            else  res[i] = get1(queries[i],intLength);

        }
        for (int i = 0; i <res.length ; i++) {
            if(String.valueOf(res[i]).length()!=intLength)res[i] =-1;
        }
        return  res;
    }

    private long get1(int query, int intLength) {

        if(intLength%2==1){
            int l = intLength/2+1;
            int s = (int)Math.pow(10,l-1)-1;
            int m  = s+l;
            String rs = String.valueOf(m);
           String t =  rs + new StringBuilder(rs.substring(0,rs.length()-1)).reverse().toString();

            if(t.length()!=intLength) return  -1;
            System.out.println(t);
            return  Long.valueOf(t);
        }else{
            int l =intLength/2;
            int s = (int)Math.pow(10,l-1)-1;
            int m  = s+l;
            String rs = String.valueOf(m);
            String t = rs + new StringBuilder(rs).reverse().toString();
            if(t.length()!=intLength||t.length()>String.valueOf(Long.MAX_VALUE).length())return  -1;
            return  Long.valueOf(t);
        }
    }

    private long get(int query, int intLength) {
        long pre[] = new long[intLength];
        pre[0] = 0;pre[1] =10;
        for (int i = 2; i <pre.length ; i++) {
            pre[i] =pre[i-1]*10;
        }
        if(intLength%2==0){
            int l =  intLength/2;
            int c =  0;
            int res =1;

            for (int j = 1; j <=9 ; j++) {
                if(query-pre[l-1-1]*j<=0){
                    res = j;
                }
            }
            int i =2;
            while (i<=l){
                for (int j = 0; j <10 ; j++) {
                    if(query-pre[l-i-1]*j<=0) {
                        res =res*10 + j;
                        break;
                    }
                }
                i++;
            }
            String s = String.valueOf(res);
            return  Long.valueOf(s + new StringBuilder(s).reverse().toString());
        }else{
            int l =  intLength/2+1;

            int res =1;
            for (int j = 1; j <=9 ; j++) {
                if(query-pre[l-2]*(j+1)<=0){
                    res = j;
                    break;
                }
            }
            int i =2;
            while (i<=l){
                for (int j = 0; j <10 ; j++) {
                    if(query-pre[l-i-1]*(j+1)<=0) {
                        res =res*10 + j;
                        break;
                    }
                }
                i++;
            }
            String s = String.valueOf(res);
            return  Long.valueOf(s + new StringBuilder(s.substring(0,s.length()-1)).reverse().toString());
        }
    }

    public static void main(String[] args) {


    }


}
