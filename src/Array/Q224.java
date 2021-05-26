package Array;

import java.util.*;

/**
 * @Classname Q224
 * @Description:
 * @Date 2021/5/26 15:09
 * @Created by qiujunlin
 */
public class Q224 {
    public int calculate(String s) {
        char ch[] = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int sign = 1;
        int res = 0;
        while (i < s.length()) {
            if (ch[i] == ' ') {
                i++;
            } else if (ch[i] == '(') {
                stack.push(sign);
                i++;
            } else if (ch[i] == ')') {
                stack.pop();
                i++;
            } else if (ch[i] == '+') {
                sign = stack.peek();
            } else if (ch[i] == '-') {
                sign = -stack.peek();
                i++;
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(ch[i])) {
                    num = num * 10 + ch[i] - '0';
                    i++;
                }
                res += sign * num;
            }
        }
        return res;

    }
}
