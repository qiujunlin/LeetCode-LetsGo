import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  n =  scanner.nextInt();
        int m =scanner.nextInt();
        int nums[] =new int[n];
        for (int i = 0; i <n ; i++) {
         nums[i] = scanner.nextInt();
        }
        int i =0;
        while (i<nums.length){
                if(i+m-1>=nums.length) break;
                int min = nums[i];
                boolean is =false;
                int start =i;
                for (int k = i; k <i+m ; k++) {
                    if(nums[k]==0) {
                        start = k+1;
                        is =true;
                        break;
                    }
                    if(nums[k]<min) {
                        min =nums[k];
                        start = k+1;
                    }
                }
                if(!is){
                    for (int k = i; k <i+m ; k++) {
                        nums[k] -= min;
                    }
                }
                i =start;
            }

        long rs =0;
        for(int a : nums)rs+=a;
        System.out.println(rs);





    }

    
}
