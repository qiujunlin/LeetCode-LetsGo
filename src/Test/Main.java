package Test;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import org.omg.CORBA.INTERNAL;

import java.util.*;
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Main {

    public static void main(String[] args) {

    }
    public int maximumDifference(int[] nums) {
        int max  =0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                 max = Math.max(nums[j]-nums[i],max);
            }
        }
        return  max;

    }
    public long gridGame(int[][] grid) {
      long max  =0;
      long sum =0;
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <grid.length ; j++) {
                sum+=grid[0][j];
            }
        }
        int presum1[]  = new int[grid[0].length+1];
        int presum2[] = new int[grid[0].length+1];
        int len  = grid[0].length;
        for (int i = 0; i <len ; i++) {
            presum1[i+1] = presum1[i] +  grid[0][i];
        }
        for (int i = 0; i <len ; i++) {
            presum2[i+1] = presum2[i] +  grid[1][i];
        }
        for (int i = 1; i < len; i++) {
            int s =  presum1[i+1]+  presum2[len+1]-presum2[i];
            max  =  Math.max(sum-s,max);
        }
        return  max;

    }
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m  = board.length;
        int n = board[0].length;
        int len  = word.length();
      boolean res =   iscol(board,word,0);
        for (int i = 0; i <m ; i++) {

        }

    }

    private boolean iscol(char[][] board, String word, int i) {
        char ch[] = board[i];
        String s = String.valueOf(ch);
        int len = word.length();
        int chlen = ch.length;
        for (int j = 0; j <ch.length; j++) {
            if(ch[j]=='#')continue;
            if(ch[j]==' '){
                int  a =0;
                int index =j;
                while (index<chlen&&(ch[index]==' '||(ch[j]>='a'&&ch[j]<='z')))index++;
                if(index==chlen&&index-j<len) return  false;
                String ss =  s.substring(j,index);
                

                if()

            }else{
                if()
            }
        }

    }


    class Node{
            int x;
            int y;
            int speed;
            public  Node(int x,int y,int speed){
                this.x =x;
                this.y =y;
                this.speed =speed;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return x == node.x &&
                        y == node.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
        int direct[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
            int m = terrain.length;int n =terrain[0].length;
            int x  =position[0];
            int y =position[1];
            Node source =  new Node(x,y,0);
            HashSet<Node> res = new HashSet<>();
            LinkedList<Node>  queue = new LinkedList<Node>();
            queue.offer(new Node(x,y,1));
            HashMap<Node,HashSet<Integer>>  map = new HashMap<>();
            while (!queue.isEmpty()){
                Node node = queue.poll();
                int newx =  node.x;int newy =node.y;int sp =  node.speed;
                // 四个方向走
                for (int i = 0; i < 4; i++) {
                    int xx = newx+direct[i][0];
                    int yy = newy+direct[i][1];
                    if(xx>=0&&yy>=0&&xx<m&&yy<n){
                        int speed =  terrain[newx][newy] -  terrain[xx][yy]-obstacle[xx][yy];
                        speed = sp+speed;
                        if(speed<=0) continue;
                        else{
                            Node newnode  = new Node(xx,yy,speed);
                            if(map.containsKey(newnode)&&map.get(node).contains(speed)) continue;
                            if(speed==1){if(!res.contains(newnode)) queue.offer(newnode);res.add(newnode);}
                            else queue.offer(newnode);
                            map.computeIfAbsent(newnode,(key)->new HashSet<>()).add(speed);
                        }
                    }
                }
            }

        res.remove(source);
        int siez =res.size();
        int a[][]=  new int[siez][2];
        int i =0;
        for(Node node : res){
            a[i++] = new int[]{node.x, node.y};
        }
        Arrays.sort(a,(b,c)->b[0]-c[0]);
        return  a;


    }
    long[] res;
    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        res = new long[finalCnt.length];
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int a[]:edges){
            int x = a[0];int y =a[1];
            map.computeIfAbsent(x,(key)->new ArrayList<>()).add(y);
            map.computeIfAbsent(y,(key)->new ArrayList<>()).add(x);
        }
       
        long l =1;
        long r = Integer.MAX_VALUE;
        while (l<r){
            long mid =  (l+r)/2;
            if(judge(mid,totalNum,edges,finalCnt,plans,map)-totalNum>=0){
                 r=mid;
            }else{
                 r= mid+1;
            }
        }
        int d[]=  new int[finalCnt.length+1];
        for (int i = 0; i < res.length; i++) {
            d[i] =(int)res[i];
        }
        return  d;

    }

    private long judge(long mid, long totalNum, int[][] edges, int[] finalCnt, int[][] plans,  HashMap<Integer,ArrayList<Integer>> map) {
        int len = finalCnt.length;
        long nums[] = new  long[len+1];
        for (int i = 0; i < finalCnt.length; i++) {
            nums[i+1] =finalCnt[i];
        }
        nums[0] = mid;
        for (int i = plans.length-1; i >=0 ; i--) {
            int a[] = plans[i];
            int id=a[1];int type =a[0];
            if(id==1){
                nums[i]*=2;
            }else if(id==2){
                ArrayList<Integer> list = map.get(id);
                for (Integer c:list) {
                     nums[c]-=nums[id];
                }
            }else{
                ArrayList<Integer> list = map.get(id);
                for (Integer c:list) {
                    nums[c]+=nums[id];
                }
            }
        }
        long s =0;
        for (int i = 0; i < len; i++) {
            s+=nums[i];
        }
        res = nums;
        return  s;

    }
}

//
//    private static boolean judge(HashSet<Integer> set, boolean[] vis,int pre ){
//        for (int i = 1; i <vis.length ; i++) {
//            if(vis[i]&&i!=pre){
//                if(set.contains(i))  return  false;
//            }
//        }
//        return  true;
//    }
    /**
     *
     6 7
     1 2
     2 3
     3 4
     4 5
     5 6
     1 6
     3 6
     */







