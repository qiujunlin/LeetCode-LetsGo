package leetcode;
import  java.util.*;
public class Main {
    public static void main(String[] args) {
       String s ="(()())()";
        System.out.println(new Main().scoreOfParentheses(s));
    }


    //
    List<List<Integer>>  res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    boolean vis [];
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        dfs(nums);
        return  res;
    }

    private void dfs(int[] nums) {
        if(list.size()==nums.length) res.add(new ArrayList<>(list));
        for(int j  =0;j<nums.length;j++){
            if(vis[j]) continue;
            if(j>0&&nums[j]==nums[j-1]&&!vis[j-1]) continue;
            list.add(nums[j]);
            vis[j]= true;
            dfs(nums);
            vis[j]= false;
            list.remove(list.size()-1);
        }
    }
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(2);
        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(2);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(v*2+1);
            }
        }

        return stack.pop();
    }

}
