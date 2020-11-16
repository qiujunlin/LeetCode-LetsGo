package Tree;

import java.util.*;

/**
 * @Classname MostFrequentSubtreeSum508
 * @Description:
 * @Date 2020/11/16 12:29
 * @Created by qiujunlin
 */
public class MostFrequentSubtreeSum508 {
    Map<Integer,Integer> map = new HashMap<>();
    //第一遍 超过百分之5
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return (e2.getValue()).compareTo(e1.getValue());
            }
        });

        int i=1;
        List<Integer> res = new ArrayList<>();
        res.add(list.get(0).getKey());
        while(i<list.size()&&list.get(i).getValue()==list.get(i-1).getValue()){
            res.add(list.get(i).getKey());
            i++;
        }
        int a[] = new int[res.size()];
        for(int j=0;j<res.size();j++){
            a[j]=res.get(j);
        }
        return a;
    }
    void dfs(TreeNode root){
        if(root==null) return ;
        int sum= sumdfs(root);
        map.put(sum,map.getOrDefault(sum,0)+1);
        dfs(root.left);
        dfs(root.right);
    }
    int sumdfs(TreeNode root){
        if(root==null) return 0;
        int left=sumdfs(root.left);
        int right = sumdfs(root.right);
        return root.val+left+right;
    }
    public static void main(String[] args) {
        TreeNode noe1 = new TreeNode(5);
        TreeNode noe2 = new TreeNode(2);
        TreeNode noe3 = new TreeNode(-3);
        noe1.left=noe2;
        noe1.right=noe3;
        System.out.println(new MostFrequentSubtreeSum508().findFrequentTreeSum(noe1));
    }
    //第二次  改变为后序遍历 增加到了百分之20
    public int[] findFrequentTreeSum2(TreeNode root) {
        findSum(root);
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return (e2.getValue()).compareTo(e1.getValue());
            }
        });

        int i=1;
        List<Integer> res = new ArrayList<>();
        if(list.size()>0)
            res.add(list.get(0).getKey());
        while(i<list.size()&&list.get(i).getValue()==list.get(i-1).getValue()){
            res.add(list.get(i).getKey());
            i++;
        }
        int a[] = new int[res.size()];
        for(int j=0;j<res.size();j++){
            a[j]=res.get(j);
        }
        return a;
    }
    public int findSum(TreeNode root){
        if(root == null){
            return 0;
        }
        //计算左子树的和
        int left = findSum(root.left);
        //计算右子树的和
        int right = findSum(root.right);
        //计算当前子树的和
        int sum = root.val + left + right;
        //将结果放入HashMap中，并计算出出现的最多次数
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
}
