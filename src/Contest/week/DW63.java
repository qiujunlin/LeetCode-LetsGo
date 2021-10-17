package Contest.week;
import  java.util.*;
public class DW63 {
    public static void main(String[] args) {
        System.out.println("dsad");
    }
   // HashMap<String,Integer>  map  = new HashMap<>();
   public int minMovesToSeat(int[] seats, int[] students) {
    Arrays.sort(seats);
    Arrays.sort(students);
    int res =0;
       for (int i = 0; i <seats.length ; i++) {
           res+=Math.abs(seats[i]-students[i]);
       }
       return  res;

   }
    public boolean winnerOfGame(String colors) {
        HashMap<Integer,Integer> mapA = new HashMap<>();
        HashMap<Integer,Integer> mapB = new HashMap<>();
        PriorityQueue<Integer> qa = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> qb = new PriorityQueue<>((a,b)->b-a);
        int i  =0;
        while (i<colors.length()){
            if(colors.charAt(i)=='A'){
                int c =0;
                while (i<colors.length()&&colors.charAt(i)=='A'){
                    i++;c++;
                }
               qa.offer(c);
            }else{
                int c =0;
                while (i<colors.length()&&colors.charAt(i)=='B'){
                    i++;c++;
                }
               qb.offer(c);
            }
        }
        if(qa.size()==0) return  false;
        if(qb.size()==0) {
            if(qa.peek()>2) return  true;
            else  return  false;
        }
        while (qa.peek()>2||qb.peek()>2){
           if(qa.peek()<2) return  false;
           int a =  qa.poll() ;
           qa.offer(a-1);
            System.out.println(qb.peek());
           if(qb.peek()<2) return  true;
            int b =  qb.poll() ;
            qb.offer(b-1);

        }
        return  false;
    }
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        //1 求最短距离 2. 求每个邮件的时间
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int a[] : edges){
            map.computeIfAbsent(a[0],(key)->new ArrayList<Integer>()).add(a[1]);
            map.computeIfAbsent(a[1],(key)->new ArrayList<Integer>()).add(a[0]);
        }
        HashMap<Integer,Integer> dis = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int lev =1;
        queue.offer(1);
        while (!queue.isEmpty()){
            int size =queue.size();
            for (int i = 0; i < size; i++) {
                int a = queue.poll();
                ArrayList<Integer> list = map.get(a);
                for(int c :  list){
                    if(map.containsKey(c)) continue;
                    dis.put(c,lev);
                    queue.offer(c);
                }
            }
            lev++;
        }
        int max =0;
        for(int a : dis.keySet()){
            max = Math.max(max,gettime(patience[a],dis.get(a)));
        }
        System.out.println(map);
        return  max+1;


    }

    private int gettime(int dis, int  resendtime) {
        int total = dis*2;//收到时间

        if(resendtime>=dis) return  total;

        if(total%resendtime==0){
            return  total+total-resendtime;
        }else{
            return  total+total-total%resendtime;
        }

    }


}
