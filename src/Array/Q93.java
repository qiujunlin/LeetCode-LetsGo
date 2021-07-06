package Array;
import  java.util.*;
public class Q93 {
    List<String> res ;
    StringBuffer ip ;
    public List<String> restoreIpAddresses(String s) {
         res=new LinkedList<>();
         ip =new StringBuffer();
      dfs(0,s,1);
      return  res;
    }

    private void dfs(int i, String s, int count) {
        if(count==4&&i==s.length()) res.add(ip.toString());
        if(count==4&&i<s.length()) return;
        if(i==s.length()&&count<4) return;
        for (int j = i; j < s.length(); j++) {
            int a =Integer.valueOf(s.substring(i,j+1));
            if(a>=256)return;
            if(count!=0) ip.append('.');
            ip.append(a);
            dfs(j+1,s,count+1);
            ip.delete(ip.lastIndexOf(String.valueOf(a))-1,ip.length());
        }
    }
}
