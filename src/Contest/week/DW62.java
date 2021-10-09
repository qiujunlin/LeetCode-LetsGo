package Contest.week;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class DW62 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length) return  new int[0][0];
        int res[][] = new int[m][n];
        int index  =0;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                res[i][j] = original[index++];
            }
        }
        return  res;

    }
    public int numOfPairs(String[] nums, String target) {
        int res =0;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums.length ; j++) {
                 if(i==j) continue;
                 if(target.equals(nums[i]+nums[j])) res++;
            }
        }
        return  res;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int a = getmax(answerKey,k,'F');
        int b = getmax(answerKey,k,'T');
        return   Math.max(a,b);

    }

    private int getmax(String answerKey, int k,char c) {
        int l =0;
        int max =0;
        int chaneg =0;
        for (int i = 0; i < answerKey.length(); i++) {
            if(answerKey.charAt(i)==c){
                chaneg++;
            }
            while (chaneg>k){
                if(answerKey.charAt(l)==c){
                    chaneg--;
                    break;
                }
            }
            max = Math.max(i-l+1,max);
        }
        return  max;
    }

    public int waysToPartition(int[] nums, int k) {
        int a = get(nums,k);
        int rev[] = new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            rev[i] = nums[nums.length-1-i];
        }
        int b  = get(rev,k);
        return a+b;
    }

    private int get(int[] nums, int k) {
        int presum[]=  new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            presum[i+1] = presum[i] +  nums[i];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);
        int len = nums.length;
        int res =0;
        for (int i = 1; i <nums.length-1 ; i++) {
            int sum1 =  presum[i];// 左边的和
            int sum2 =  presum[len]-sum1; // 右边的和
            int cha =  Math.abs(sum2-sum1);
            if(sum1==sum2&&k==0) res+=i;
            if(sum1>sum2){
                //  将a 变为啊 有可能由小变大
                // 将一个大的数字变小
                // 1. 将一个大于k的数字变k
                if(map.containsKey(k+cha)){
                    res+=map.get(k+cha);
                }
            }else{
                // 将一个小的数字变大
                //讲一个小于k的数字变为k
                if(map.containsKey(k-cha)){
                    map.get(k-cha);
                }

            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return  res;
    }


}
