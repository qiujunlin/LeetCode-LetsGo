package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        Node root = new Node();
        Arrays.sort(words,(a,b)->a.length()-b.length());
        for (int i = 0; i <words.length ; i++) {
            String s = words[i];
            if(s.length()==0) continue;
            if(dfs(root,s,1)){
                res.add(s);
            }else{
                insert(root,s);
            }
        }
        return  res;
    }

    private boolean dfs(Node root, String s,int dep) {
        Node node  = root;
        for (int i = 0; i <s.length() ; i++) {
           char c = s.charAt(i);
            if(node.nodes[c-'a']==null) return  false;
            if(node.isend==true){
                boolean res =dfs(root,s.substring(i+1,s.length()),dep+1);
                if(res)return  true;
            }
            node =node.nodes[c-'a'];
        }
        if(dep==1) return  false;
        else return  true;


    }

    private void insert(Node root, String s) {
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(root.nodes[c-'a']==null){
                root.nodes[c-'a']=new Node();
            }
            root =root.nodes[i];
        }
        root.isend = true;
    }

    class Node{
        boolean isend;
        Node nodes[];
       public  Node(){
           this.isend =false;
           this.nodes = new Node[26];
       }
    }

}

