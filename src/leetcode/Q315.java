package leetcode;

import  java.util.*;
public class Q315 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int temp[] = new int[n];
        int count = mergesort(nums, 0, n - 1, temp);
        return count;

    }
    private int mergesort(int[] nums, int left, int right, int[] temp) {
        if (left == right) return 0;
        int mid = (right + left) / 2;
        int count1 = mergesort(nums, left, mid, temp);
        int count2 = mergesort(nums, mid + 1, right, temp);
        int count3 = merge(nums, left, mid, right, temp);
        return count2 + count1 + count3;
    }

    private int merge(int[] nums, int left, int mid, int right, int[] temp) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int index = left;
        int l = left;
        int r = mid + 1;
        for (int i = left; i <= right; i++) {
            if (l == mid + 1) {
                nums[index] = temp[r++];
            } else if (r == right + 1) {
                nums[index] = temp[l++];
            } else if (temp[l] < temp[r]) {
                nums[index] = temp[l++];
            } else {
                nums[index] = temp[r++];
                res += r - mid - 1;
            }
        }
        return res;
    }

    public int reversePairs2(int[] nums) {
        int temp[] = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(temp);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(temp, nums[i]);
        }
        int res = 0;
        TreeArray treeArray = new TreeArray(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            treeArray.update(nums[i], 1);
            res += treeArray.query(nums[i] - 1);
        }
        return res;
    }
}
class  TreeArray{
    int tree[];
    int n ;
    public  TreeArray(int n){
        tree = new int[n+1];
        this.n = n;
    }
    public  void update(int x,int num){
         while (x<=n){
             tree[x]+=num;
             x+=lowbit(x);
         }
    }
    public  int query(int x){
    int res =0;
    while (x>0){
        res+=tree[x];
        x-=lowbit(x);
    }
    return  res;
    }
    public  int lowbit(int x){
        return  x&-x;

    }

}

