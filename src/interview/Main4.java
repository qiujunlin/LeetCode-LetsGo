package interview;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int n = s.nextInt();
        int m  = s.nextInt();
        ArrayList<Integer>  l[] =new ArrayList[n];
        s.nextLine();
        for (int i = 0; i <n ; i++) {
            l[i] =new ArrayList<>();
            String str =s.nextLine();
            String strs[] =str.split(",");
            int  num  = Integer.valueOf(strs[0]);
            if(num!=0){
                for (int j = 1; j <strs.length ; j++) {
                     l[i].add(Integer.valueOf(strs[j]));
                }
            }
        }
        Queue<Integer> q =new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> vis =new HashSet<>();
        q.offer(m); vis.add(m);
        boolean isloop = false;
         out: while (!q.isEmpty()){
            int cur =q.poll();
            for(int next :l[cur]){
                if(vis.contains(next)) {
                    isloop =true;
                    break out;
                }
                else {
                    q.add(next);
                    res.add(next);
                    vis.add(next);
                }
            }
        }
        if(isloop) System.out.println(-1);
        else if(res.size()==0)  System.out.println("null");
        else{
            Collections.sort(res);
            for (int i = 0; i < res.size(); i++) {
                 if(i!=res.size()-1) {
                     System.out.print(res.get(i)+",");
                 }else System.out.println(res.get(i));
            }
        }
    }

}
