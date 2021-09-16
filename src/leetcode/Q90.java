package leetcode;

import java.util.*;

/**
 * @Classname Q90
 * @Description:
 * @Date 2021/3/31 0:06
 * @Created by qiujunlin
 */
public class Q90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(res,list,0,nums);
        return  res;
    }
    void dfs( List<List<Integer>> res,List<Integer> list,int left,int nums[]){
        if(left==nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int i=left;i<nums.length;i++){
            if(i>left&&nums[i]==nums[i-1]) continue;
            else {
                list.add(nums[i]);
                dfs(res,list,left+1,nums);
            }
        }

    }
}
