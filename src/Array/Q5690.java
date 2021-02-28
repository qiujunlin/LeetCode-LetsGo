package Array;

import java.util.*;

/**
 * @Classname Q5690
 * @Description:
 * @Date 2021/2/28 10:56
 * @Created by qiujunlin
 */
public class Q5690 {
   //// TreeSet<Integer>  set= new TreeSet<>(Collections.reverseOrder());
    List<Integer> list = new ArrayList<>();
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

        for(int i =0;i<baseCosts.length;i++){
            dfs(toppingCosts,0,baseCosts[i],target);
        }
        int res =0;
        Collections.sort(list);
        int dayu=Integer.MAX_VALUE;
        int xiaoyu =Integer.MIN_VALUE;
        for(int a :list){
            if(a==target) return  target;
            else if(a>target){
                dayu = Math.min(a,dayu);
            }else if(a<target){
                xiaoyu =Math.max(a,xiaoyu);
            }
        }
        if(Math.abs(dayu-target)>Math.abs(xiaoyu-target)){
            return  xiaoyu;
        }else return  dayu;
        //return  0;

    }
    void dfs(int []cost,int index,int total,int target){
        if(index==cost.length){
            return;
        }
        for(int i=0;i<=2;i++){
            //total=total+cost[index];
           // int a = total+i*cost[index];
            //if(set.first()>target&&a>set.first()) return;
            list.add(total+i*cost[index]);
            dfs(cost,index+1,total+i*cost[index],target);
        }
    }
}
