package Array;

import java.util.*;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/24
 */
public class Candy135 {
    public int candy(int[] ratings) {
        int left[] = new int[ratings.length];
        Arrays.fill(left,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) left[i]+=left[i-1];
            else left[i] = 1;
        }
        int right=1,res=0;
        for(int i=ratings.length-1;i>=0;i--){
            if(i<ratings.length-1&&ratings[i]>ratings[i+1]) right++;
            else right=1;
            res+=Math.max(right,left[i]);
        }
        return res;
    }
}
