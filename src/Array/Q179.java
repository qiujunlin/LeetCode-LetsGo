package Array;

//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

/**
 * @Classname Q179
 * @Description:
 * @Date 2021/4/12 0:16
 * @Created by qiujunlin
 */
public class Q179 {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue =  new PriorityQueue<>((a,b)-> (int) (Long.valueOf(a+b)-Long.valueOf(b+a)));
        for(int a:nums) queue.offer(String.valueOf(a));
        StringBuilder stringBuilder = new StringBuilder();
        for(String a : queue) stringBuilder.append(a);
        return  stringBuilder.reverse().toString();
    }
}
