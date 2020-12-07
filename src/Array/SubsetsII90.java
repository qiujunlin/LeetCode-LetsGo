package Array;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/7
 */
public class SubsetsII90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res= new ArrayList();
        LinkedList<Integer> list = new LinkedList();
        Arrays.sort(nums);
        dfs(nums,0,res,list);
        return res;
    }
    void dfs(int []nums,int left,List<List<Integer>> res,LinkedList<Integer> list){
        if(list.size()<=nums.length) {
            res.add(new ArrayList(list));
        }else return;
        for(int i=left;i<nums.length;i++){
            if(i>left&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            dfs(nums,i+1,res,list);
            list.removeLast();
        }
    }
}
