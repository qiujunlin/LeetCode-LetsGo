package Array;

import java.util.*;

/**
 * @Classname Q480
 * @Description:
 * @Date 2021/2/21 23:54
 * @Created by qiujunlin
 */
public class    Q480 {
    public static void main(String[] args) {
         TreeSet<int[]> set1 = new TreeSet<>((o1,o2)->o1[0]-o2[0]);
//         set.add(new int[]{3,4});
//         set.add(new int[]{1,2});
//         set.add(new int[]{1,2});
//         //set.remove(new int[]{1,2});
//         System.out.println(set);
//        PriorityQueue<int[]>  queue= new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
//        queue.offer((new int[]{1,2}));
//        queue.offer(new int[]{3,4});
//        queue.remove(new int[]{1,2});
//        System.out.println(queue);
        HashSet<int[]> set = new HashSet();
        set.add(new int[]{3,4});
        set.add(new int[]{1,2});
        System.out.println(set);
        set.remove(new int[]{1,2});
        System.out.println(set);
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
         TreeSet<int[]>  set = new TreeSet<>((o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
         double res[] = new double[nums.length-k+1];
         for(int i=0;i<k;i++) set.add(new int[]{nums[i],i});
         int index=0;
         for(int i=k;i<nums.length;i++){
             res[index++] = findmid(k,set);
             set.add(new int[]{nums[i],i});
             set.remove(new int[]{nums[i-k],i-k});
         }
         res[res.length-1] =findmid(k,set);
         return  res;
    }
    double findmid(int k,TreeSet<int[]> set){
        int mid = (k-1)/2;
        Iterator<int[]> iter = set.iterator();
        while (mid>0){
            iter.next();
            mid--;
        }
        return  k%2==0?((iter.next())[0]+iter.next()[0])/2.0:iter.next()[0];
    }
   /* public double[] medianSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n-k+1];
        Set<int[]> set = new TreeSet<>((a, b)->a[0]==b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for(int i=0; i<k; i++) set.add(new int[]{nums[i], i});
        for(int i=k, j=0; i<n; i++, j++){
            ans[j] = findMid(set);
            set.add(new int[]{nums[i], i});
            set.remove(new int[]{nums[i-k], i-k});
        }
        ans[n-k] = findMid(set);
        return ans;
    }*/

    /*double findMid(Set<int[]> set){
        int mid = (set.size() - 1) / 2;
        var it = set.iterator();
        while(mid-->0) it.next();
        return set.size()%2 == 0 ? ((double)it.next()[0] + it.next()[0]) / 2 : it.next()[0];
    }*/
}
