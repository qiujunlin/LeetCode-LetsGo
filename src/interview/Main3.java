package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Main3 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        long res =0;
        long t =1;
        int mod  = 1000000007;
        HashMap<Long,Integer>  map =new HashMap<>();
        dfs(map,nums,t,0);
        for(Long a: map.keySet()){
            if(a==0||a==1)continue;
            res = (getZhi(a).size()*map.get(a)%mod+res)%mod;
        }
        System.out.println(res);
    }
    private static void dfs(HashMap<Long, Integer> map, int[] nums, long t,int i) {
        if(i==nums.length){
            map.put(t,map.getOrDefault(t,0)+1);
            return;
        }
        dfs(map,nums,t*nums[i],i+1);
        dfs(map,nums,t,i+1);
    }
    private static HashSet<Long> getZhi(long num) {
        HashSet<Long> set = new HashSet<>();
        for (long i = 2; i <=num ; i++) {
            while (i!=num){
                if(num%i==0){ set.add(i);
                    num=num/i;
                }else{
                    break;
                }
            }
        }
        set.add(num);
        return set;
    }
}
