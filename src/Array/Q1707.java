package Array;

import java.util.Arrays;



public class Q1707 {
    class Tire {
        Tire left;
        Tire right;

        public Tire() {
            left = null;
            right = null;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Tire tire = new Tire();
        int res[] = new int[nums.length];
        int newq[][] = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            newq[i][0] = queries[i][0];
            newq[i][1] = queries[i][1];
            newq[i][2] = i;
        }
        Arrays.sort(nums);
        Arrays.sort(newq, (a, b) -> a[1] - b[1]);
        int index = 0;
        for (int i = 0; i < newq.length; i++) {
            int len = newq[i][1];
            while (index<nums.length&&nums[index] <= len) {
                add(tire, nums[index]);
                index++;
            }
            int max  = -1;
            if(tire.left!=null||tire.right!=null){
                max = getmaxXOR(tire,newq[i][0]);
            }
            res[newq[i][2]]= max;
        }
       return res;
    }

    private int getmaxXOR(Tire tire, int num) {
        int x =0;
        for(int i=30;i>=0;i--){
            int n = (num>>i)&1;
            if(n==1){
                if(tire.left!=null){
                    x=  x*2+1;
                    tire=tire.left;
                }else{
                    tire=tire.right;
                    x =x*2;
                }

            }else{
                if(tire.right!=null){
                    x= x*2+1;
                    tire=tire.right;
                }else {
                  x= x*2;
                  tire=tire.left;
                }
            }
        }
        return  x;
    }

    private void add(Tire tire, int num) {
        for(int i=30;i>=0;i--){
            int n = (num>>i)&1;
            if(n==1){
                if(tire.right == null){
                    tire.right =  new Tire();
                }
                tire = tire.right;
            }else{
                if(tire.left ==null){
                    tire.left =  new Tire();

                }
                tire =  tire.left;

            }
        }
    }
}



