package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Q909 {
    public int snakesAndLadders(int[][] board) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        int len = board.length;
        HashSet<Integer> vis = new HashSet<>();
        vis.add(1);
        int   count =0;
        while (!deque.isEmpty()){
            count++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int from = deque.poll();
                for (int j = 0; j < 6; j++) {
                    int newf = from+j;
                    if(newf==len*len) return count;
                    if(board[newf/6][newf%6]!=-1){
                        if(newf==len*len) return  count;
                        if(!vis.contains(board[newf/6][newf%6]))
                        vis.add(board[newf/6][newf%6]);
                    }
                    else {
                        if(!vis.contains(newf))
                        vis.add(newf);
                    }
                }
            }
        }
        return  -1;

    }
}
