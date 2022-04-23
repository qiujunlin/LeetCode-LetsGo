package Test;


import java.util.ArrayList;
import java.util.TreeMap;

public class Main2   {
    public static void main(String[] args)  {
        System.out.println("fds");

    }
    public int giveGem(int[] gem, int[][] operations) {
        for(int a[]:operations){
             gem[a[1]] += gem[a[0]/2];
             gem[a[0]]/=2;
        }
        int min = gem[0];
        int max = gem[0];
        for(int a:gem){
            min =Math.min(min,a);
            max =Math.min(max,a);
        }
        return  max-min;
    }
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int len =cookbooks.length;
        int min = -1;
        for (int i = 0; i < (1<<len); i++) {
            int a =0;//暴富
            int b =0;//美味
            int temp[] = new int[5];

            out:for (int j = 0; j <8 ; j++) {
                 if((i>>j&1)==1) {
                     int t[] =cookbooks[j];
                     for (int k = 0; k <t.length ; k++) {
                         if(temp[k]+t[k]>materials[k]) {
                             break out;
                         }
                     }
                 }
                 a+=attribute[j][1];
                 b+=attribute[j][0];
            }
            if(a>=limit) {
                min =Math.max(min,b);
            }
        }
        return  min;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


  
}

