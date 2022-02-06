package Contest.week;

import Test.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DW71 {
    public static void main(String[] args) {
        System.out.println("das");

      //  System.out.println("das");
    }
    public int minimumSum(int num) {
         String s = String.valueOf(num);
         char c[] = s.toCharArray();
         int ch[] = new int[4];
        for (int i = 0; i < 4; i++) {
            ch[i] =c[i]-'0';
        }
        Arrays.sort(ch); // 1 2 9
       int i =0;
       while (i<4){
           if(ch[i]!=0) break;
           i++;
       }

       if(i==0){
           return   ch[0]*10+ch[3] +ch[1]*10+ch[2];
       }else if(i==1){
           return  ch[1]*10+ch[2]+ch[3];
       }else if(i==2){
           return  ch[2]+ch[3];
       }else{
           return  ch[3];
       }

    }
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> l1 =new ArrayList<>();
        ArrayList<Integer> l2 =new ArrayList<>();
        ArrayList<Integer> l3 =new ArrayList<>();
        for(int a:nums){
            if(a<pivot) l1.add(a);
            else if(a==pivot)l2.add(a);
            else l3.add(a);
        }
        int res[]=new int[nums.length];
        int index =0;
        for (int i = 0; i < l1.size() ; i++) {
            res[index++] =l1.get(i);
        }
        for (int i = 0; i < l2.size() ; i++) {
            res[index++] =l2.get(i);
        }
        for (int i = 0; i < l3.size() ; i++) {
            res[index++] =l3.get(i);
        }
        return  res;
    }
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        ArrayList<String> l =new ArrayList<>();
        for (int i = 0; i <=99 ; i++) {
            for (int j = 0; j <=99 ; j++) {
                 if(i*60+j==targetSeconds){
                     l.add(i==0?"":String.valueOf(i)+String.valueOf(j));
                 }
            }
        }
        int min =Integer.MAX_VALUE;


        for (int i = 0; i < l.size(); i++) {
            String s = l.get(i);
            int c = 0;
            int index =0;
            while(s.charAt(index)=='0')index++;
            s=s.substring(index,s.length());
            if(s.charAt(0)-'0'==startAt) c=c+pushCost;
            else c=c+pushCost+moveCost;
            for (int k = 1; k <s.length() ; k++) {
                if(s.charAt(k)==s.charAt(k-1)) {
                    c =c+pushCost;
                }else {
                    c=c+pushCost+moveCost;
                }
            }
            min =Math.min(c,min);

        }
        return   min;
    }
    public int minimumTime(String s) {
        int t =0;
        for (int i = 0; i <s.length() ; i++) {
             if(s.charAt(i)=='1') t++;
        }
        int  pre[] = new int[s.length()];
        int index =-1;
        if(s.charAt(0)=='1') index=0;
        for (int i = 1; i < s.length(); i++) {
            pre[i] =index;
            if(s.charAt(i)=='1'){
                index = i;
            }
        }


        int  pre2[] = new int[s.length()];
         index =s.length()-1;
        if(s.charAt(s.length()-1)=='1') index=s.length()-1;
        for (int i = s.length()-2; i >=0; i--) {
            pre2[i] =index;
            if(s.charAt(i)=='1'){
                index = i;
            }

        }
        for (int i = 0; i < pre.length; i++) {
            System.out.print(pre[i] +"");
        }
        System.out.println();
        for (int i = 0; i < pre.length; i++) {
            System.out.print(pre2[i] +"");
        }
        int min =s.length();
        for (int i = 1; i <=s.length()-1; i++) {
            if(s.charAt(i)==1){
                min = Math.min(s.length()-(i-pre[i]-1),min);
                min =Math.min(s.length()-(pre2[i]-i-1),min);
            }
        }
        if(s.charAt(0)=='1')
        min =Math.min(s.length()-(pre2[0]-1),min);
        if(s.charAt(s.length()-1)=='1'){
            min =Math.min(s.length()-1-pre[s.length()-1],min);
        }
        return min;
    }
//"011001111111101001010000001010011"  25






}
