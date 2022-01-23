package Contest.week;

import java.util.*;

public class W277 {
    public static void main(String[] args) {
        System.out.println("dsa");
    }
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int c =0;
        for (int i = 1; i < nums.length-1; i++) {
             int n =  nums[i];
             boolean l = false;
             boolean r = false;
            for (int j = i-1; j >=0 ; j--) {
                if(nums[j]<n){
                     l=true;
                     break;
                }
            }
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]>n){
                    r=true;
                    break;
                }
            }
            if(l&r)  c++;

        }
        return  c;

    }
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer>  l1 = new ArrayList<>();
        ArrayList<Integer>  l2 = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]<0){
                l1.add(nums[i]);
            }else{
                l2.add(nums[i]);
            }
        }
        int res[] = new int[nums.length];
        for (int i = 0; i <nums.length/2 ; i++) {
             res[i*2] = l2.get(i);
             res[i*2+1] = l1.get(i);
        }
        return  res;
    }
    public List<Integer> findLonely(int[] nums) {
        ArrayList<Integer>  l1 = new ArrayList<>();
        int ha[] = new int[1000002];
        for (int i = 0; i <nums.length ; i++) {
            ha[nums[i]]++;
        }
        for (int i = 1; i <ha.length-1 ; i++) {
            if(ha[i]==1&&ha[i-1]==0&&ha[i+1]==0) {
                l1.add(i);
            }
        }
        if(ha[0]==1&&ha[1]==0) l1.add(0);
        return  l1;
    }

    public int maximumGood(int[][] statements) {
        int n = statements.length;
       int max  =1;
        int hao[]  = new int[n];
        Arrays.fill(hao,-1);
        for (int i = 0; i <(1<<n); i++) {
            int c  =0;
            boolean is  =true;
            for (int j = 0; j <n ; j++) {
                 if(((i>>j)&1)==1){
                     c++;
                     for (int k = 0; k < statements[i].length ; k++) {
                          if(statements[j][k]==0){
                              if(hao[k]==1)  is=false;
                              hao[k] =1;
                          }else if(statements[j][k]==1){
                              if(hao[k]==0)  is=false;
                              hao[k] =1;
                          }
                     }
                 }else{

                     if(hao[j]==1) is =false;
                     boolean d =true;
                     //zheng
                     for (int k = 0; k < statements[i].length ; k++) {
                         if(statements[j][k]==0){
                             if(hao[k]==1)  d=false;

                         }else if(statements[j][k]==1){
                             if(hao[k]==0)  d=false;
                         }
                     }
                     //jia
                     for (int k = 0; k < statements[i].length ; k++) {
                         if(statements[j][k]==0){
                             if(hao[k]==0)  d=false;

                         }else if(statements[j][k]==1){
                             if(hao[k]==1)  d=false;
                         }
                     }
                     if(!d) is=false;



                 }
                 if(!is) break;
            }
            Arrays.fill(hao,-1);
            if(is) max =Math.max(c,max);
        }
        return  max;

    }



}
