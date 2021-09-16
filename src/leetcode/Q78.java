package leetcode;

import java.util.*;

/**
 * @Classname Q78
 * @Description:
 * @Date 2021/2/26 14:52
 * @Created by qiujunlin
 */
public class Q78 {
    public static void main(String[] args) {
        ArrayList<Integer> lsit = new ArrayList<>();

        int nums[] ={1,2,3};
        int a[] = Arrays.copyOfRange(nums,1,nums.length);
        System.out.println(new Q78().subsets2(nums));
    }
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList<>());
        for(int a : nums){
            List<List<Integer>> list = new ArrayList<>();
            for(List<Integer> list1:res){
                ArrayList<Integer> newarraylist = new ArrayList<>(list1);
                newarraylist.add(a);
                list.add(newarraylist);
            }
            res.addAll(list);
        }
        return res;

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) list.add(j);
            }
            res.add(list);
        }
        return res;

    }
}
