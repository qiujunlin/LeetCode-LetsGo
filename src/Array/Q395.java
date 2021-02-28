package Array;

import java.util.*;

/**
 * @Classname Q395
 * @Description:
 * @Date 2021/2/27 9:48
 * @Created by qiujunlin
 */
public class Q395 {
    public int longestSubstring(String s, int k) {
        int res =0;
        char ch[] = s.toCharArray();
        for(int i =1;i<=26;i++){
            res = Math.max(find(ch,k,i),res);
        }
        return  res;
    }
    int find(char ch[],int k,int len){
        int  left =0;
        int right =0;
        int match =0;
int nomatch =0;
int res =0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right<ch.length){
            if(!map.containsKey(ch[right])){
                nomatch++;
            }
            map.put(ch[right],map.getOrDefault(ch[right],0)+1);
            if(map.get(ch[right])==k){
                match++;
                nomatch--;
            }
            while (match>k){
               map.put(ch[left],map.get(ch[left])-1);
               if(map.get(ch[left])==k-1) {
                   match--;
                   nomatch++;
               }
               if(map.get(ch[left])==0){
                   nomatch--;
               }
               left++;
            }
            if(match==k&&nomatch==0){
                res= Math.max(res,right-left+1);
            }
            right++;
        }
        return  res;
    }
}
