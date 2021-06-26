package Array;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        if(!set.contains(endWord)) return 0;
        Deque<String> start = new LinkedList<>();
        Deque<String> end = new LinkedList<>();
        HashSet<String > visstart = new HashSet<>();
        HashSet<String> visend = new HashSet<>();
        start.offer(beginWord);
        end.offer(endWord);
        visstart.add(beginWord);
        visend.add(endWord);
        int count  = 0;
        while (!start.isEmpty()&&end.isEmpty()){
            count++;
            boolean res = false;
           if(start.size()<=end.size()){

              res = updata(start,visstart,visend,set);
           }else{
               res =updata(end,visend,visstart,set);

           }
           if(res) return  count;
        }
        return  0;

    }

    private boolean updata(Deque<String> start, HashSet<String> visstart, HashSet<String> visend, HashSet<String> set) {
         int size = start.size();
        for (int i = 0; i < size; i++) {
            for (String s:get(set,start.poll())) {
                if(visstart.contains(s)) continue;
                if(visend.contains(s)) return  true;
                visstart.add(s);
                start.offer(s);
            }
        }
        return  false;
    }

    private List<String> get(HashSet<String> set, String poll) {
         char ch[] = poll.toCharArray();
        List<String> l = new ArrayList<>();
         for (int i = 0; i < ch.length; i++) {
             char c =ch[i];
             for (int j = 0; j < 26; j++) {
                 ch[i] =  (char) (j+'a');
                 if(set.contains(new String(ch))){
                     l.add(new String(ch));
                 }
             }
             ch[i] = c;
        }
         return  l;
    }
}
