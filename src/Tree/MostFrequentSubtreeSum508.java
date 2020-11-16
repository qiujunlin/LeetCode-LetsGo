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

    /**
     * 第一遍 超过百分之5
     * @param root
     * @return
     */
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

    /**
     * 第二次  改变为后序遍历 增加到了百分之20
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum2(TreeNode root) {
        findSum1(root);
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
    public int findSum1(TreeNode root){
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

    /**
     * 第三种解法 最快 90%
     */
    //Map<Integer,Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public int[] findFrequentTreeSum3(TreeNode root) {
        findSum(root);
        int max=0;//记录最大的次数
        //遍历map，map中的和（key）是不会重复的，然后将其中的次数最多的加到set里面。
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();//将max更新
                set.clear();//清除set里的所有数据
                set.add(entry.getKey());//从新加入
            }else if(entry.getValue()==max){//如果次数相同 直接加入就可以了
                set.add(entry.getKey());
            }
        }
        //把set结果集里面的放入数组
        int a[] = new int[set.size()];
        int index=0;
        for(Integer c:set){
            a[index++]=c;
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
        int count= map.getOrDefault(sum,0)+1;
        map.put(sum,count);
        return sum;
    }
}
