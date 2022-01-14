package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q1036 {
    long N = 1000000;
    int direct[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashSet<Long> set = new HashSet<>();
        for (int a[] : blocked) {
            long n = a[0];
            n = n * N + a[1];
            set.add(n);
        }
        long s =source[0] * N + source[1];
        long t =target[0] * N + target[1];
        if(check(s,t,set)==false||check(t,s,set)==false) return  false;
        return  true;


    }
    boolean check(long s,long t,HashSet<Long> set){
        HashSet<Long> vis = new HashSet<>();
        Queue<Long> q
                = new LinkedList<>();
        q.offer(s);
        vis.add(s);
        while (!q.isEmpty()) {
            long num = q.poll();
            for (int i = 0; i < direct.length; i++) {
                long newx = num / N + direct[i][0];
                long newy = num % N + direct[i][1];
                if (newx < 0 || newy < 0 || newx >= N || newy >= N) continue;
                long newnum = newx * N + newy;
                if (newnum == t) return true;
                if (set.contains(newnum)) continue;
                else if (!vis.contains(newnum)) {
                    vis.add(newnum);
                    q.offer(newnum);
                }
            }
            //   System.out.println(q);
            if (vis.size() > 200 * 200) return true;

        }
        return false;
    }
}
