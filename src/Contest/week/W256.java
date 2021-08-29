package Contest.week;

import java.util.*;

public class W256 {
    public static void main(String[] args) {

    }
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res   = Integer.MAX_VALUE;
        for (int i = k-1; i < nums.length; i++) {
            res = Math.min(nums[i]-nums[i-k+1],res);
        }
        return  res;
    }
    public String kthLargestNumber(String[] nums, int k) {
        TreeMap<Integer, List<String>>  map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
             map.computeIfAbsent(nums[i].length(),(key)->new ArrayList<>()).add(nums[i]);
        }
        while (!map.isEmpty()){
            List<String>  list  =  map.get(map.lastKey());
            map.remove(map.lastKey());
            int size  =  list.size();
            if(k-size<=0){
                Collections.sort(list);
                return  list.get(list.size()-(k-size));
            }else{
                k-=size;
            }
        }
        return   "";

    }

}
