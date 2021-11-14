package leetcode;

import java.util.HashMap;

class MapSum {
   HashMap<String,Integer> map ;
    Node  node;
    public MapSum() {
        map =new HashMap<>();
        this.node =new Node();

    }

    public void insert(String key, int val) {
          map.put(key,val);
          Node cur =node;
        for (int i = 0; i < key.length(); i++) {
            char c  = key.charAt(i);
            if(!cur.map.containsKey(c)){
                cur.map.put(c,new Node());
            }
            cur =cur.map.get(val);
        }
        cur.end=true;
    }
    int res =0;
    public int sum(String prefix) {
        this.res =0;
        Node cur = node;
        for (int i = 0; i <prefix.length() ; i++) {
             char c =  prefix.charAt(i);
             if(!cur.map.containsKey(c)) return  0;
           cur =  cur.map.get(c);
        }
        dfs(cur,prefix);
        return  res;
    }

    private void dfs(Node cur,String pre) {
         if(cur.end) res+=map.get(pre);
         for(char  key :node.map.keySet()){
              dfs(node.map.get(key),pre+String.valueOf(key));
         }
    }

    class Node{
        HashMap<Character,Node> map ;
        boolean end = false;
        public  Node(){
            this.map =  new HashMap<>();
        }

    }
}
