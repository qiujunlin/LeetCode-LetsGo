package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Q402 {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k) return  "0";
        char ch[] = num.toCharArray();
        Deque<Integer> deque = new LinkedList<>();
        int count =0;
        HashSet<Integer> se  = new HashSet<>();
        for(int i=0;i<num.length();i++){
            while (!deque.isEmpty()&&ch[deque.peekLast()]>ch[i]){
                se.add(deque.pollFirst());
                count++;
                if (count==k) break;
            }
            if (count==k) break;
            deque.addLast(i);
        }
        while (count<k){
            se.add(deque.pollLast());
            count++;
        }
        StringBuffer s  = new StringBuffer();
        for(int  i=0;i<num.length();i++){
            if(!se.contains(i)){
                s.append(ch[i]);
            }
        }
        int i=0;
        while (i<s.length()-1&&s.charAt(i)=='0') i++;

        return  s.substring(i,s.length()).toString();
    }
}
