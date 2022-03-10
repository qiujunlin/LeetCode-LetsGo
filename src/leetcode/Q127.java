package leetcode;

import java.util.*;

public class Q127 {
    int min =Integer.MIN_VALUE;
    public List<List<String>>  ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        HashSet<String> set = new HashSet<>(wordList);
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        Deque<String>  que =new LinkedList<>();
        que.offer(beginWord);
        int deep =1;
        boolean  visit =false;
        HashSet<String>  vis = new HashSet<>();
        while (!que.isEmpty()) {
            int size =que.size();
            if(visit) break;
            for (int i = 0; i < size; i++) {
                String s = que.poll();
                ArrayList<String> l = map.computeIfAbsent(s, (key) -> new ArrayList<>());
                char ch[] = s.toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    char temp = ch[j];
                    for (int k = 0; k < 26; k++) {
                        ch[j] = (char) (k + 'a');
                        String news = new String(ch);
                        if (set.contains(news)&&!vis.contains(news)) {
                            l.add(news);
                            que.offer(news);
                            vis.add(news);
                        }
                        if(news.equals(endWord))  visit =true;
                    }
                    ch[j] = temp;
                }
            }
        }
        LinkedList<String> l =new LinkedList<>();
        HashSet<String>  viss = new HashSet<>();
        List<List<String>>  res =new ArrayList<>();


        l.addLast(beginWord);
        vis.add(beginWord);
        dfs(vis,l,endWord,res,map);

        return   res;


    }

    private void dfs(HashSet<String> vis, LinkedList<String> l,String end, List<List<String>> res, HashMap<String, ArrayList<String>> map) {
          if(l.getLast().equals(end)) {
              if(l.size()<min){
                  res.clear();
                  res.add(new ArrayList<>(l));
              }
              return;
          }
          if(l.size()>min) return;
          String s = l.getLast();
          for(String  temp  : map.get(s)){
              if(!vis.contains(temp)) {
                  vis.add(temp);
                  l.addLast(temp);
                  dfs(vis,l,end,res,map);
                  vis.remove(temp);
                  l.removeLast();
              }
          }
    }

}
