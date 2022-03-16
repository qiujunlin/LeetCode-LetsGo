package Contest.week;

import java.util.*;

public class Q284 {
    public static void main(String[] args) {
        System.out.println("dsa");
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int  res =0;
        int  grid[][] = new int[n][n];
        HashMap<Integer,Integer>  map =new HashMap<>();
        int index = 1;
        for(int a[]: artifacts){
            for (int i = a[0]; i <=a[2] ; i++) {
                for (int j = a[1]; j <=a[3] ; j++) {
                    grid[i][j] =index;
                     map.put(index,map.getOrDefault(index,0)+1);
                }
            }
        }

        for(int a[]: dig){
            int i =a[0];
            int j =a[1];
            if(grid[i][j]!=0){
                map.put(grid[i][j],map.get(grid[i][j])-1);
            }
            if(map.get(grid[i][j])==0){
                res++;
                map.remove(grid[i][j]);
            }

        }
        return  res;

    }
    public int maximumTop(int[] nums, int k) {
        if(k==0) return  nums[0];
        int dp[] =new int[nums.length+1];
        int max = -1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] =max;
            if(i<nums.length)
            max =Math.max(max,nums[i]);
        }
        if(nums.length==1) {
            if(k%2==1) return  -1;
            else return   nums[0];
        }
        if(k==nums.length) return  dp[k-1];
        if(k>nums.length) return  dp[nums.length-1];
        int res  =nums[k];
        res =Math.max(res,dp[k-1]);
        return  res;






    }
    int n  =0;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {

        this.n =n;

        int dist1[] =new int[n];
        int dist2[] =new int[n];
        int dist3[] =new int[n];
        HashMap<Integer, HashMap<Integer, Integer>> map =new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> map2 =new HashMap<>();
        for(int a[] :edges){
            HashMap<Integer,Integer>  m = map.computeIfAbsent(a[0],(key)->new HashMap<>());
            m.put(a[1],a[2]);
            HashMap<Integer,Integer>  m2= map.computeIfAbsent(a[1],(key)->new HashMap<>());
            m2.put(a[0],a[2]);
        }

        dijiskra(map,src1,n,dist1);
        dijiskra(map,src2,n,dist2);
        dijiskra(map2,dest,n,dist3);
        int res  =Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            res =Math.min(dist1[i]+dist2[i]+dist3[i],res);
        }
        for (int i = 0; i <dist1.length ; i++) {
            System.out.print(dist1[i]+" ");
        }
        System.out.println();
        if(res==Integer.MAX_VALUE) return  -1;
        return  res;




    }

    private  void dijiskra(HashMap<Integer, HashMap<Integer, Integer>> map, int source,int n,int dist[]) {
      //  boolean  vis [] = new boolean[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] =0;
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[1]-b[1]);
        que.offer(new int[]{source,0});
        while (!que.isEmpty())
        {
            int node[] =que.poll();
            int from=  node[0];
           // if(vis[from]) continue;
           // vis[from] = true;
            if(node[1]>dist[from]) continue;
            HashMap<Integer, Integer>  edges = map.get(from);
            if(edges==null) continue;
            for(int to : edges.keySet()) {
                if (dist[to] > dist[from] + edges.get(to)) {
                    dist[to] = dist[from] + edges.get(to);
                    que.offer(new int[]{to, dist[to]});
                }
            }
        }
    }
     class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> l=new ArrayList<>();

        while (head!=null){l.add(head.val);head=head.next;}
        int  left1 = 0;
        int  right1 = l.size()-1;
        while (left1<right1){
            if(l.get(left1)==l.get(right1)) {
                left1++;right1--;
            }
            else break;
        }

            //ArrayList<Integer> t = (ArrayList<Integer>) l.clone();
        int  t = l.remove(left1);
        ArrayList<Integer> t1 = new ArrayList<>(t);
        if(judge(l,t1))  return  true;
        l.add(left1,t);
          t = l.remove(right1);
        ArrayList<Integer> t2 = new ArrayList<>(t);
        if(judge(l,t2))  return  true;
        l.add(right1,t);

        return  false;

    }

    private boolean judge(ArrayList<Integer> l, ArrayList<Integer> t1) {
        Collections.reverse(t1);
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i)!=t1.get(i)) return  false;
        }
        return  true;
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
           HashMap<String ,Integer>  map1 =new HashMap<>();
           HashMap<String ,Integer>  map2 =new HashMap<>();
           TreeMap<Integer,ArrayList<String>>  map3 =new TreeMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i],i);
        }
        for (int i = 0; i < list2.length; i++) {
            map1.put(list2[i],i);
        }
        for(String s : list1){
            int a = map1.get(s);
            if(map2.containsKey(s)){

                int b = map2.get(s);
                map3.computeIfAbsent(a+b,(key)->new ArrayList<>()).add(s);
            }
        }
      ArrayList<String> res =   map3.firstEntry().getValue();
        return res.toArray(new String[res.size()]);
    }

}
