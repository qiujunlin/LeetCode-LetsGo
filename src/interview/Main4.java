package interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int n =s.nextInt();
        int m  = s.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = s.nextInt();
        }
     //   Arrays.sort(nums);
        LinkedList<LinkedList<Integer>> list =new LinkedList<>();
        LinkedList<Integer>  d =new LinkedList();
        boolean vis[] =new boolean[nums.length];
         dfs(nums,vis,d,list);
         ArrayList<ArrayList<Integer>>  shuru =new ArrayList<>();
         int k =m;
        while (k>0) {
            ArrayList<Integer> t = new ArrayList<>();
            int a = s.nextInt();
            t.add(a);
            if (a == 1) {
                int l = s.nextInt();
                int r = s.nextInt();
                t.add(l);
                t.add(r);

            } else {
                int l = s.nextInt();
                int r = s.nextInt();
                int add = s.nextInt();
                t.add(l);
                t.add(r);
                t.add(add);
            }
            shuru.add(t);
            k--;
        }
       // System.out.println(list);
        int max  =Integer.MIN_VALUE;
            for(LinkedList<Integer>  li : list){
                for (int i = 0; i <li.size() ; i++) {
                    nums[i] =li.get(i);
                }
                int res =0;
                TreeArray tree= new TreeArray(nums);
                for(ArrayList<Integer> tt:shuru){
                    int a =tt.get(0);
                    if (a == 1) {
                    int l = tt.get(1);
                    int r = tt.get(2);
                     res +=  tree.sumrrage(l-1,r-1);

                    } else {
                    int l = tt.get(1);
                    int r = tt.get(2);
                    int add = tt.get(3);
                    for (int i = l; i <= r; i++) {
                        tree.update(i - 1, add);
                    }
                }

                }
                max =Math.max(max,res);
            }

        System.out.println(max);
        
    }
   static void dfs(int nums[],boolean vis[], LinkedList<Integer> l, LinkedList<LinkedList<Integer>> res){
        if(l.size()==nums.length) res.add(new LinkedList<>(l));
        for (int i = 0; i <nums.length ; i++) {
            if(!vis[i]){
                vis[i]=true;
                l.addLast(nums[i]);
                dfs(nums,vis,l,res);
                l.removeLast();
                vis[i]=false;
            }
        }
    }

  static  class TreeArray{
        int tree[];
        int n;
        int nums[];
        public  TreeArray(int nums[]){
            this.nums =nums;
            this.n =  nums.length;
            this.tree = new int[n+1];
            for (int i = 0; i <n ; i++) {
                add(i+1,nums[i]);
            }
        }
        int lowbit(int x){
            return  x&-x;
        }
        int  query(int x){
            int res =0;
            while (x>0){
                res+=tree[x];
                x-=lowbit(x);
            }
            return  res;
        }
        void add(int x,int num){
            while (x<=n){
                tree[x]+=num;
                x+=lowbit(x);
            }
        }
        void update(int i,int val){
            add(i+1,val);
            nums[i] +=val;
        }
       // void update(int i,int val)
        int sumrrage(int l,int r){
            return  query(r+1)-query(l);
        }
    }
}
