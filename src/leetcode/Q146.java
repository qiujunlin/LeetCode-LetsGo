package leetcode;


import java.math.BigInteger;
import java.util.*;



public class Q146 {

    public static void main(String[] args) {
        System.out.println("");
    }
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer>  set =new HashSet<>();
        for(int a:nums) set.add(a);
        while (set.contains(original)) original =original*2;
        return  original;
    }
    public List<Integer> maxScoreIndices(int[] nums) {
        int l[] = new int[nums.length];
        int r[] = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
             if(nums[i-1]==0) {
                 l[i] = l[i-1]+1;
             }else{
                 l[i] =l[i-1];
             }
        }
        if(nums[nums.length-1]==1) r[nums.length-1] =1;
        for (int i = nums.length-2; i >=0 ; i--) {
            if(nums[i]==1){
                r[i] = r[i+1]+1;
            }else{
                r[i] =r[i+1];
            }
        }
        TreeMap<Integer,ArrayList<Integer>>  map =new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
             int ln = l[i];
             int rn = r[i];
             map.computeIfAbsent(ln+rn,(key)->new ArrayList<>()).add(i);
         }
        if(nums[nums.length-1]==0) {
            map.computeIfAbsent(l[nums.length-1]+1,(key)->new ArrayList<>()).add(nums.length);
        }

        return  map.firstEntry().getValue();


    }
    public String subStrHash1(String s, int power, int modulo, int k, int hashValue) {
          //
   long val =0;
   int i=0;
   long p = 1;
        for ( i = s.length(); i >=s.length()-1 ; i--) {
            val = (val *power+(s.charAt(i)-'a'+1))%modulo;
           p = p*power;
        }
        if(val==hashValue)  return s.substring(s.length()-k,s.length());
        for (; i >=0 ; i--) {
           val = (val * power  +(s.charAt(i)-'a'+1) -(s.charAt(i+k)-'a' +1)*p)%modulo;
           if(val==hashValue) return  s.substring(i,i+k);
        }
        return   "";



    }


}
