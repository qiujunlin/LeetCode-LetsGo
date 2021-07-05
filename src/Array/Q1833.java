package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        for (int i = 0; i < costs.length; i++) {
            coins-=costs[i];
            if(coins<0) return  i;
            if(coins==0) return  i+1;
        }
        return  costs.length;

    }

    public static void main(String[] args) {
        int x = 121;
        new StringBuffer(x).reverse().toString();
    }
}
