package Contest.week;
import  java.util.*;
public class W250 {
    static  ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println(Long.MAX_VALUE);

    }

    public int canBeTypedWords(String text, String brokenLetters) {
        String s[] = text.split(" ");
        int hash[] = new int[26];
        for (int i = 0; i <brokenLetters.length() ; i++) {
            hash[brokenLetters.charAt(i)-'a']++;
        }
        int res  =0;
        for(String temp :  s){
            int i=0;
            for ( i = 0; i < temp.length(); i++) {
                if(hash[temp.charAt(i)-'a']!=0) break;
            }
            if(i==temp.length()) res++;
        }
        return  res;

    }
    public int addRungs(int[] rungs, int dist) {
        int count  =0;
        int i =0;
        while (i<rungs.length){
            if(rungs[i+1]-rungs[i]>dist){
                int cha  = rungs[i+1]-rungs[i];
                if(cha%dist==0) count+=cha/dist-1;
                else count+=(cha/dist);
                i++;
            }
            int  step =0;
            while (i<rungs.length&&(step+rungs[i+1]-rungs[i])<=dist){
                step+=rungs[i+1]-rungs[i];
                i++;
            }
        }
        return  count;
    }
    class Node{
        int i;
        int  j ;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    int m  =0;
    int n  =0;
    HashMap<Node,Long> map = new HashMap<>();
    public long maxPoints1(int[][] points) {
        long max  = 0;
        m =  points.length;
        n = points[0].length;
        System.out.printf(String.valueOf(m));
        System.out.printf(String.valueOf(n));
        int dp[]  =  new int[points[0].length];

        long men[][][] = new long[m][n][n];
        long res =0;
        for(int i=0;i<n;i++){
            res= Math.max(  dfs(points,men,0,i),res);
        }
        return res;
    }

    public long maxPoints(int[][] points) {
       // long max  = 0;
        m =  points.length;
        n = points[0].length;
        long pre[][] = new long[m][2];
        long last[] = new long[m];
        long res =0;
        for (int i = 0; i < m; i++) {

            if(i==0){
                for (int j = 0; j < n; j++) {
                    res =Math.max(res,points[0][j]);
                    pre[i][0]= points[0][j]-j;
                    pre[i][1] = points[0][j]+j;
                }
            }else{
                long max = 0;
                for (int j = 0; j < n ; j++) {
                    max = Math.max(points[i][1],1);

                }
            }
            last[n-1] =points[i][n-1];
            for (int j = n-2; j >=0 ; j--) {
                 last[j] =  Math.max(points[i][j+1],last[j+1]);
            }

        }
        return res;


    }

    private long dfs(int[][] points, long[][][] men, int i, int j) {
        if(i==m-1) return points[i][j];
        Node node = new Node(i,j);
        if(map.containsKey(node)) return map.get(node);
        long a  = 0;
        for (int k = 0; k <n ; k++) {
            long res  = dfs(points,men,i+1,k);
            a =Math.max(res-Math.abs(j-k),a);
        }
        long c =a+points[i][j];
        map.put(new Node(i,j),c);
        return  c;
    }



}
