package Contest.week;

import jdk.nashorn.internal.ir.BaseNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @description: NO
 * @author: qiujunlin
 * @create: 2021-09-19 10:27
 */
public class W259 {
    public int finalValueAfterOperations(String[] operations) {
        int  x= 0;
        for(String s :  operations){
            if(s.startsWith("++")||s.endsWith("++")) x++;
            else x--;
        }
        return  x;


    }
    public int sumOfBeauties(int[] nums) {
        int max[] = new  int[nums.length]; max[0] =nums[0];
        int min[] =  new int[nums.length]; min[nums.length-1] =nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            max[i]  =Math.max(nums[i],max[i-1]);
        }
        for (int i = nums.length-2; i >=0 ; i--) {
             min[i] =Math.min(nums[i],min[i+1]);
        }
        int res =0;
        for (int i = 1; i < nums.length-1; i++) {
            if(max[i-1] <nums[i]&&nums[i]<min[i+1]){
                res+=2;
            }else if(nums[i]>nums[i-1]&&nums[i]<nums[i+1]){
                res+=1;
            }



        }
        return  res;


    }
    //5000 *5000   5000*5000*5000
    class  Node{
        int x =0;
        int y =0;
        public Node(int x,int y){
            this.x =x;
            this.y = y;
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

   HashMap<Node,Integer>  map =  new HashMap<>();
   HashMap<Integer, ArrayList<Node>>  map1 =  new HashMap<>();
   HashMap<Integer,ArrayList<Node>>  map2 =  new HashMap<>();
    public void  DetectSquares() {

    }

    public void add(int[] point) {
        Node  n =  new Node(point[0],point[1]);
        map.put(n,map.getOrDefault(n,0)+1);
        map1.computeIfAbsent(point[0],(key)->new ArrayList<>()).add(n);
        map1.computeIfAbsent(point[1],(key)->new ArrayList<>()).add(n);

    }

    public int count(int[] point) {
        ArrayList<Node>  nodesx =  map1.get(point[0]);
        ArrayList<Node>  nodesy =  map2.get(point[1]);
        if(nodesx==null||nodesy==null) return  0;
        int count  =0;
        for(Node nodex :  nodesx){
            int xlen =  point[1]-nodex.y;
            Node n1 = new Node(nodex.x-xlen,nodex.y);
            Node n2 = new Node(nodex.x+xlen,nodex.y);
            if(map.containsKey(n1)){
                int xlen1 =  nodex.y-n1.y;
                int ylen =  nodex.x-point[0];
                if(Math.abs(xlen1)!=Math.abs(ylen)) continue;
                if(xlen==0||ylen==0) continue;
                Node node = new Node(n1.x,point[1]);
                if(map.containsKey(node)){
                    count+=map.get(node);
                }
            }
            if(map.containsKey(n2)){
                int xlen1 =  nodex.y-n1.y;
                int ylen =  nodex.x-point[0];
                if(Math.abs(xlen1)!=Math.abs(ylen)) continue;
                if(xlen==0||ylen==0) continue;
                Node node = new Node(n1.x,point[1]);
                if(map.containsKey(node)){
                    count+=map.get(node);
                }
            }

        }
        return  count;
    }

}
