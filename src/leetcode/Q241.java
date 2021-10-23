package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q241 {


    public List<Integer> diffWaysToCompute(String expression) {


        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c  = expression.charAt(i);
            if(Character.isDigit(c)) continue;
            List<Integer> left =  diffWaysToCompute(expression.substring(0,i));
            List<Integer> right =  diffWaysToCompute(expression.substring(i+1,expression.length()));
            for(int a :left){
                for(int b : right){
                    switch (c){
                        case '*': res.add(a*b);
                        case  '+':res.add(a+b);
                        case  '-':res.add(a-b);
                    }
                }
            }
        }
        if(res.isEmpty()) res.add(Integer.valueOf(expression));
        return  res;





    }
}
