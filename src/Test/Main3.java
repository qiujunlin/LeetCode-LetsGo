package Test;
import edu.princeton.cs.algs4.Stack;

import  java.util.*;
public class Main3 {

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