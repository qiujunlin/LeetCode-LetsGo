package Test;


import template.MaxPQ;

import java.util.*;

public class Main2   {
    public static void main(String[] args)  {
  ArrayList<Integer> l =new ArrayList<>();
  int a[] = {1,2,3,4,5,6,7};
  int b[] = new int[a.length];
  int i=0;
  int j=0;
        //Arrays.copyOf;
        for (int k = 0; k < a.length; k++) {
            b[i++] =a[j++];
        }
        for (int k = 0; k <b.length ; k++) {
            System.out.print(b[k] +" ");
        }
    }

   static void quicsort(int nums[],int l,int r){
        if(l>=r) return;
        int i =part(nums,l,r);
        quicsort(nums,l,i-1);
        quicsort(nums,i+1,r);
    }
    private static  int part(int nums[], int l, int r) {
         int  i =l;
         int left=l;int right =r;
         while (left<right){
             while (right>left&&nums[right]>=nums[i])right--;
             while (right>left&&nums[left]<=nums[i]) left++;
             if(left<right) {
                 int temp = nums[left];
                 nums[left] = nums[right];
                 nums[right] = temp;
             }
         }
        int temp =nums[i];
        nums[i]=nums[right];
        nums[right] =temp;
         return   left;
    }
    public int findMaxCI(int[] nums) {
        int max  =0;
        int res  =0;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]>nums[i-1]) {
                max++;
                res = Math.max(max,res);
            }else{
                max =0;
            }
        }
        return  res;

    }
    public boolean hasCycle(String graph) {
        String  str[] = graph.split(",");
        int nums[][] = new int[str.length][2];
        for (int i = 0; i < str.length; i++) {
            int j = str[i].indexOf("-");
            int a = Integer.valueOf(str[i].substring(0,j));
            int b =Integer.valueOf(str[i].substring(j+2));
            nums[i][0] =a;
            nums[i][1] =b;
        }
        int len  = str.length;
        int in[] = new int[100];
        ArrayList<Integer> l[] =new ArrayList[100];
        for(int i=0;i<len;i++) l[i] =new ArrayList();
        for(int a[] :nums){
            in[a[0]]++;
            l[a[1]].add(a[0]);
        }
        Deque<Integer> q =new LinkedList();

        for(int i=0;i<in.length;i++ ){
            if(in[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int a =q.poll();
                for(int c:l[a]){
                    in[c]--;
                    if(in[c]==0) q.offer(c);
                }
            }
        }
        for(int a:in) if(a>0) return false;
        return true;

    }

    class UnionFind {
        // 记录父节点
        private Map<Integer,Integer> father;
        // 记录集合的数量
        private int numOfSets = 0;

        public UnionFind() {
            father = new HashMap<Integer,Integer>();
            numOfSets = 0;
        }
        public void add(int x) {
            if (!father.containsKey(x)) {
                father.put(x, null);
                numOfSets++;
            }
        }

        public void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY){
                father.put(rootX,rootY);
                numOfSets--;
            }
        }

        public int find(int x) {
            int root = x;

            while(father.get(root) != null){
                root = father.get(root);
            }

            while(x != root){
                int original_father = father.get(x);
                father.put(x,root);
                x = original_father;
            }

            return root;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int getNumOfSets() {
            return numOfSets;
        }
    }

    public boolean isCompliance(int[][] distance, int n) {
        UnionFind unionFind =new UnionFind();
        for (int i = 0; i < distance.length; i++) {
            unionFind.add(i);
        }
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                if(distance[i][j]<=2) {
                    unionFind.merge(i,j);
                }
            }
        }



        return unionFind.numOfSets<=n;

    }



    class Point{
        double x;
        double  y;
        public  Point(double x,double y){
            this.x =x;
            this.y =y;
        }
    }
    Point nums[];
    double ang(double x1,double y1,double x2,double y2)
    {
        double ans=x1*x2+y1*y2;
        double base=Math.sqrt(x1*x1+y1*y1)*Math.sqrt(x2*x2+y2*y2);
        ans/=base;
        return Math.acos(ans);
    }

    boolean judge(Point p)
    {
        double angle=0;
        for(int i=0;i<len;i++){
            double x1=nums[i].x-p.x;
            double y1=nums[i].y-p.y;
            double x2=nums[(i+1)%len].x-p.x;
            double y2=nums[(i+1)%len].y-p.y;
            angle+=ang(x1,y1,x2,y2);
        }
        if(Math.abs(angle-2*pi)<min){
            return true;
        }else{
            return false;
        }
    }
    int len;
    double pi=3.1415926;
    double min = 1e-6;
    public boolean isPointInPolygon(double x, double y, double[] coords) {
         this.len =coords.length/2;
         this.nums =new Point[len];
        for (int i = 0; i <coords.length ; i+=2) {
              Point  p =new Point(coords[i],coords[i+1]);
              nums[i] =p;
        }
        return  judge(new Point(x,y));
    }



}

