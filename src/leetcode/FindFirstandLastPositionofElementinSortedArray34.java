package leetcode;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/14
 */
public class FindFirstandLastPositionofElementinSortedArray34 {
    public static void main(String[] args) {
        int a[] = new int[]{2,4,4,4,5,6,7,7,7};
        System.out.println(new FindFirstandLastPositionofElementinSortedArray34().searchRange(a,4));
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1} ;
        int left = findleft(nums,target);
        if(nums[left] != target) return new int[]{-1,-1};
        int right = findright(nums, target);
        return new int[]{left,right};
    }
    int findleft(int[] nums,int target){
        int left=0;
        int right = nums.length - 1;
        while(left < right){
            int mid= left + (right - left) / 2;
            if(nums[mid]<target){
                left=mid+1;

            }else{
                right=mid;
            }
           // System.out.println(nums[left]);
        }
        return left;
    }
    int findright(int[] nums,int target){
        int left=0;
        int right = nums.length - 1;
        while(left < right){
            int mid= left + (right - left + 1 )/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return left;
    }


}
