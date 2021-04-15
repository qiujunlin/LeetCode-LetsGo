    package WeeklyContest.LCCUP;

    import java.util.PriorityQueue;

    public class LCCUP1 {
        public int storeWater(int[] bucket, int[] vat) {
           int res  =0 ;
           //寻找最小值
            int len = bucket.length;
            //int rs =0;
            PriorityQueue<int[]> qu = new PriorityQueue<>((a,b)-> (get(a[0],a[1])-get(b[0],b[1])));
            for(int i=0;i<len;i++){
              if(vat[i]==0) continue;
              if(bucket[i]==0) res+=1;
              else {
                  qu.offer(new int[]{bucket[i],vat[i]});
              }
            }
            int time =0;
            while (qu.size()>1){
                int temp[] = qu.poll();
                time++;
                if(temp[1]+1<=temp[0])
                qu.offer(new int[]{temp[0],temp[1]+1});
                res =  Math.min(res,time+get(qu.peek()[0],qu.peek()[1]));
            }
            return  res;
        }
        int get(int a,int b){
            if(b%a==0) return  b/a;
            else return  b/a+1;
        }

    }
