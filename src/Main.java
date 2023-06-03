import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
// testmaster
public class Main {
    static class Node{
        int val;
        int color;
        ArrayList<Node> nodes =new ArrayList<>();
        public Node(int val,int color){
            this.val =val;
            this.color =color;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        HashMap<Integer,Node>  map= new HashMap<>();
        for (int i = 1; i <=n ; i++) {
            char c = s.charAt(i-1);
            if(c=='R'){
                map.put(i,new Node(i,0));
            }else{
                map.put(i,new Node(i,1));
            }
        }
        for (int i = 0; i <n-1 ; i++) {
            int par =  scanner.nextInt();
            map.get(par).nodes.add(map.get(i+2));
        }
        res =0;
        int ress[] =  dfs(map.get(1));
        System.out.println(res);
    }
    static int res= 0;
    private static int[] dfs(Node node) {

        int l =0;
        int r =0;
        if(node.nodes.size()!=0){
            for(Node n:node.nodes){
               int  res[]  =  dfs(n);
               l += res[0];
               r += res[1];
            }
        }
        if(l==r) res++;
        if(node.color==0) l++;
        else r++;
        return  new int[]{l,r};
    }

}

/**
 3 3 3
 BBR
 BRB
 RBB
 0 1 10
 2 10 100
 10 100 100
 */
