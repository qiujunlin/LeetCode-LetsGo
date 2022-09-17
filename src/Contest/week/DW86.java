package Contest.week;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class DW86 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(255555));
    }
    public boolean findSubarrays(int[] nums) {
        HashMap<Integer, ArrayList<int[]>> map =new HashMap<>();
        for (int i = 0; i <nums.length-1 ; i++) {

                int sum = nums[i] +nums[i+1];
                map.computeIfAbsent(sum,(key)->new ArrayList<>()).add(new int[]{i,i+1});

        }
        for(ArrayList<int[]> a :map.values()){
            if(a.size()>=2){
                System.out.println(a);
                for (int i = 0; i <a.size() ; i++) {
                    for (int j = i+1; j <a.size() ; j++) {
                        int x[] =a.get(i);
                        int y[] =a.get(j);
                        if(x[0]!=y[0]&&x[1]!=y[1]) return  true;
                    }
                }
            }
        }
        return  false;

    }
    public boolean isStrictlyPalindromic(int n) {
        boolean res =false;
        for (int i = 2; i <=n-2 ; i++) {
            String s = Integer.toString(n,i);
            if(!new StringBuilder(s).reverse().equals(s))  {
                res = true;
                break;
            }
        }
        if(res)return false;
        return  true;

    }
    public int maximumRows(int[][] mat, int cols) {
       int m = mat.length;
       int n = mat[0].length;
       int max =0;
        for (int i = 0; i < (1<<n); i++) {
            int c = 0;
            for (int j = 0; j < 12; j++) {
                if (((i >> j) & 1) == 1) c++;
            }
            boolean v[] = new boolean[n];
            if (c == cols) {

                for (int j = 0; j < n; j++) {
                    if (((i >> j) & 1) == 1) {
                        v[j] = true;
                    }
                }
            } else {
                continue;
            }
            int count = 0;
            for (int j = 0; j < m; j++) {
                boolean is = true;
                for (int k = 0; k < n; k++) {
                    if (mat[j][k] == 1) {
                        if (!v[k]) {
                            is = false;
                            break;
                        }
                    }
                }
                if (is) count++;
            }
            max = Math.max(max, count);
        }
        return  max;


    }
    long pre[] ;
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        this.pre =new long[chargeTimes.length+1];
        for (int i = 0; i <chargeTimes.length ; i++) {
            pre[i+1] =runningCosts[i] +pre[i];
        }
        int  l =0;
        int r = chargeTimes.length;
        while (l<r){
            int mid = (l+r+1)/2;
            if(judge(chargeTimes,runningCosts,budget,mid)){
                l =mid;

            }else{
                r =mid-1;
            }
        }
        return  l;

    }

    private boolean judge(int[] chargeTimes, int[] nums, long budget, int k) {


        long sum =0;
        Deque<Integer> queue =new LinkedList();
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            while(!queue.isEmpty()&&queue.peekFirst()<=i-k) queue.pollFirst();
            if(i>=k-1) {
                sum -= nums[i-k];
            }
            if(sum*k + nums[queue.peekFirst()] <=budget)return  true;

        }
        return  false;
    }


}
