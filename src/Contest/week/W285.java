package Contest.week;

import java.util.Arrays;

public class W285 {

    public static void main(String[] args) {

    }
    public int countHillValley(int[] nums) {
        int c =0;
        for (int i = 1; i < nums.length-1; i++) {
             if(nums[i]==nums[i-1]) continue;
             int l  =i;int r =i;
             while (l>0&&nums[l]!=nums[i]) l--;
             while (r>0&&nums[r]!=nums[i]) r++;
             if(l==-1||r==nums.length)continue;
             if(nums[i]>nums[l]&&nums[i]>nums[r]) c++;
             if(nums[i]<nums[l]&&nums[i]<nums[r]) c++;
        }
        return  c;

    }
    public int countCollisions(String directions) {
        int res =0;
        int i =0;
        int j  = directions.length()-1;
        while (i<directions.length()&&directions.charAt(i)=='L') i++;
        while (j>=0&&directions.charAt(j)=='R') j--;
        if(i>=j) return   0;
        boolean vis[] =new boolean[directions.length()];
        for (int k = i; k <=j ; k++) {
             if(k+1<=j&&directions.charAt(k)=='R'&&directions.charAt(k+1)=='L') {
                 res += 2;
                 vis[k] = true;
                 vis[k + 1] = true;
                 k++;
             }
        }
        for (int k = i; k <= j; k++) {
             if(!vis[k]&&directions.charAt(i)!='S') res++;
        }
        return  res;

    }

    /**
     * 89
     * [3,2,28,1,7,1,16,7,3,13,3,5]  [21,3,0,2,8,2,17,8,4,14,4,6]
     * @param numArrows
     * @param aliceArrows
     * @return
     */
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int res[] = new int[12];
        int max  =0;
        for (int i = 0; i < (1<<12); i++) {
            int temp[] = new int[12];
            int total  = numArrows;
            int n = 0;
            for (int j = 11; j >=0 ; j--) {
                 if((i>>j&1)==1) {
                     if(aliceArrows[j]!=0) {
                         total -= aliceArrows[j] + 1;
                         if(total<0) {
                             temp[j] = total;
                             total =0;
                             break;
                         }
                         n += j;
                         temp[j] = aliceArrows[j]+1;
                     }else{
                         total -=1;
                         temp[j] = 1;n+=j;
                         if(total==0) break;
                     }
                 }
            }
            for (int j = 11; j >=0 ; j--) {
                if(total<=0) break;
                if(temp[j]!=0){ n+=j;temp[j]+=total; break;}
            }
            if(n>max) {
                max =n;res=temp;
            }
        }
        return  res;


    }
}
