package leetcode;
import  java.util.*;
public class Q139 {
    HashSet<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer,Integer> map   = new HashMap<>();
        map.get(1);
//dfs
        int maxlen =  0;
   for(String ss : wordDict){
       set.add(ss);
       maxlen = Math.max(ss.length(),maxlen);
   }
   return  dfs(s,0);
    }
    boolean dfs(String s ,int index ){
        if(index ==  s.length()) return  true;
        for(int i=index;i<s.length();i++){
            String str = s.substring(i,index+1);
            if(set.contains(str)){
                if(dfs(s,index+1)) return  true;
            }
        }
        return  false;
    }
}
