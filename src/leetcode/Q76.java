package leetcode;

import java.util.HashMap;

public class Q76 {
    public String minWindow(String s, String t) {
        //如何判断是否为0
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <t.length() ; i++) {
             map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int l =0; int  min = Integer.MAX_VALUE; int minl = 0;int minr =0;
        int zerocount  =map.size();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)zerocount--;
            }
            while (l<i&&zerocount==0){
                char c2 = s.charAt(l);
                if(map.containsKey(c2)){
                    map.put(c2,map.get(c2)+1);
                    if(map.get(c2)>0) {
                      zerocount++;
                      break;

                    }
                }

                if(min>i-l+1) {
                        minl =l;minr =i; min = i-l+1;
                }

            }

        }
        return  s.substring(minl,minr+1);



    }
}
