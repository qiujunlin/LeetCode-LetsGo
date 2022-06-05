package Contest.week;

import java.util.Arrays;
import java.util.HashMap;

public class W296 {
    public static void main(String[] args) {
        System.out.println("dsa");
    }
    public int minMaxGame(int[] nums) {
        while (nums.length>1){
            int temp[] =new int[nums.length/2];
            for (int i = 0; i < temp.length; i++) {
                 if(i%2==0){
                     temp[i] =Math.min(nums[i*2],nums[i*2+1]);
                 }else{
                     temp[i] =Math.max(nums[i*2],nums[i*2+1]);
                 }
            }
            nums =temp;
        }
        return  nums[0];

    }
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int l  =1;
        int r = nums.length;
        while (l<r){
            int mid =(l+r)/2;
            if(judge(nums,k,mid)){
                r =mid;
            }else{
                l =mid+1;
            }
        }
        return   l;

    }

    private boolean judge(int[] nums, int k, int mid) {
       int c =1;
       int min  =nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]-min>k) {
                min =nums[i]; c++;
            }
        }
        return  c<=mid;
    }
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer>  m =new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            m.put(nums[i],i);
        }
        for(int a[] :operations){
            nums[m.get(a[0])] =a[1];
            int i =m.get(a[0]);
            m.remove(a[0]);
            m.put(a[1],i);
        }
        return  nums;

    }
}
