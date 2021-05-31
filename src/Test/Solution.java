package Test;

import java.util.LinkedList;
import java.util.List;
class Solution {
    StringBuilder res=new StringBuilder();
    int num ;
    public String getPermutation(int n, int k) {
        if(n==1) return  "1";
        num=k;
        int jie =  get(n-1);
        int count =  k/jie;
        num-=count*jie;
        StringBuilder s = new StringBuilder();
        boolean vis[] = new boolean[n];
        int nums[] = new int[n];
        s.append(count+1);
        vis[count] = true;
        for (int i = 1; i <=n; i++) {
            nums[i-1] =  i;
        }
        dfs(nums,vis,s);
        return  res.toString();
    }
    int get(int n){
        int res =1;
        while (n!=0){
            res*=n;
            n--;
        }
        return  res;
    }
    void dfs(int nums[],boolean vis[],StringBuilder s){
        if(s.length()==nums.length) {
            num--;
            if(num==0) res=new StringBuilder(s);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(res.length()!=0) return;
            if(!vis[i]){
                vis[i] = true;
                s.append(nums[i]);
                dfs(nums,vis,s);
                s=s.deleteCharAt(s.length()-1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
         new Solution().getPermutation(2,1);
    }
}
