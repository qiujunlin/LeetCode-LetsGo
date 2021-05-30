package WeeklyContest.Lanqiao;

import java.util.HashMap;

public class QG11C {
    public static void main(String[] args) {
        //求2-100 每个数的质数分解
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=2;i<=100;i++){
            int num = i;
            for(int j=2;j*j<=num;j++){
                if(num%j==0){
                    while (num%j==0){
                        num= num/j;
                        map.put(j,map.getOrDefault(j,0)+1);
                    }
                }
            }
            if(num>1) map.put(num,map.getOrDefault(num,0)+1);
        }
        long res =1;
        for(int key :map.keySet()){
            res*=(map.get(key)+1);
        }

        System.out.println( res);
    }

}
