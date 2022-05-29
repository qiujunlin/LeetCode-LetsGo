package Contest.week;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DW79 {
    public static void main(String[] args) {
        System.out.println("hahs");
    }
    public boolean digitCount(String num) {

        String s =  String.valueOf(num);
        HashMap<Integer,Integer>  map =new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            map.put(s.charAt(i)-'0',map.getOrDefault(s.charAt(i)-'0',0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(i)){
                if(s.charAt(i)-'0'!=0) return  false;
            }else {
                if (map.get(s.charAt(i) - '0') != s.charAt(i) - '0') return false;
            }
        }
        return  true;

    }
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map =new HashMap<>();
        for (int i = 0; i <messages.length ; i++) {
            map.put(senders[i],map.getOrDefault(senders[i],0)+messages[i].split(" ").length);
        }
        int max =0;

        for(int k :map.values()){
            max =Math.max(k,max);
        }
        ArrayList<String> l =new ArrayList<>();
        for(String s :map.keySet()){
            if(map.get(s)==max) {
                l.add(s);
            }
        }
        Collections.sort(l);
        return  l.get(0);

    }
    public long maximumImportance(int n, int[][] roads) {
         int h[] =new int[50002];
         for(int a[]:roads){
             h[a[0]]++;
             h[a[1]]++;
         }
        PriorityQueue<Integer> q =new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i <h.length ; i++) {
            if(h[i]!=0) q.offer(h[i]);
        }
        long res  =0;
        while (!q.isEmpty()){
            long s =  q.poll();
            res += s*n;
            n--;
        }
        return  res;
    }
    public int rearrangeCharacters(String s, String target) {
         int  h[] = new int[26];
         int  h2[] = new int[26];
        for (int i = 0; i <target.length() ; i++) {
            h[target.charAt(i)-'a']++;
        }
        for (int i = 0; i <s.length() ; i++) {
            h2[s.charAt(i)-'a']++;
        }
        int res  =0;
        while (true){
            for (int i = 0; i < h.length; i++) {
                if(h2[i]-h[i]<0)  return  res;
            }
            res++;
        }
    }
    public String discountPrices(String sentence, int discount) {
           int i  =0;
           ArrayList<Integer>  l1 =new ArrayList<>();
           ArrayList<Integer>  l3 =new ArrayList<>();
           ArrayList<String>  l2 =new ArrayList<>();
           while (i<sentence.length()){
               char c = sentence.charAt(i);
               if(c=='$'){
                   if(i==0||sentence.charAt(i-1)==' '){
                       int  j  = i+1;
                       while (j<sentence.length()&&sentence.charAt(j)!=' ') j++;
                       String s = sentence.substring(i,j);
                       if(s.length()==0||s.contains("$")) {
                           i=j;continue;
                       }
                       if(isInteger(s)) {
                           l2.add(s);
                           l1.add(i);
                           l3.add(j);
                       }
                       i = j;
                   }
               }
               i++;
           }
        for (int j = 0; j < l1.size() ; j++) {
            double c =Double.valueOf(l2.get(i));
            String s = format(c);
            l2.set(i,s);
        }
        for (int j = 0; j <l1.size() ; j++) {
            sentence = sentence.substring(0,i) + "$" + l2.get(i) + sentence.substring(l3.get(i));
        }
        return  sentence;
    }
    public  String format(double value) {

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }
    public  boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
