package Array;

import java.util.*;

/**
 * @Classname Q227
 * @Description:
 * @Date 2021/5/26 15:35
 * @Created by qiujunlin
 */
public class Q227 {
    public int calculate(String s) {
         char ch[] = s.toCharArray();
         int i =0;
         Stack<Integer> stack = new Stack<>();
         int pre=1;
         while (i<s.length()){
             if(ch[i]==' '){
                 i++;
             }else if(ch[i]=='+'){
                 pre=1;i++;
             }else if(ch[i]=='-'){
                 pre=2;i++;
             }else if(ch[i]=='*'){
                 pre=3;i++;
             }else if(ch[i]=='/'){
                 pre=4;i++;
             }else {
                 int num =0;
                 while (i<s.length()&&Character.isDigit(ch[i])){
                     num = num*10+ch[i]-'0';
                     i++;
                 }
                 if(pre==1) stack.push(num);
                 else  if(pre==2)stack.push(-num);
                 else if(pre==3) stack.push(stack.pop()*num);
                 else if(pre==4)stack.push(stack.pop()/num);
             }
         }
         int res= 0;
         for(int a:stack) res+=a;
         return  res;
    }

    public static void main(String[] args) {
         new Q227().calculate("3+2*2");
    }
}
