package Contest.week;

import java.util.Arrays;
import java.util.HashSet;

public class DB87 {
    public static void main(String[] args) {
        System.out.println("dahsda");

    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arr[] ={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
          int startm  = Integer.valueOf(arriveAlice.substring(0,2));
          int startd  = Integer.valueOf(arriveAlice.substring(3,5));
          int endm  = Integer.valueOf(leaveAlice.substring(0,2));
          int endd  = Integer.valueOf(leaveAlice.substring(3,5));
        HashSet<String>  set =new HashSet<>();
        for (int i = startm; i <=endm ; i++) {
             int start = 0;
             int end = arr[endd-1];
             if(i==startm)  start=startd;
             if(i==endm)  end=endd ;
            for (int j = start; j <=end ; j++) {
                set.add(String.valueOf(i) +"-"+String.valueOf(j));
            }
        }
         startm  = Integer.valueOf(arriveBob.substring(0,2));
         startd  = Integer.valueOf(arriveBob.substring(3,5));
         endm  = Integer.valueOf(leaveBob.substring(3,5));
         endd  = Integer.valueOf(leaveBob.substring(3,5));
      int res =0;
        System.out.println(set);
        for (int i = startm; i <=endm ; i++) {
            int start = 0;
            int end = arr[endd-1];
            if(i==startm)  start=startd;
            if(i==endm)  end=endd ;
            for (int j = start; j <=end ; j++) {
                String s = String.valueOf(i) +"-"+String.valueOf(j);
                if(set.contains(s)) res++;
            }
        }
        return  res;

    }
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i =0;
        int  j =0;

        while (i<players.length){
            while (j<trainers.length&&trainers[j]>players[i]) j++;
            if(j<trainers.length) {
                i++; j++;
            }
            else  break;
        }
        return   i;
    }
    public int[] smallestSubarrays(int[] nums) {
     int n = 0;
     for(int a :nums)  n|=a;
     int dp[][]  =new int[31][nums.length];
        for (int i = 0; i <31 ; i++) {
            int pre = -1;
            for (int j = nums.length-1; j >=0; j--) {
                if((nums[j]>>i&1)==1) pre = j;
                dp[i][j] = pre;
            }
        }
        int res[] =new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            int max =1;
            for (int j = 0; j <31 ; j++) {
                 max =Math.max(max,dp[i][j]-j+1);
            }
            res[i] =max;
        }
        return  res;

    }
}
