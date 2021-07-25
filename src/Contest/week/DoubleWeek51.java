package Contest.week;

import java.util.*;

/**
 * @Classname DoubleWeek51
 * @Description:
 * @Date 2021/5/1 22:17
 * @Created by qiujunlin
 */
public class DoubleWeek51 {
    public static void main(String[] args) {

    }
    public String replaceDigits(String s) {
       StringBuilder stringBuilder = new StringBuilder();
       for(int i=0;i<s.length();i++){
           if(i%2==0) stringBuilder.append(s.charAt(i));
           else{
               int a= s.charAt(i)-'a';
               char c=s.charAt(i-1);
               char res = (char)(c+a);
               stringBuilder.append(res);
           }
       }
       return  stringBuilder.toString();
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        PriorityQueue<Integer> queue =new PriorityQueue<>();
        for(int a:arr)queue.offer(a);
        int count =0;
        int a=queue.poll();
        if(a!=1) {
            count++;a=1;
        }
        while (!queue.isEmpty()){
            int temp=queue.poll();
            if(temp-a>1) {
                count++;
                a=temp;
            }
        }
        return  count;
    }
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Arrays.sort(rooms,(a,b)->a[1]-b[1]);
        int len = rooms.length;
        int res[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int []query =queries[i];
            int index = get(rooms,query[0]);
            int right=index;
            int left =index-1;
            while (true){
                int min=0;
                if(right>len-1) min=left;
                else if(left<0) min=right;
                else if((Math.abs(rooms[right][0]-query[0])>Math.abs(rooms[left][0]-query[0]))){
                    min=left;
                }else{
                    min=right;
                }
                if(rooms[min][0]>=query[1]){
                    res[i]=query[0];
                    break;
                }
            }
        }
        return res;
    }

    private int get(int[][] rooms, int query) {
      int left =0;
      int right =rooms.length-1;
      while (left<right){
          int mid =(left+right)/2;
          if(rooms[mid][0]<query){
              left=mid+1;
          }else{
              right=mid;
          }
      }
      return  left;
    }



}
