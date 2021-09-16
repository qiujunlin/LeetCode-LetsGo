package leetcode;

/**
 * @Classname T34
 * @Description:
 * @Date 2020/12/1 14:49
 * @Created by qiujunlin
 */
public class T34 {
    public int[] searchRange(int[] nums, int target) {
        int left = findFirst(nums,target);
        int right=findRight(nums,target);
        if(left==-1) return new int[]{-1,-1};
        return new int[]{left,right};
    }
    int findFirst(int nums[],int target){
        ///int res=-1;
        int left=0;int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)  right=mid-1;
            else if(nums[mid]>target) right=mid-1;
            else left=mid+1;
        }
        //判断边界
        if(left<nums.length&&nums[left]==target) return left;
        return -1;
    }
    int findRight(int nums[],int target){
        ///int res=-1;
        int left=0;int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)  left=mid+1;
            else if(nums[mid]>target) right=mid-1;
            else left=mid+1;
        }
        if(right>=0&&nums[right]==target) return right;
        return -1;
    }

    public static void main(String[] args) {
        int a[]={5};
        int res[]=new T34().searchRange(a,6);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}
