package leetcode;

import edu.princeton.cs.algs4.Stack;

public class Q32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack =  new Stack<>();
        int res =0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                   res =Math.max(i,res);
                }else{
                    if(s.charAt(stack.peek())=='('){
                        stack.pop();
                        if(stack.isEmpty()){
                            res  =Math.max(res,i);
                        }else{
                            res =Math.max(res,i-stack.peek());
                        }
                    }else{
                        res = Math.max(res,i-stack.peek());
                    }
                }
            }
        }
        return  res;
    }
}
