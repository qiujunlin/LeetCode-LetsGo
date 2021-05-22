package Array;

import java.util.HashSet;

class Tire{
    Tire left;
    Tire right ;
    public  Tire(){
        this.left = null;
        this.right = null;
    }
}
public class Q421 {
    public static void main(String[] args) {

    }
    public void add(int num,Tire tire){
        for(int i=30;i>=0;i--){
            int n = (num>>i)&1;
            if(n == 1){
                if(tire.right==null){
                    tire.right = new Tire();
                    //tire = tire.right;
                }
                tire  = tire.right;
            }else{
                if(tire.left == null){
                    tire.left = new Tire();
                }
                tire =  tire.left;
            }
        }
    }

    public int findMaximumXOR2(int[] nums) {
           Tire  tire = new Tire();
           int res = 0;
           for(int num :  nums){
               add(num,tire);
               res  = Math.max(res,findmax(tire,num));
           }
           return  res;
    }

    private int findmax(Tire tire, int num) {
        int x =0;
        for(int i=30;i>=0;i--){
            int n =  (num>>i)&1;
            if(i==1){
                if(tire.left!=null){
                    x =  x*2+1;
                    tire  =  tire.left;
                }else{
                    x= x*2;
                    tire =  tire.right;
                }
            }else{
                if(tire.right!=null){
                    x =  x*2+1;
                    tire  = tire.right;
                }else{
                    x = x*2;
                    tire = tire.left;
                }
            }
        }
        return  x ;

    }

    public int findMaximumXOR(int[] nums) {
        //寻找数组里异或z最大值、
        int x = 0;
        for(int i=30;i>=0;i--){
            HashSet<Integer>  set =  new HashSet<>();
            //将前320 - i 位的数字加入hashset中
            for(int num : nums) {
                set.add(num>>i);
            }
            //贪心 定义最大值
            int newx = x*2 + 1;
            boolean flag = false;
            for(int num :  nums) {
                if (set.contains((num >> i) ^ newx)) {
                    flag = true;
                    break;
                }
            }

            if(flag)  {
                x = newx;
            }else{
                x  =  newx-1;
            }

        }
        return  x ;


    }
}
