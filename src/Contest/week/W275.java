package Contest.week;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class W275 {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer>  map =new HashMap<>();
        for(String s : words)map.put(s,map.getOrDefault(s,0)+1);
        int res =0; boolean hass =false;

        for(String s : map.keySet()){
            int c =  map.get(s);
             if(s.charAt(0)==s.charAt(1)){
                 if(c%2!=0) hass =true;
                 res += c/2 *2;
             }
             String s1 = new StringBuilder(s).reverse().toString();
             int c1 =map.get(s1);
             res += Math.min(c,c1)*2;

        }
        return hass?res/2+1:res/2;
    }
    public boolean checkValid(int[][] matrix) {
        //int m =matrix.length;
        int n =matrix[0].length;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(matrix[i][j]);
            }
            for (int j = 1; j <=n ; j++) {
                 if(!set.contains(j)) return  false;
            }
        }
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(matrix[j][i]);
            }
            for (int j = 1; j <=n ; j++) {
                if(!set.contains(j)) return  false;
            }
        }
        return true;

    }
    //[1,0,1,1,1,0,0,0,1,0,0,1,1,1,0,0,1,1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0] 7
    public int minSwaps(int[] numss) {
        int c =  0;
        for (int i = 0; i <numss.length ; i++) {
            if(numss[i]==1) c++;
        }
        int nums[] =  new int[numss.length*2];
        for (int i = numss.length-1; i <nums.length ; i++) {
            nums[i] = numss[i-nums.length-1];
        }
        for (int i = 0; i <numss.length ; i++) {
            nums[i] = numss[i];
        }
        int c2 =0;
        int res =Integer.MAX_VALUE;
        for (int i = 0; i <nums.length; i++) {
             if(i<c) {
                 c2++;
                 if(i==c-1){
                     res =Math.min(c-c2,res);
                 }
             }
             else {
                 if (nums[i]==1){
                     c2++;
                 }
                 if(nums[i-c]==1) c2--;
                 res =Math.min(c-c2,res);
             }
        }
        return  0;





    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        int res =0;
        for (int i = 0; i <plantTime.length ; i++) {
            res+=plantTime[i];
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[0]+a[1])==(b[0]+b[1])?a[1]-b[1]:(a[0]+a[1])-(b[0]+b[1]));
        for (int i = 0; i <plantTime.length ; i++) {
            q.offer(new int[]{plantTime[i],growTime[i]});
        }
        int s =0;
        while (!q.isEmpty()){
            int a[]=q.poll();
            s+=a[0];
            res=Math.max(s+a[1],res);

        }
        return  res;


    }
    public int wordCount(String[] startWords, String[] targetWords) {
        //
        int res =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(String s : targetWords){
            int a =0;
            for (int i = 0; i <s.length() ; i++) {
                 a|=(1<<(s.charAt(i)-'a'));
            }
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(String s : startWords){
            int a =0;
            for (int i = 0; i <s.length() ; i++) {
                a|=(1<<(s.charAt(i)-'a'));
            }
            for (int i = 0; i <26 ; i++) {
                if((a&(1<<i))==0){
                    int c = a|(1<<i);
                    if(map.containsKey(c)){
                        res++;
                        map.put(c,map.get(c)-1);
                        if(map.get(c)==0) map.remove(c);
                    }
                }
            }

        }
        return  res;

    }
}
