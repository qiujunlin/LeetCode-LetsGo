package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Q301 {
    HashSet<String> set;
    String s ;int len =0;

    public List<String> removeInvalidParentheses(String s) {
     this.s =  s;this.len  = s.length();this.set = new HashSet<>();
     int  l = 0;int r =0;
        for (int i = 0; i < s.length(); i++) {
            char c =  s.charAt(i);
            if(c=='(') l++;
            else if(c==')'){
                if(l!=0) l--;
                else r++;
            }
        }
        len = s.length() -l-r;
        dfs(l,r,"",0,0,0);
        ArrayList<String> list = new ArrayList<>();
        for(String ss :set) list.add(ss);
        return  list;

}
void  dfs(int  l ,int r ,String temp ,int index,int lcount,int rcount){
        if(l<0||r<0||lcount<rcount) return;
        if(l==0&&r==0) {
            System.out.println(temp);
             if(temp.length()==len)set.add(temp);
        }

        char c =  s.charAt(index);
        if(c=='('){
           dfs(l,r,temp+String.valueOf(c),index+1,l+1,r);
           dfs(l,r-1,temp,index+1,l,r);

        }else if(c==')'){
            dfs(l,r,temp+String.valueOf(c),index+1,l,r+1);
            dfs(l-1,r,temp,index+1,l,r);
        }else{
            dfs(l,r,temp+String.valueOf(c),index+1,l,r);
        }


}

}
