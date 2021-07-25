package Contest.week;

/**
 * @Classname Q240
 * @Description:
 * @Date 2021/5/9 15:18
 * @Created by qiujunlin
 */
public class week240 {

    public int maximumPopulation(int[][] logs) {
    int hash[]= new int[100];
    for(int log[]:logs){
        for(int i=log[0];i<log[1];i++){
            hash[i-1950]++;
        }
    }
    int res=0;
    for(int a:hash) res=Math.max(a,res);
    return  res;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
          int i=0;
         // int j=0;
          int max=0;
    for(int j=0;j<nums2.length;j++){
        while (i<nums1.length&&nums1[i]>nums2[j]){
            i++;
        }
        if(i<j){
            max=Math.max(j-i,max);
        }
    }
    return  max;
    }

    public int minDays(int[] bloomDay, int m, int k) {
          if(m*k>bloomDay.length) return -1;
          
          int left =0;
          int right= 0;
          for(int a:bloomDay) right=Math.max(a,right);
          while (left<right){
              int mid=(left+right)>>1;
              if(check(bloomDay,mid,m,k)){
                  right=mid;
              }else{
                  left=mid+1;
              }
          }
          return  left;
                  
    }

    private boolean check(int[] bloomDay, int mid, int m, int k) {
      boolean b[] = new boolean[bloomDay.length];
      for(int i=0;i<bloomDay.length;i++){
          if(bloomDay[i]<=mid) b[i]=true;
      }
      int count =0;
      int res=0;
      for(int i=0;i<bloomDay.length;i++){
          if(b[i]){
              count++;
              if(count==k){
                  res++;
                  count=0;
              }
          }else{
              count=0;
          }
      }
      return  res>=m;
    }

}
