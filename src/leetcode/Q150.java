package leetcode;

import java.util.*;

/**
 * @Classname Q150
 * @Description:
 * @Date 2021/3/20 0:09
 * @Created by qiujunlin
 */
public class    Q150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(i<=1) stack.push(Integer.valueOf(tokens[i]));
            else{
                String s  = tokens[i];
                if(Character.isDigit(s.charAt(0))){
                    stack.push(Integer.valueOf(s));
                }else if(s.equals("+")){
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2+num1);
                }else  if(s.equals("-")){
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2-num1);
                }else if(s.equals("/")){
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2/num1);
                }else  if(s.equals("*")){
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2*num1);
                }
            }
            return  stack.peek();
        }
return 0;

    }
}
