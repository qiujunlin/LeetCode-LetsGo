package dp;

import java.util.*;

/**
 * @Classname Triangle120
 * @Description:
 * @Date 2020/11/29 11:17
 * @Created by qiujunlin
 */
public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer>   list = new ArrayList<>();
        list.add(triangle.get(0).get(0));

        for(int i=1;i<triangle.size();i++){
            List<Integer> temp= new ArrayList<>();
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0) temp.add(triangle.get(i).get(j)+list.get(j));
                else if(j==triangle.get(i).size()-1) temp.add(triangle.get(i).get(j)+list.get(j-1));
                else temp.add(triangle.get(i).get(j)+Math.min(list.get(j),list.get(j-1)));
            }
            list=temp;
        }

        Collections.sort(list);
        return list.get(0);
    }
    public int minimumTotal2(List<List<Integer>> triangle) {
        int a[][] = new int[triangle.size()][triangle.size()];
        a[0][0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            // List<Integer> temp= new ArrayList<>();
            a[i][0]=triangle.get(i).get(0)+a[i-1][0];
            for(int j=1;j<triangle.get(i).size();j++){
                a[i][j]=Math.min(a[i-1][j],a[i-1][j-1])+triangle.get(i).get(j);
            }
            a[i][i]=a[i-1][i-1]+triangle.get(i).get(i);
        }
        Arrays.sort(a[triangle.size()-1]);
        return a[triangle.size()-1][0];
    }

}
