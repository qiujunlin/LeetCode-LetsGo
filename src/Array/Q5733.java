package Array;

import java.util.*;

/**
 * @Classname Q5733
 * @Description:
 * @Date 2021/5/2 23:35
 * @Created by qiujunlin
 */
public class    Q5733 {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int q[][]=  new int[queries.length][3];
        for(int i=0;i<queries.length;i++){
            q[i][0] =queries[i][0];
            q[i][1] =queries[i][1];
            q[i][2]=i;
        }
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.sort(rooms,(a,b)->b[1]-a[1]);
        Arrays.sort(q,(a,b)->b[1]-a[1]);
        int res[]= new int[queries.length];
        int index=0;
        for(int i=0;i<queries.length;i++){
            int area =queries[i][1];
            int id =queries[i][0];
            while (index<rooms.length&&rooms[index][1]>=area){
                set.add(rooms[index][0]);
                index++;
            }
            Integer a=set.floor(area);
            Integer b=set.ceiling(area);
            int d = queries[i][2];
            if(a==null&&b==null) res[d]=-1;
            else if(a==null){
                res[d] = b;
            }else if(b==null){
                res[d]=a;
            }else{
                if(id-a<=b-id) res[d] = a;
                else res[d]=b;
            }

        }
        return  res;
    }
}
