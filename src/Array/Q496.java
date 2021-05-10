package Array;

import java.util.*;

/**
 * @Classname Q496
 * @Description:
 * @Date 2021/5/10 21:22
 * @Created by qiujunlin
 */
public class Q496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
          int res[] = new int[nums1.length];
          HashMap<Integer,Integer> map = new HashMap<>();
          Deque<Integer> deque = new LinkedList<>();
          for(int i=0;i<nums2.length;i++){
              while (deque.isEmpty()||nums2[deque.peekLast()]<nums2[i]){
                  map.put(nums2[deque.pollLast()],nums2[i]);
              }
              deque.add(i);
          }
          for(int i=0;i<nums1.length;i++){
              res[i] = map.get(nums1[i]);
          }
          return  res;
    }
}
