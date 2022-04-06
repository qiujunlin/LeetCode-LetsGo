package Contest.week;

import template.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class W287 {
    public int convertTime(String current, String correct) {
          int h1 =  Integer.valueOf(current.substring(0,2));
          int h2 =  Integer.valueOf(correct.substring(0,2));
          int m1 =  Integer.valueOf(current.substring(2,5));
          int m2 =  Integer.valueOf(correct.substring(2,5));
          int c =0;
          if(h1<h2){
                c  =60-m1;
               h1++;
               c += (h2-h1)*60;
               c+=m2;

          }else{
              c = 60-m1;
              h1++;
              c+=(24-h1)*60;
              c+=(h2)*60;
              c+=m2;
          }
        System.out.println(c);
          int res =0;
          res += c%60;
          c=c/60;
          res+=c/15;
          c=c%15;
          res+=c/5;
          c=c%5;
          res+=c;
          return  res;


    }
    public List<List<Integer>> findWinners(int[][] matches) {
        int h[] =new int[100001];
        HashSet<Integer> s =new HashSet<>();
        for(int a[] :matches){
            h[a[1]]++;
            s.add(a[0]);
            s.add(a[1]);
        }
        ArrayList<Integer> l1 =new ArrayList<>();
        ArrayList<Integer> l2 =new ArrayList<>();
        for (int i = 0; i < h.length; i++) {
            if(h[i]==0&&s.contains(i)) {
                l1.add(i);
            }else if(h[i]==1&&s.contains(i)){
                l2.add(i);
            }
        }
        List<List<Integer>> res =new ArrayList<>();
        res.add(l1);
        res.add(l2);
        return res;
    }
    public int maximumCandies(int[] candies, long k) {
        int max  = 0;
        for(int a:candies) max =Math.max(max,a);
        int l =1;
        int r =max;
        while (l<r){
            int mid = (l+r+1)/2;
            if(judge(candies,mid,k)){
                l = mid;
            }else {
                r =mid-1;
            }
        }
        return  l ;

    }

    private boolean judge(int[] candies, int mid, long k) {
        long c =0;
        for(int a:candies){
            c += a/mid;
        }
        return  c>=k;
    }

    char[] keys; String[] values;String[] dictionar;
    HashSet<String> set = new HashSet<>();
    HashSet<Long>  set2 ;
    HashMap<Character,String>  map1 = new HashMap<>();
    HashSet<Long>  vis =new HashSet<>();
    HashMap<String,ArrayList<Character>> map2 =new HashMap<>();
    public void Encrypter(char[] keys, String[] values, String[] dictionary) {
 this.keys =keys;this.values =values;
 this.dictionar =dictionary;

 for(String s: dictionary)set.add(s);
        for (int i = 0; i <keys.length ; i++) {
             map1.put(keys[i],values[i]);
        }
        for (int i = 0; i < values.length; i++) {
            map2.computeIfAbsent(values[i],(key)->new ArrayList<>()).add(keys[i]);
        }
        this.set2= new HashSet<>();
        long hash[] =new long[201];
        long p = 31;
        long par[] = new long[201];
        hash[0] =1; par[0] =1;
        for (int i = 0; i <201 ; i++) {
            par[i+1] =  par[i]*p ;
        }

        for(String s : dictionary){
            long h =1;
            for (int i = 0; i <s.length() ; i++) {
                h = h*p +s.charAt(i)-'a';
                vis.add(h);
            }
            set2.add(h);
        }

    }

    public String encrypt(String word1) {
        StringBuilder s =new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
             char c =word1.charAt(i);
             s.append(map1.get(c));
        }
        return  s.toString();
    }
    boolean v =false;
    public int decrypt(String word2) {
        int res  =  dfs(0,word2,0);
          if(v) {v =false;return  0;}
          return   res;
    }

    private int dfs(int i, String word2, long t) {
        if(i==word2.length()){
            if(set2.contains(t)) return 1;
            else return  0;
        }
        if(!vis.contains(t)) return   0;
        String s =  word2.substring(i,i+2);
        if(map2.get(s)==null) {v =true; return 0;}
        int n =0;
        for(char c :map2.get(s)){
          n+=   dfs(i+2,word2,t*31+c-'a');
        }
        return   n;
    }


}
