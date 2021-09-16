package leetcode;

import java.util.*;

/**
 * @Classname Q264
 * @Description:
 * @Date 2021/4/10 0:33
 * @Created by qiujunlin
 */
public class Q264 {
    int nums[] ={2,3,5};
    public int nthUglyNumber2(int n) {
        HashSet<Integer> set  = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        set.add(1);
        n--;
        int a = 1;
        while (n>0){
            for(int i=0;i<3;i++){
                int res = queue.poll();
                if(!set.contains(res*nums[i])){
                    a = res*nums[i];
                    set.add(res*nums[i]);
                    queue.offer(res&nums[i]);
                }
            }
            n--;
        }
        return  a;

    }
    public int nthUglyNumber(int n) {
        TreeSet<Integer> list = new TreeSet<>();
        dfs(list,1,1);
        int res =0;
        while (n>0) {
            res = list.pollFirst();
        n--;
        }
        return  res;
    }
   void dfs(TreeSet<Integer> list,int num,int count){
        if(count==10) return;
        list.add(num);
        for(int i=0;i<3;i++){
            dfs(list,num*nums[i],count+1);
        }
    }

    public static void main(String[] args) {

        System.out.println(new Q264().nthUglyNumber(10));
    }
}
