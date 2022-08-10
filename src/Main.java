import java.util.*;
public  class  Main{
    public static void main(String[] args) {
       int nums[] = new int[100000];
       Random  random =new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(Integer.MAX_VALUE);
        }
        long cur = System.currentTimeMillis();
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums.length ; j++) {
                 if(nums[j]<nums[i]){
                     int temp = nums[j];
                     nums[j] =nums[i];
                     nums[i] =temp;
                 }
            }
        }
        long ne = System.currentTimeMillis();
        System.out.println("tiem : " + (ne-cur));
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
