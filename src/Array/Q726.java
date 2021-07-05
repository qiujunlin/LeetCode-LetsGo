package Array;

import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Q726 {
    public static void main(String[] args) {
        System.out.println(new Q726().countOfAtoms("(K4(ON(SO3)2)2)"));

    }
    public String countOfAtoms(String formula) {
        TreeMap<String ,Integer> map  = new TreeMap<>();
        Stack<StringBuffer> stack =new Stack<>();
        char ch[] =  formula.toCharArray();
        StringBuffer  s=  new StringBuffer();
        for (int i = 0; i < formula.length(); i++) {
             if(ch[i]=='('){
                  stack.push(s);
                  s=  new StringBuffer();
             }else  if(ch[i]==')'){
                 int  num  =0;
                 while (i+1<formula.length()&&Character.isDigit(ch[i+1])){
                       num  = num*10+ch[i+1]-'0';
                       i++;
                 }
                 put(map,s,num==0?1:num);
                 s = stack.pop();
             }else{
                s.append(ch[i]);
             }
        }

        StringBuffer res  = new StringBuffer();
        while (!map.isEmpty()){
            Map.Entry<String ,Integer> en =  map.pollFirstEntry();
            res.append(en.getKey());
            if(en.getValue()!=1) res.append(en.getValue());

        }
         return  res.toString();
    }

    private void put(TreeMap<String, Integer> map, StringBuffer s, int num) {
        int i  =0;
       char ch[] = s.toString().toCharArray();
        while (i<s.length()){
            StringBuffer temp  =new StringBuffer();
            temp.append(ch[i]);
            while (i+1<s.length()&&isXiao(ch[1+i])) {
                temp.append(ch[i+1]);
                i++;
            }
            int n = 0;
            while (i+1<s.length()&&Character.isDigit(ch[i+1])){
                n =n*10+ch[i+1]-'0';
                i++;

            }
            if(n==0) map.put(temp.toString(),map.getOrDefault(temp.toString(),0)+num);
            else   map.put(temp.toString(),map.getOrDefault(temp.toString(),0)+n*num);
            i++;
        }
    }

    boolean isDa(Character c) {
        return c>='A'&&c<='Z';
    }
    boolean isXiao(Character c) {return  c>='a'&&c<='z';}
}
