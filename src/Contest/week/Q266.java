package Contest.week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Q266 {
    public static void main(String[] args) {
        System.out.println("haha");
    }
    public int countVowelSubstrings(String word) {

        HashSet<Character> w =new HashSet<>();
        int rea =0;
        int l =0;
        for (int i = 0; i <word.length() ; i++) {
            for (int j = i+4; j <word.length() ; j++) {
                  if(judge(word.substring(i,j+1))) rea++;
            }
        }
        return  rea;
    }

    private boolean judge(String substring) {
        HashSet<Character>  set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        HashSet<Character> set1 = new HashSet<>();
        for (int i = 0; i <substring.length() ; i++) {
            if(!set.contains(substring.charAt(i))){
                return  false;
            }else{
                set1.add(substring.charAt(i));
            }
        }
        return  set1.size()==5;
    }
    public long countVowels(String word) {
        //
        long pre[] =new long[word.length()+1];
        //pre[1] + pre[]
        HashSet<Character>  set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i = 0; i <word.length() ; i++) {
              if(set.contains(word.charAt(i))){
                  pre[i+1] =pre[i]+1;
              }else{
                  pre[i+1] = pre[i];
              }
        }
        long sum =0;
        for (int i = 1; i <pre.length ; i++) {
              sum+=pre[i];
        }
        long res =sum;
        for (int i = 0; i < pre.length; i++) {
            System.out.print(pre[i]+" ");
        }

        //  5 6-2+1 =  5
        for (int i = 2; i <pre.length ; i++) {
             res+=sum-(pre.length-i+1)*pre[i-1];
          //   res+=sum;
        }
        return  res;

    }
    public int minimizedMaximum(int n, int[] quantities) {
        int r =0;
        for (int i = 0; i < quantities.length; i++) {
            r=Math.max(quantities[i],r);
        }
        int l =0;
        while (l<r){
            int mid =(l+r)/2;
            if(judge(n,quantities,mid)){
                r= mid;
            }else{
                l =mid+1;
            }
        }
        return  l;



    }

    private boolean judge(int n, int[] quantities, int mid) {
        //int arr[] =new int[n];
        int c =0;
        for(int a :quantities){
            if(a%mid==0) c+=a/mid;
            else c+=(a/mid+1);
        }
        return  c<=n;

    }
    HashMap<Integer, HashMap<Integer,Integer>> map =new HashMap<>();
    int max =0;
    HashSet<Integer> vis =new HashSet<>();
    int []values;
    HashMap<Integer,Integer> xiaofei  =new HashMap<>();
    HashMap<Integer,Integer>  qian  =new HashMap<>();
    int maxtime=0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
       this.values= values;
       this.maxtime =maxTime;
        for(int a[]:edges){
           map.computeIfAbsent(a[0],((key)->new HashMap<>())).put(a[1],a[2]);
           map.computeIfAbsent(a[1],((key)->new HashMap<>())).put(a[0],a[2]);
        }
        vis.add(0);
        dfs(0,values[0],0);

        return  max;




    }
    //每个节点的消费 2. 每个节点的值
    void dfs(int count ,int sum,int source){
       // if(count*2<=maxtime)
        max =Math.max(max,sum);
        HashMap<Integer,Integer>  m = map.get(source);
        for(int a : m.keySet()){
                  int newsum = count;
                  if(!vis.contains(a)) newsum+=m.get(a);
                  if((count+m.get(a))*2<=maxtime)
                  dfs(count+m.get(a),newsum,a);
              }
        }

    }

}
