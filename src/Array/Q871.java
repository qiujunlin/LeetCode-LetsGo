package Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int fuel = startFuel;
        int pos = 0;
        int count = 0;
        for (int i = 0; i < stations.length; i++) {
            //如果当前位置加上后不能到达
            if (pos + fuel < stations[i][0]) {
                while (pos + fuel < stations[i][0]) {
                    if (queue.isEmpty()) return -1;
                    else {
                        fuel += queue.poll();
                        count++;
                    }
                }
                //return -1;
            }
            //表示可以走到这个加油站 把这个加油站的有放进去
            queue.offer(stations[i][1]);
            //走到这一步 要减去上一个站到这一个站消耗的油 如果是第一个个站 减去当前的就可以了
            fuel-=i==0?stations[i][0]:stations[i][0] - stations[i - 1][0];
            pos =pos+i==0?stations[i][0]:stations[i][0] - stations[i - 1][0];
        }
        while (pos + fuel < target) {
            if (queue.isEmpty()) return -1;
            else {
                fuel += queue.poll();
                count++;
            }
        }
        return count;
    }
}
