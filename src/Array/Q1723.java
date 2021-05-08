package Array;

import java.util.Arrays;

public class Q1723 {
    public int minimumTimeRequired(int[] jobs, int k) {
        int sum =0;
        int max = 0;
        for (int a : jobs){
            sum += a;
            max = Math.max(max,a);
        }
        int left = max;
        int right = sum;

        while (left<right){
            int mid  = (left+right)>>1;
            int arr[] = new int[k];
            if(check(jobs,mid,arr)){
                right = mid;
            }else{
                left=mid+1;
            }
        }
        return  left;


    }

    private boolean check(int[] jobs, int mid, int[] arr) {
         if(dfs(jobs,mid,arr,0)) return  true;
         else return  false;
    }

    private boolean dfs(int[] jobs, int mid, int[] arr, int i) {
         if(i==jobs.length) return  true;
         for(int j=0;j<arr.length;j++){
             if(arr[j]+jobs[i]<=mid){
                 arr[j] +=  jobs[i];
                 boolean  res =  dfs(jobs,mid,arr,i+1);
                if(res) return  true;
                arr[j] -= jobs[i];
             }
         }
         return  false;
    }
}
