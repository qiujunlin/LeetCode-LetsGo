package Contest.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class W273 {
    public static void main(String[] args) {
        System.out.println("Dsad");
    }
    public boolean isSameAfterReversals(int num) {
           if(num>=0&&num<=9) return  true;
        return  new StringBuilder(String.valueOf(num)).reverse().charAt(0)=='0';
    }
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int res[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
             int a   =judge(startPos,n,s.substring(i,s.length()));
             res[i]=a;
        }
        return  res;

    }

    private int judge(int[] startPos, int n, String substring) {
        int x= startPos[0];
        int y  =startPos[1];
        for (int i = 0; i < substring.length(); i++) {
             char c =substring.charAt(i);
             if(c=='L'){
                  y--;
                  if(y<0) return  i;
             }else if(c=='R'){
                 y++;
                 if(y>=n) return i;
             }else if(c=='U'){
                 x--;
                 if(x<0) return  i;
             }else{
                 x++;
                 if(x>=n)return  i;
             }
        }
        return  substring.length();
    }
    public long[] getDistances(int[] arr) {
         long res[] = new long[arr.length];
        HashMap<Integer, ArrayList<Integer>> map =new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
           ArrayList<Integer> l =  map.computeIfAbsent(arr[i],(key)->new ArrayList<>());
            l.add( i);
        }
        HashMap<Integer, ArrayList<Integer>> pre =new HashMap<>();
        for(int a:map.keySet()){
            ArrayList<Integer> l =new ArrayList<>();
            long [] p= new long[l.size()+1];
            p[1] =0;
            for (int i = 1; i <l.size() ; i++) {
                 p[i+1] =p[i] +l.get(i)-l.get(i-1);
            }
            long [] p2= new long[l.size()+1];
            p2[p2.length-1] =0;
            for (int i = l.size()-1; i >=0 ; i--) {
                p2[i] =p2[i+1] +l.get(i)-l.get(i+1);
            }
            for (int i = 0; i <l.size() ; i++) {
                 res[l.get(i)] = p[i] + p2[i];
            }
        }
        return  res;


    }
    /*
    [11,6,3,4,8,7,8,7,9,8,9,10,10,2,1,9] [2,3,7,8,8,9,9,10]
     */
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            ArrayList<Integer> l =new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int k = nums[i]-nums[0];
            if(k>0&&k%2!=1)
            l.add(k/2);
        }

        for(int k: l){

            int res[] = new int[nums.length/2];
            int index =0;
            HashMap<Integer,Integer> m =new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                if(map.containsKey(n)){
                    map.put(n,map.get(n)-1);
                    if(map.get(n)==0) map.remove(n);
                }else{
                    if(index==res.length) {index=0;break;}
                     res[index++] = n;
                     map.put(n+k,map.getOrDefault(n+k,0)+1);
                }
            }
            if(index==res.length) return  res;
        }
        return null;




    }
    public String firstPalindrome(String[] words) {
        for(String  s : words){
            if(s.equals(new StringBuffer(s).reverse().toString())) return  s;
        }
        return  "";

    }




}
