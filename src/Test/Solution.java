package Test;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        new Solution().main();
    }
     class  Tree {
        int num ;
        int val;
        long count = 1;
        long mul = 0;
        ArrayList<Tree> nodes = new ArrayList<>();

        public Tree(int val,int num ) {
            this.val = val;
            this.num =  num;
        }
        public void add(Tree tree) {
            this.nodes.add(tree);
        }
        public  ArrayList<Tree> getNodes() {return nodes;}
    }
    int sumtree=0;
     long maxmul =0;
     int   n = 0;
    long sum  =0;
    public  void main() {
        Scanner scanner = new Scanner(System.in);
         n  = scanner.nextInt();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int arr[] = new int[n-1];

        for (int i = 0; i < n-1; i++) {
            arr[i] = scanner.nextInt();
            map.computeIfAbsent(arr[i],(key)->new ArrayList<>()).add(i+1);
            map.computeIfAbsent(i+1,(key)->new ArrayList<>()).add(arr[i]);
        }
        HashSet<Integer> set = new HashSet<>();
        int weight[] = new int[n];
        for (int i = 0; i <n ; i++) {
            weight[i] = scanner.nextInt();
            sum+=weight[i];
        }
        Tree root   = new Tree(weight[0],1);
        set.add(1);
        Queue<Tree> trees = new LinkedList<>();
        trees.add(root);
        while(!trees.isEmpty()){
            int size  =  trees.size();
            for (int i = 0; i <size ; i++) {
                Tree node = trees.poll();
                int num = node.num;
                for(int c : map.get(num)){
                    if(!set.contains(c)){
                        set.add(c);
                        Tree tree = new Tree(weight[c-1],c);
                        node.getNodes().add(tree);
                        trees.offer(tree);
                    }
                }
            }
        }
        backdfs(root);
        backdfs2(root);
        backdfs3(root,null);
        System.out.println(sumtree);
        System.out.println(maxmul);

    }
    private void backdfs3(Tree root, Tree pre) {
        if(pre!=null) {
            sumtree += root.count * (n - root.count) ;
            maxmul = Math.max(root.mul * (sum - root.mul) - root.val * pre.val, maxmul);
        }
        for(Tree node:root.getNodes()){
            backdfs3(node,root);
        }
    }
    private  long backdfs2(Tree root) {
        if(root==null)  return  0;
        long mul  =0;
        for(Tree node:root.getNodes()){
            mul+=backdfs(node);
        }
        root.mul =  mul+root.val;
        return  root.mul;
    }
    private  long backdfs(Tree root) {
        if(root==null)  return  0;
        long sum  =0;
        for(Tree node:root.getNodes()){
           sum+= backdfs(node);
        }
        root.count = sum+root.count;
        return  root.count;
    }
}
