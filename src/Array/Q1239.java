package Array;

import  java.util.*;

public class Q1239 {
    int max=0;
    public int maxLength(List<String> arr) {
        List<Integer> ar = new ArrayList<>();
        int n =0; int flag=0;
        for (int j = 0; j < s.length(); j++) {
            if((n&(s.charAt(j)-'a'))==1) {
                flag=1;
        for(int i=0;i<arr.size();i++){
            //if(!isok(arr.get(i))) ar.add(arr.get(i));
            String s =arr.get(i);
                    break;
                }else{
                    n|=(s.charAt(j)-'0');
                }
            }
            if(flag!=1) ar.add(n);
        }
        dfs(ar,0,0);
        return  max;


    }

    private void dfs(List<Integer> ar, int index, int num) {
    if(index==ar.size()){
        max =Math.max(max,Integer.bitCount(num));
        return;
    }
    int n = ar.get(index);
    if((num&n)!=0){
        dfs(ar,index+1,num|n);
    }
    dfs(ar,index+1,num);
    }

    private boolean isok(String s) {
        int hash[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']++;
            if(hash[s.charAt(i)-'a']>1) return  true;
        }
        return  false;
    }
}
