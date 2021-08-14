package Test;

/*
FE65CDBA
2147483647
4268084666
 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

       int a[]= {100,1,101,2,3,4,5,6,7,8,9,10,11};
        System.out.println(new Main2().judgeTree(a,a.length));

    }
    static class  Tree{
        int val;
        int leftdepth=0;
        int rihtdepth=0;
        Tree left ;
        Tree right;
        public  Tree(int val){
            this.val  = val;
        }
    }
    static  int min  =0;
    static  boolean judgeTree(int nums[],int n){
      min  = Math.min(11,n/2);
      Tree root = new Tree(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            change  = root;
            if(root.val<nums[i]) leftright = true;
            else leftright = false;
            builder(root,nums[i]);
        if (!add(change,leftright)) return  false;
        }
        return  true;
    }

    private static boolean add(Tree change, boolean leftright) {

        if(leftright){
            change.rihtdepth++;
            if(Math.abs(change.rihtdepth-change.rihtdepth)>min) return  false;
            if(change.right!=null);
            add(change.right,leftright);
        }else{
            change.leftdepth++;
            if(change.left!=null)
            add(change.left,leftright);
        }
        return  true;
    }

    static Tree change ;
    static  boolean leftright = true;  // true:right,false: left;
    private static void builder(Tree root, int num) {
        if(root.val<num){ //往右走
            if(root.right==null){
                if(leftright){  //本来往右
                }else {//本来往左
                    change = root;
                    leftright = true;
                }
                root.right = new Tree(num);
            }else{
                if(leftright){
                    builder(root.right,num);
                }else {  //本来往左
                    change = root;
                    leftright = true;
                    builder(root.left, num);
                }
            }
        }else{ // 往左走
            if(root.left==null){
                if(leftright){// 如果本来是往右
                    change = root;
                    leftright = false;
                }
                root.left= new Tree(num);
                return;
            }else{// 不为空
                if(leftright){// 如果本来是往右
                    change = root;
                    leftright = false;
                }else{
                    builder(root.left,0);
                }
                builder(root.left,num);
            }
        }
    }
}
