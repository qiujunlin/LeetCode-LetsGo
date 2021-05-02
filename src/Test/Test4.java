package Test;

import com.sun.javafx.image.IntPixelGetter;

import java.math.BigInteger;
import java.util.*;

public class Test4 {
    public static void main(String[] args) {
      StringBuilder s = new StringBuilder("0000");
      s.append("11",0,2);
        System.out.println(s);

    }
    public boolean splitString(String s) {
        LinkedList<Integer>  list =new  LinkedList();
        boolean res =  dfs(new BigInteger("0"),s,0);
        return res;
    }
    private boolean dfs(BigInteger pre, String s, int index) {
        if(index==s.length()) return true;
        for(int i=index;i<s.length();i++){
            String ss = s.substring(index,i+1);
            BigInteger res = new BigInteger(ss);
           // Long res =  Long.valueOf(ss);
            //System.out.println(res);
            if(pre.compareTo(res)==-1||pre.compareTo(res)==0) {
              if(index!=0) break;
            }
            else {
                if(index==0||pre.subtract(res).compareTo(new BigInteger("1"))==0){
                    boolean b = dfs(res,s,i+1);
                    if(b) {
                        if(index==0&&i==s.length()-1)return false;
                        return true;
                    }
                }
            }
        }
        return  false;
    }


}
