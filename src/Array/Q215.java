package Array;

public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        int len  = nums.length;
        find(nums,0,len-1,k);
        return  nums[len-k];
    }

    private void find(int[] nums, int l, int r, int k) {
      int mid = partation(nums,l,r);
      if(k==mid) return;
      else if(k<mid&&k>l){
          find(nums,l,mid-1,k);
      }else if(k>mid&&k<r) {
          find(nums, mid + 1, r, k);
      }
    }

    private int partation(int[] nums, int l, int r) {
           int left   = l;
           int right=  r;
           while (left<right){
               while (left<right&&nums[left]<=nums[l]) left++;
               while (left<right&&nums[right]>=nums[l]) right--;
               if(left<right){
                   swap(nums,left,right);
               }
           }
           swap(nums,nums[left],l);
           return  left;
    }

    private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] =nums[right];
    nums[right] =temp;
    }


}
