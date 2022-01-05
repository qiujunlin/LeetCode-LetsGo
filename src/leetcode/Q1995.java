package leetcode;

import java.util.*;

public class Q1995 {
    public int countQuadruplets(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res =0;
        for (int c = 0; c <nums.length-1 ; c++) {
            map.put(nums[c+1],map.getOrDefault(nums[c+1],0)+1);
            for (int a = 0; a <c ; a++) {
                for (int b = 0; b < c; b++) {
                   res+=map.getOrDefault(nums[a]+nums[b]+nums[c],0)+1 ;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println( );
    }
    public String largestNumber(int[] nums) {
        // 最大整数 9
        ArrayList<String> l = new ArrayList<>();
        for(int a : nums) l.add(String.valueOf(a));
         Collections.sort(l, new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return  (o1+o2).compareTo(o2+o1);
             }
         });
        StringBuilder s = new StringBuilder();
        for(int num : nums) s.append(num);
        return s.toString();

    }
    public int numberOfBeams(String[] bank) {
        int  count=0;
        int pre  =0;
        int res  =0;
        for (int i = 0; i <bank.length ; i++) {
            int a  =0;
            for (int j = 0; j <bank[i].length() ; j++) {
                 if(bank[i].charAt(j)=='1') a++;
            }

            res += a*count;

            if(a!=0){
                count = a;
                pre =a;
            }
        }
        return res;

    }
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long a  = mass;
        Arrays.sort(asteroids);
        for (int i = 0; i <asteroids.length ; i++) {
            if(a>asteroids[i]) a+=asteroids[i];
            else return  false;
        }
        return true;

    }
}
