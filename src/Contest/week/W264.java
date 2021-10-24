package Contest.week;

import java.util.*;

public class W264 {
    public static void main(String[] args) {

       // System.out.println("!g".indexOf("!"));
    }
    public int countValidWords(String sentence) {
        int index  =0;
        int res =0;
        StringBuilder  s =new StringBuilder();
        while (index<sentence.length()){
            if(sentence.charAt(index)!=' '){
                s.append(sentence.charAt(index));
            }else{
                if(s.length()==0) {index++;continue;}
                if(judge1(s.toString())) res++;
                s =new StringBuilder();
            }
            index++;
        }
        if(s.length()!=0&& judge1(s.toString())) res++;
        return  res;

    }

    private boolean judge1(String s) {
         //

        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9') return  false;
        }
        if(s.contains("-")){
            if(s.indexOf("-")!=s.lastIndexOf("-")) return  false;
            if(s.indexOf("-")==0||s.indexOf("-")==s.length()-1) return  false;
            String ss[] = s.split("-");
                for(String te :ss){
                    boolean has =false;
                    for (int i = 0; i < te.length(); i++) {
                          if(te.charAt(i)>='a'&&te.charAt(i)<='z') has=true;
                    }
                    if(!has) return  false;
                }
            if(s.indexOf("!")!=-1) return  false;
            if(s.indexOf(",")!=-1) return false;
            if(s.indexOf(".")!=-1) return  false;
            }
         if(s.indexOf("!")!=s.lastIndexOf("!")) return  false;
         if(s.indexOf(",")!=s.lastIndexOf(",")) return  false;
         if(s.indexOf(".")!=s.lastIndexOf(".")) return  false;
         if((s.contains("!")&&s.contains("."))||(s.contains("!")&&s.contains(","))||(s.contains(",")&&s.contains("."))) return  false;
         if(s.contains("!")&&s.contains(".")&&s.contains(",")) return false;
         if(s.indexOf("!")!=-1) return  s.indexOf("!")==s.length()-1;
         if(s.indexOf(",")!=-1) return  s.indexOf(",")==s.length()-1;
         if(s.indexOf(".")!=-1) return  s.indexOf(".")==s.length()-1;
         return  true
                 ;

        }
    public int nextBeautifulNumber(int n) {

        for (int i = n+1; i <=10000000 ; i++) {
            int index =i;
            HashMap<Integer,Integer> map =new HashMap<>();
            while (index!=0){
                int last =index%10;
                map.put(last,map.getOrDefault(last,0)+1);
                index/=10;
            }
            boolean res =false;
            for(int a : map.keySet()){
                if(a!=map.get(a)){
                    res=true;break;
                }

            }
            if(!res) return  i;
        }
        return  0;
    }
    class  Node{
        Node left ;Node right;int val ;
        public Node (int val){
            this.val =val;
        }

    }
    public int countHighestScoreNodes(int[] parents) {
        this.total =parents.length;
       HashMap<Integer,Node>  map1 =new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            map1.put(i,new Node(i));
        }
        for (int i = 1; i < parents.length; i++) {
            int  par =parents[i];
            Node  parN = map1.get(par);
            if(parN.left==null) parN.left = map1.get(i);
            else parN.right = map1.get(i);
        }
        dfs(map1.get(0));
        return  map.lastEntry().getValue();

    }
    int total =0;
   TreeMap<Long,Integer> map =new TreeMap<>();
    private long dfs(Node node) {
        if(node==null) return  0;
        long l =0;long r =0;
        if(node.left!=null)l=  dfs(node.left);
        if(node.right!=null) r = dfs(node.right);
        long other = total-l-r;
        if(l==0&&r==0) map.put(other,map.getOrDefault(other,0)+1);
        else if(l==0) map.put(other*r,map.getOrDefault(other+r,0)+1);
        else if(r==0) map.put(other*l,map.getOrDefault(other*l,0)+1);
        else map.put(other*l*r,map.getOrDefault(other*l*r,0)+1);
        return l+r+1;
    }



        public boolean judge(ArrayList<Integer> course[], boolean marked[], boolean onstack[], int v) {
            marked[v] = true;
            onstack[v] = true;
            for (int a : course[v]) {
                if (!marked[a]) {
                    marked[a] = true;
                    boolean bo = judge(course, marked, onstack, a);
                    if (bo) return bo;
                } else if (onstack[a]) {
                    return true;
                }
            }
            onstack[v] = false;
            return false;
        }







}
