package Array;

import java.util.*;

/**
 * @Classname Q115
 * @Description:
 * @Date 2021/3/17 0:03
 * @Created by qiujunlin
 */
public class Q115 {
        int res=0;
        public int numDistinct(String s, String t) {
    //使用状态压缩枚举出字符串 S的所有 子字符串 枚举的字符串长度为 t》length 计数 比较
    //
            StringBuilder ss=new StringBuilder();
            dfs(ss,0,s,t);
            return  res;

        }
        void dfs(StringBuilder ss,int index,String s,String t){
            if(ss.length()==t.length()){
                if (ss.toString().equals(t)) res++;
                return;
            }
            for (int i=index;i<s.length();i++){
                ss.append(s.charAt(i));
                dfs(ss,i+1,s,t);
                ss.deleteCharAt(ss.length()-1);
            }
           // dfs(ss.append());
        }
}
