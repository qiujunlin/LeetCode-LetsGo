package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Q354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        ArrayList<Integer> list =new ArrayList<>();
        for (int i = 0; i <envelopes.length ; i++) {
            if(list.size()==0||envelopes[i][1]>list.get(list.size()-1)) list.add(envelopes[i][1]);
            else {
                int l =0;int r = list.size()-1;
                while (l<r){
                    int mid =(l+r)/2;
                    if(list.get(mid)<envelopes[i][1]) l = mid+1;
                    else r =mid;
                }
                list.set(l,envelopes[i][1]);
            }


        }
        return  envelopes.length;

    }
}
