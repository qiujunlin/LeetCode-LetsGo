package Contest.week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class W305 {
    public static void main(String[] args) {
        System.out.println("dsad");
    }
    public int arithmeticTriplets(int[] nums, int diff) {
        int res =0;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[j]-nums[i]==diff&&nums[k]-nums[j]==diff){
                        res++;
                    }
                }
            }
        }
        return  res;
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer, ArrayList<Integer>>  map =new HashMap<>();
        for(int a[] :edges){
            map.computeIfAbsent(a[0],(key)->new ArrayList<>()).add(a[1]);
            map.computeIfAbsent(a[1],(key)->new ArrayList<>()).add(a[0]);
        }
        HashSet<Integer> vis =new HashSet<>();
        for(int a:restricted)vis.add(a);
        LinkedList<Integer> l =new LinkedList<>();
        l.addLast(0);
        int res =1;
        vis.add(0);

        while (!l.isEmpty()){

            int num = l.pollFirst();
            for(int a:  map.get(num)){
                if(!vis.contains(a)){
                    res++;
                    vis.add(a);
                    l.addLast(a);
                }
            }
        }
        return  res;

    }
    public boolean validPartition(int[] nums) {
        boolean vis[] = new boolean[nums.length];
        men = new int[nums.length];
        return dfs(0, nums);
    }

    int men[] ;
    boolean dfs(int i,int nums[]){
        if(i==nums.length)return  true;
        if(men[i]!=0) return  men[i]==1;
        int j =i;
int c =0;
         while (j<nums.length&&nums[j]==nums[i]){
             j++;c++;
         }
         boolean res =false;
         if(c==2){
          res|=  dfs(i+2,nums);
         }else if(c==1){
          if( i+2<nums.length) return  false;
          if(nums[i]!=nums[i+1]-1||nums[i]!=nums[i+1]-2) return  false;
           res|= dfs(i+3,nums);
         }else {
           res|= dfs(i+c,nums);
           res|= dfs(i+c-1,nums);
         }
         if(res) men[i] =1;
         else men[i]=-1;
         return  res;

    }
    public int longestIdealString(String s, int k) {
         int dp[] =new int[26];

        for (int i = 0; i <s.length() ; i++) {
             char c = s.charAt(i);
             int max =1;
             for (int j = 0; j <26 ; j++) {

                 if(c-'a'-j<=k){
                    max =Math.max(dp[c]+1,max);
                 }
            }
             dp[c] =max;
        }
        int res =0;
        for(int a :dp) res =Math.max(res,a);
        return  res;
    }
}
