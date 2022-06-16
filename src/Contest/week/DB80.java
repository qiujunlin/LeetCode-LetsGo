package Contest.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class DB80 {
    public static void main(String[] args) {
        System.out.println("Das");
    }
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8) return  false;

        boolean  a =false;
        boolean b =false;
        boolean d =false;
        boolean e =false;
        boolean f =true;


        for(char c:password.toCharArray()){
            if(c>='a'&&c<'z') a=true;
            if(c>='A'&&c<='Z') b=true;
            if(c>='0'&&c<='9') d=true;
            String s ="!@#$%^&*()-+";
            for(char h:s.toCharArray()) if(c==h) f=true;

        }
        System.out.println(d);
        for (int i = 1; i <password.length() ; i++) {
            if(password.charAt(i)==password.charAt(i-1)) f=false;
        }
        if(a==false||b==false||d==false||e==false)return  false;
        if(f==false) return  false;
        return  true;

    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int res[] =new int[spells.length];
        for (int i = 0; i <spells.length ; i++) {
             int n =spells[i];
             int l =0;
             int r= potions.length-1;
             while (l<r){
                 int mid =(l+r+1)/2;
                 if(n*potions[mid]>=success){
                     l =mid;
                 }else{
                     r=mid-1;
                 }
             }
             res[i] =  potions[l]*n>=success?(potions.length-l+1):0;
        }
        return  res;

    }

    public boolean matchReplacement(String s, String sub, char[][] mappings) {

        HashMap<Character,HashSet<Character>>  map =new HashMap<>();
        for(char ch[]:mappings){
            map.computeIfAbsent(ch[0],(key)->new HashSet<>()).add(ch[1]);
        }
        for (int i = 0; i <s.length() ; i++) {
            boolean is =true;
            if(s.length()-i<sub.length()) break;
            for (int j = i; j <i+sub.length()-1 ; j++) {
                char c =s.charAt(j);char c2 = sub.charAt(j-i);
                if(c==c2)continue;
                if(map.get(c2)==null||!map.get(c2).contains(c))  {
                    is=false;
                    break;
                }
            }
            if(is) return  true;
        }
        return  false;
    }

    /**
     * [4,3,5]
     * 11
     * 3
     * @param nums
     * @param k
     * @return
     */
    public long countSubarrays(int[] nums, long k) {
        long  sum  =0;
        long res =0;
        int l=0;
        for (int i = 0; i <nums.length ; i++) {
             sum = sum +nums[i];
             while (l<i&&sum*i>k){
                 sum -=nums[l];
                 l++;
             }
             res += (i-l+1);

        }
        return  res;
    }
}
