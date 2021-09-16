package leetcode;

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
    int ans =Integer.MAX_VALUE;
    int k ;
    public int minimumTimeRequired2(int[] jobs, int _k) {
        k = _k;
        int assign[] = new int[k];
        dfs2(jobs,assign,0,0,0);
        return  ans;
    }

    /**
     *
     * @param jobs
     * @param assign
     * @param j  jobs
     * @param i   assign
     */
    private void dfs2(int[] jobs, int[] assign, int j, int i,int max) {
        if(ans<max) return;
        if(j==jobs.length){
            ans = max;
            return;
        }
          if(i<k){
              assign[j] = jobs[i];
              dfs2(jobs,assign,j+1,i+1,Math.max(assign[j],max));
              assign[j] =0;
          }
        for (int l = 0; l < i; l++) {
            assign[l]+=jobs[j];
            dfs2(jobs,assign,j+1,i,Math.max(assign[j],max));
            assign[l] -= jobs[j];
        }
    }
}
