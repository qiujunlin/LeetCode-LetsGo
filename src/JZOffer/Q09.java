package JZOffer;

import java.util.Stack;

public class Q09 {
    class CQueue {
        Stack<Integer> s1 ;
        Stack<Integer> s2;
        public CQueue() {
            s1 = new Stack();
            s2 = new Stack();
        }
        //  4
        //  3 2
        public void appendTail(int value) {
            while(!s2.isEmpty()) s1.push(s2.pop());
            s1.push(value);
        }

        public int deleteHead() {
            while(!s1.isEmpty()) s2.push(s1.pop()) ;
            return s2.pop();
        }
    }

}
