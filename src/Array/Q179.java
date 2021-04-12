package Array;
import  java.util.*;
public class Q179 {
        public String largestNumber(int[] nums) {
            PriorityQueue<String> queue =  new PriorityQueue<>((a,b)->(int)(Long.valueOf(b+a)-Long.valueOf(a+b)));
            for(int a:nums) queue.offer(String.valueOf(a));
            StringBuilder stringBuilder = new StringBuilder();
            while (!queue.isEmpty()) stringBuilder.append(queue.poll());
            return  stringBuilder.toString();
        }

        public static void main(String[] args) {
            String aa = "30";
            String bb  ="34";
            PriorityQueue<String> queue =  new PriorityQueue<>((a,b)->(int)(Long.valueOf(b+a)-Long.valueOf(a+b)));
            queue.offer(aa);
            queue.offer(bb);
            queue.offer("3");

         //   System.out.println(queue);
           // System.out.println((int)(Long.valueOf(b+a)-Long.valueOf(a+b)));
            int c[] = {3,30,34,5,9};
            System.out.println(new Q179().largestNumber(c)) ;
    }
}
