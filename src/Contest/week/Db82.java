package Contest.week;

import java.util.*;

public class Db82 {
    public static void main(String[] args) {
        System.out.println("dsa");
    }
   // HashMap<Integer,Integer> map =new HashMap();
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
   public boolean evaluateTree(TreeNode root) {
          if(root.left==null&&root.right==null) return  root.val==1;

          boolean l = evaluateTree(root.left);
          boolean r = evaluateTree(root.right);
          if(root.val==2)  return  l||r;
          else return  l&&r;


   }
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long a = k1+k2;
        ArrayList<Integer>  l=new ArrayList<>();
        long sum =0;

        for (int i = 0; i <nums1.length ; i++) {
            int n = Math.abs(nums1[i]-nums2[i]);
            if(n!=0) {
              sum+=n;
                l.add(n);
            }
        }
        if(sum<=a) return  0;
        Collections.sort(l);
        long c =0;
        for (int i = 0; i <l.size()-1 ; i++) {
              int n =  l.get(i);
              int pre= l.get(i+1);
              int b = (pre-n)*(l.size()-i-1);// 新增的
              if(c + b>a){
                  int  d = l.size()-i-1;
                  int f =0;
                  while (c+d<=a) {
                      c+=d;
                      f++;
                  }
                  long e = a-c; //需要减1
                  int g =  pre - f;
                  for (int j = i+1; j <l.size() ; j++) {
                      l.set(j,g);
                  }
                  for (int j = i+1; j <j+e ; j++) {
                      l.set(j,l.get(j)-1);
                  }
                  break;
              }else{
                  c+=b;
              }
        }
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i)+" ");
        }
        long res =0;
        for (int b:l){
            res += b*b;
        }
        return  res;

    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
//        Arrays.sort(buses);
//        Arrays.sort(passengers);

        PriorityQueue<Integer> q =new PriorityQueue<>();
        PriorityQueue<int []> q2 =new PriorityQueue<>((a,b)->a[0]-b[0]);


        for (int a:buses)q2.offer(new int[]{a,0});
        for(int a:passengers)q.offer(a);

        while (!q2.isEmpty()){
            if(q.size()==0) {
                int b[] =new int[2];
                while (!q2.isEmpty()) b=q2.poll();
                return  b[0];
            }
            if(q2.size()==1) {
                int t[] =  q2.peek();
                ArrayList<Integer> l=new ArrayList<>();
                while (!q.isEmpty()&&q.peek()<=t[0]&&t[1]<=capacity){
                    t[1]++;
                    l.add(q.peek());
                    q.poll();
                }
                if(l.size()<capacity){
                    int pre = t[0];
                    for (int i = l.size()-1; i >=0 ; i--) {
                         if(l.get(i)==pre) {
                           pre--;
                         }
                         else {
                             return  pre;
                         }
                    }
                }else{
                    for (int i = l.size()-2; i >=0 ; i--) {
                        if(l.get(i)!=l.get(i+1)-1) {
                            return  l.get(i+1)-1;
                        }
                    }
                    return  l.get(0)-1;
                }
            }
            int a = q.peek();
            int b[] = q2.peek();

             if(b[0]>=a) {
                 q.poll();
                 b[1]++;
                 if(b[1]==2) q2.poll();
             }else{
                 q2.poll();
             }


        }
        return  0;
    }
}
