package Array;

import edu.princeton.cs.algs4.In;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.util.*;

public class Q752 {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return  0;
        HashSet<String> set  = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
             set.add(deadends[i]);
        }
        if(set.contains("0000")) return  -1;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int count  =1;
        HashSet<String> vis = new HashSet<>();
        vis.add("0000");
        while (!queue.isEmpty()){
            int size  = queue.size();
            for (int i = 0; i < size ; i++) {
                List<String> l = get(queue.poll());
                for (String a : l) {
                    if (a.equals(target)) return count;
                    if (!vis.contains(a)&&!set.contains(a)) {
                        vis.add(a);
                        queue.add(a);
                    }
                }
            }
            count++;
        }
        return  -1;
    }
    private List<String> get(String i) {
        char ch[] = i.toCharArray();
        List<String> list =  new ArrayList<>();
        for (int j = 0; j < 4; j++) {
            char c = ch[j];
            ch[j] = c=='0'?'9':(char)(c-1);
            list.add(new String(ch));
            ch[j] = c=='9'?'0':(char) (c+1);
            list.add(new String(ch));
            ch[j] =c;
        }
        return  list;

    }

    public static void main(String[] args) {
       String s[] = {"0201","0101","0102","1212","2002"}; String target = "0202";
        System.out.println(new Q752().openLock(s,target));
    }
}

