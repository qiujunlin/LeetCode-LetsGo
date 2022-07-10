package Contest.week;



import java.util.PriorityQueue;
import java.util.TreeSet;

public class W301 {

    public int fillCups(int[] amount) {
        PriorityQueue<Integer> q =new PriorityQueue<>((a,b)->b-a);
        int res =0;
        for(int a:amount){ if(a!=0) q.offer(a);}
        while (!q.isEmpty()){
            int a = q.poll();
            if(q.isEmpty())return  res+a;
            int b = q.poll();
            res+= 1;
            a--;
            b--;
            if(a!=0)
            q.offer(a);
            if(b!=0)
                q.offer(b);
        }
        return  res;
    }

    /**
     * "___L___"
     * "_L_____"
     *
     * @param start
     * @param target
     * @return
     */

    String get(String start){
        char ch1[] = start.toCharArray();
        char ch2[] = start.toCharArray();
        int i =0;
        int l =0;
        TreeSet<Integer> set =new TreeSet<>();
        while (i<start.length()){
            char c = ch1[i];
            if(c=='_'){
                set.add(i);
            }else if(c=='R'){
                set.clear();
            }else {
                if(!set.isEmpty()){
                    int a =    set.pollFirst();
                    ch1[a] ='L';
                    ch1[i] ='_';
                    set.add(i);

                }
            }
            i++;
        }
        i=start.length()-1;
        set.clear();
        while (i>=0){
            char c = ch1[i];
            if(c=='_'){
                set.add(i);
            }else if(c=='L'){
                set.clear();
            }else {
                if(!set.isEmpty()){
                    int a =    set.pollLast();
                    ch1[a] ='R';
                    ch1[i] ='_';
                    set.add(i);
                }
            }
            i--;
        }
        return  new String(ch1);
    }


    /**
     * "___L___"
     * "_L_____"
     */
}
