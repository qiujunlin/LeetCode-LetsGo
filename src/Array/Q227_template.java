package Array;

import java.util.HashMap;
import java.util.Stack;

public class Q227_template {
    HashMap<Character ,Integer> map = new HashMap(){{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};
    public int calculate(String s) {
        /** 1.遍历每一个字
         *    1.1 如果是右括号 加入
         *    1。2 如歌是左括号  计算，直到右括号出来
         *    1.3 如果是数字 取出数字 加入
         *    1.4 如果是符号
         *      1.4.1 判断优先 如果优先级低 直接计算 如果是就计算 如果不是就
         *
         */
        s = s.replaceAll(" ","");
        s = s.replaceAll("\\(-", "(0-");
        s = s.replaceAll("\\(\\+", "(0+");
        s = s.replaceAll("--", "+");
        s = s.replaceAll("\\+-", "-");
        s = s.replaceAll("-\\+", "-");
        char ch[] =s.toCharArray();
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        nums.push(0);
        for(int i=0;i<s.length();i++){
            char c  = ch[i];
            if(c==  '('){
                ops.push(c);
            }else if(c==')'){
                while (!ops.isEmpty()){
                    if(ops.peek()!='('){
                        cal(nums,ops);
                    }else{
                        ops.pop();
                        break;
                    }
                }
            }else if(Character.isDigit(c)){
                int num = 0;
                while(i<s.length()&&Character.isDigit(ch[i])){
                    num = num*10 + ch[i]-'0';
                    i++;
                }
                nums.add(num);
                i--;
            }else {
                while (!ops.isEmpty()&&ops.peek()!='('){
                    char pre = ops.peek();
                    if(map.get(pre)>=map.get(c)){
                        cal(nums,ops)  ;
                    }else {
                        break;
                    }
                }
                ops.push(c);
            }
        }
        // 将剩余的计算完
        while (!ops.isEmpty()) cal(nums, ops);
        return nums.peek();
    }

    private void cal(Stack<Integer> nums, Stack<Character> ops) {
        if(nums.size()<2) return;
        char op = ops.pop();
        int  b = nums.pop();
        int a  =nums.pop();
        int ans = 0;
        if(op=='+') ans = a+b;
        else if(op=='-') ans = a-b;
        else if(op=='*') ans = a*b;
        else if(op == '/') ans  = a / b;
        else if(op == '^') ans  =  a^b;
        else if(op=='%') ans  = a%b;
        nums.push(ans);
    }

    public static void main(String[] args) {
        System.out.println(new Q227_template().calculate(
                "2-4-(8+2-6+(8+4-(1)+8-10))"));
        String s = "+-";
    }
}
