package String;

import java.util.*;

/**
 * @Classname ZigZagConversion6
 * @Description:
 * @Date 2020/11/17 21:44
 * @Created by qiujunlin
 */
public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        List<List<Character>> lists= new ArrayList<>();
        for(int i=0;i<numRows;i++){
            lists.add(new ArrayList<>());
        }
        int len=s.length();
        int nums=numRows+numRows-2;
        int times=len%nums==0?len/nums:len/nums+1;
        int index=0;
        for(int i=0;i<times;i++){//第几轮
            for(int j=0;j<numRows-1;j++) {//第i轮中的第j列
                for (int k = 0; k < numRows; k++)//第j列中的第k行
                    if (index < len) {
                        if (j == 0 || k == numRows - j - 1) {
                            lists.get(k).add(s.charAt(index));
                            index++;
                        }
                        else {
                            lists.get(k).add(null);
                        }

                    }
            }


        }
        String res="";
        for(int i=0;i<numRows;i++){
            List<Character> list = lists.get(i);
            for (Character a:
                 list) {
                if(a!=null)
                 res=res+String.valueOf(a);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Character a='a';
        Character b='b';
        Character c=null;
        //System.out.println(String.valueOf(a)+b+String.valueOf(c));
       String s = "A";
       int numRows = 1;
        System.out.println(new ZigZagConversion6().convert(s,1));
    }
}
