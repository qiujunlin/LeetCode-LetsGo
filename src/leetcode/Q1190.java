package leetcode;

import java.util.Stack;

public class Q1190 {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack  = new Stack();
        char ch[] =  s.toCharArray();
        StringBuilder str =  new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                stack.push(str);
            }else if(ch[i]==')'){
                str = str.reverse();
                str.append(stack.pop());
            }else{
                str.append(ch[i]);
            }
        }
        return  str.toString();
    }
}
