## 二分查找

### 34. 在排序数组中查找元素的第一个和最后一个位置

这一篇题解写得特别好，[关于 while (left <= right) 写法返回值的详细讨论](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/da-jia-bu-yao-kan-labuladong-de-jie-fa-fei-chang-2/)

```java
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
```

