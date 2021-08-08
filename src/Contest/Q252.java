package Contest;
import  java.util.*;
public class Q252 {
    public static void main(String[] args) {
new     Q252().minimumPerimeter(3213131232131L);
    }
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        long sum  =0;
        for (int i = 0; i < milestones.length-1; i++) {
            sum+=milestones[i];
        }

        int len  = milestones.length;
        if(milestones[len-1]-sum>1){
            return  sum + sum+1;
        }else return  sum+milestones[len-1];
    }
    public long minimumPerimeter(long neededApples) {
        long dp[] = new long[100];
        for (int i = 1; i < 100; i++) {
            dp[i] = (i+i)*4+dp[i-1];
            System.out.println(dp[i]);
        }
        return  0L;
    }

}
