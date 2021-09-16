package leetcode;

import java.util.*;

/**
 * @Classname Q155
 * @Description:
 * @Date 2021/2/21 23:00
 * @Created by qiujunlin
 */
public class Q155 {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> min;

    public Q155() {
       stack =  new Stack<>();
       min =  new Stack<>();
    }

    public void push(int x) {
        if(min.isEmpty()||min.peek()>x) min.push(x);
        stack.push(x);
    }

    public void pop() {
        if(stack.peek()==min.peek()) min.pop();
        stack.pop();

    }

    public int top() {
       return  stack.peek();
    }

    public int getMin() {
     return  min.peek();
    }
}
