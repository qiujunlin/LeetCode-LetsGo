package Test;
import edu.princeton.cs.algs4.Stack;

import  java.util.*;
public class Main3 {
    class Node{
        Node nodes[] ;
        boolean end ;
        public Node(){
            this.nodes = new Node[26];
            this.end= false;
        }
    }
    String res ="";
    public String longestWord(String[] words) {
        //字典树  1. 构建树  2 dfs
        Node n = new Node();
        for(String s :  words){
            Node  temp = n;
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(temp.nodes[c-'a']==null){
                    temp.nodes[c-'a'] =new Node();
                }
                temp = temp.nodes[c-'a'];
            }
            temp.end = true;
        }

        return "";
    }
    void dfs(Node n,String s){
        if(res.length()<s.length()){
            res =s;
        }
        for(int i =0;i<26;i++){
            if(n.nodes[i]!=null){
                if(n.end){
                    dfs(n.nodes[i],s+String.valueOf((char)(i+'a')));
                }
            }
        }
    }
     public static void main(String[] args) {
        int nums[] ={1,2,3,4};
        int nums2[] ={4,3,2,4,3};
        new Main3().fun(5,3,nums2);

    }
    public  void fun(int n,int m,int nums[]){
        Stack<Integer> stack =  new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                  int a  =stack.pop();
                  int c = -1;
                  if(!stack.isEmpty())c = stack.peek();
                  int count =0;
                  if(c!=-1) {
                      if(i==n-1&nums[c]>nums[i]) {
                          count = (i-a)*(nums[i]-nums[a]);
                      }else
                      count = (i - a) * (nums[c] - nums[a]);
                      if(m-count<=0){
                          System.out.println(m%(i-a)==0?c+2:i-m%(i-a)+1);
                          return;
                      }else m-=count;
                  }else{
                      count =  (nums[i]-nums[a])*i;
                      if(m-count<=0){
                          System.out.println(m%a==0?1:i-m%a+1);
                          return;
                      }else m-=count;
                }
            }
            stack.push(i);
        }
        System.out.println(n+1);
    }


}