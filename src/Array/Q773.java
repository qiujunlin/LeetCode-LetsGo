package Array;

import java.util.*;

public class Q773 {
    int direct[][] = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
    public int slidingPuzzle(int[][] board) {
        String res=  "123450";
        String oring =  "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                 oring+=board[i][j];
            }
        }
        if(oring.equals(res)) return  0;
        Deque<String> deque = new LinkedList<>();
        deque.offer(oring);
        int level = 0;
        HashSet<String> vis =  new HashSet<>();
        vis.add(oring);
        while (!deque.isEmpty()){
            level++;
            int size  = deque.size();
            for (int i = 0; i < size; i++) {
                for(String s : get(deque.poll())){
                    if(vis.contains(s)) continue;
                    if(s.equals(res)) return  level;
                    deque.offer(s);
                    vis.add(s);
                }
            }
        }
        return -1;
    }

    private List<String> get(String poll) {
        int index = poll.indexOf('0');
        List<String> res  = new ArrayList<>();
        char ch[] = poll.toCharArray();
        for(int a:direct[index]){
            swap(ch,index,a);
            res.add(new String(ch));
            swap(ch,index,a);
        }
        return  res;
    }

    private void swap(char[] ch, int index, int a) {
     char c   =ch[index];
     ch[index] = ch[a];
     ch[a] = c;

    }
}
