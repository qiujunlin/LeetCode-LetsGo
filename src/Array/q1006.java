package Array;

import java.util.*;

/**
 * @Classname q1006
 * @Description:
 * @Date 2021/4/1 0:05
 * @Created by qiujunlin
 */
public class q1006 {
    public int clumsy(int N) {
        int flag =0;
        Stack<Integer> stack = new Stack<>();
        for(int i=N;i>0;i--){
            if(stack.isEmpty()) stack.push(N);
            else if(flag==0){
                stack.push(stack.pop()*i);
                flag++;
            }else if (flag==1){
                stack.push(stack.peek()/i);
                flag++;
            }else if(flag==2){
                stack.push(i);
                flag++;
            }else{
                stack.push(i);
                flag=0;
            }
        }
        int len  =stack.size();
        int res=0;
        for(int i=len;i>0;i--){
            if(i==len) res+=stack.pop();
            else if(i%2==0)
            res+=stack.pop();
            else res-=stack.pop();
        }
        return  res;

}

}
