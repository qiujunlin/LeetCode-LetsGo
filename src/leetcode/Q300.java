package leetcode;

import java.util.ArrayList;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(list.size()==0||nums[i]>list.get(list.size()-1)) list.add(nums[i]);
            else{
                int l =0;int r = list.size()-1;
                while (l<r){
                    int mid = (l+r)/2;
                    if(list.get(mid)<nums[i]) l = mid+1;
                    else r =mid;
                }
                list.set(l,nums[i]);
            }
        }
        return  list.size();
    }
}
