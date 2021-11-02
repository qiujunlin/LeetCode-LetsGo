package leetcode;



import java.util.LinkedList;
import java.util.Queue;

public class Q2059 {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new LinkedList();
        q.offer(start);
        boolean vis[] = new boolean[10001];
        vis[start]=true;
        int lev =1;
        while (!q.isEmpty()){
            int size  = q.size();
            for (int i = 0; i <size ; i++) {
                int num= q.poll();
                for (int j = 0; j < nums.length ;j++) {
                    for (int k = 0; k <3 ; k++) {
                        if(k==0){
                            int target = num+nums[j];
                            if(target==num) return  lev;
                            if(target<=1000&&!vis[target]) {
                                q.offer(target);
                                vis[target]=true;
                            }

                        }
                        if(k==1){
                            int target = num-nums[j];
                            if(target==num) return  lev;
                            if(target<=1000&&!vis[target]){
                                q.offer(target);
                                vis[target]=true;
                            }
                        }
                        if(k==2){
                            int target = num^nums[j];
                            if(target==num&&!vis[target]) return  lev;
                            if(target<=1000) {
                                q.offer(target);
                                vis[target]=true;
                            }
                        }
                    }
                }
            }
            lev++;
        }
        return  -1;
    }
}
