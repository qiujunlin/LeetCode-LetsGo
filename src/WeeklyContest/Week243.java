package WeeklyContest;

    import java.math.BigInteger;
    import java.util.PriorityQueue;

public class Week243 {

    public static void main(String[] args) {


    }
    class Node{
        int time;
        T t;
        public  Node(int time,T t){
            this.time = time;
            this.t = t;
        }
    }
    class T{
        int w;
        int id;
        public T(int w,int id){
            this.w =w;
            this.id=id;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Node>  shiyong = new PriorityQueue<>((a,b)->a.time-b.time);//使用中的 到期  时间 +  服务器id + 服务器权重
        PriorityQueue<T>  fenpei= new PriorityQueue<>((a,b)->a.w==b.w?a.id-b.id:a.w-b.w); // 权重 +id
        //  PriorityQueue<int[] >  task = new PriorityQueue<>((a,b)->a[1]-b[1]);//需要分配的
        int task =0;
        for(int i=0;i<servers.length;i++){
            fenpei.offer(new T(servers[i],i));
        }
        int res [] = new int[tasks.length];
        // 权重
        int time =0;
        while (true){
            //处理空闲服务器
            //处理时间到的服务器
            while (!shiyong.isEmpty()&&shiyong.peek().time<=time){
                Node node =shiyong.poll();
                fenpei.offer(node.t);
            }
            //分配任务 优先分配时间早的
            //  if(time<tasks.length)
            //task.offer(new int[]{tasks[time],time});
            while (task<=time&&task<tasks.length&&!fenpei.isEmpty()){
                //int t[] =  task.poll(); // 使用时间 + id
                T t =fenpei.poll();// 权重 + id
                shiyong.offer(new Node(time+tasks[task],t));
                res[task] = t.id;
                task++;
            }
            time++;
            if(task>=tasks.length&&time>=tasks.length) return  res;
        }

    }
    public String maxValue(String n, int x) {
        if(n.charAt(0)!='-'){
            for(int i=0;i<n.length();i++){
                if(n.charAt(i)-'0'>=x){
                    continue;
                }else{
                    return  n.substring(0,i)+x+n.substring(i,n.length());
                }
            }
        }else{
            for(int i=1;i<n.length();i++){
                if(n.charAt(i)<=x){
                    continue;
                }else{
                    return  n.substring(0,i)+x+n.substring(i,n.length());
                }
            }
        }
        return n+x;
    }
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
      StringBuffer first  = new StringBuffer();
      StringBuffer second  = new StringBuffer();
      StringBuffer target  = new StringBuffer();
      for(int i  =0;i<firstWord.length();i++){
          first.append(firstWord.charAt(i)-'a');
      }
        for(int i  =0;i<firstWord.length();i++){
            second.append(secondWord.charAt(i)-'a');
        }
        for(int i  =0;i<firstWord.length();i++){
            target.append(targetWord.charAt(i)-'a');
        }
        BigInteger a =  new BigInteger(first.toString());
        BigInteger b =  new BigInteger(second.toString());
        BigInteger c =  new BigInteger(target.toString());
        BigInteger sum =  a.add(b);
        return  sum.equals(c);
    }

}
