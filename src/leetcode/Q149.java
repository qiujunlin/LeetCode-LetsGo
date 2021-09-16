package leetcode;

import java.util.HashMap;

public class Q149 {
    public int maxPoints(int[][] points) {
        int max =0;
        HashMap<Double,Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            double x1 = points[i][0];
            double y1 = points[i][1];
            for (int j = i+1; j < points.length; j++) {
                double x2 = points[j][0];
                double y2 = points[j][1];
                if(x2==x1) {
                    map.put(Double.MAX_VALUE,map.getOrDefault(Double.MAX_VALUE,0)+1);
                    max =Math.max(Integer.MAX_VALUE,max);
                }else {
                   double k = (y2 - y1) / (x2 - x1);
                   map.put(k,map.getOrDefault(k,0)+1);
                   max =Math.max(max,map.get(k));
                }
                }
        }
        return  max;
    }

    public static void main(String[] args) {
        StringBuffer s=  new StringBuffer();

        char c ='a';
        s.append(c);
        System.out.println(c);
    }
}
