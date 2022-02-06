package Contest.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class W279 {
    public static void main(String[] args) {
        System.out.println("dasd");
    }
    public int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer> list1 =new ArrayList<>();
        ArrayList<Integer> list2 =new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            if(i%2==1){
                list1.add(nums[i]);
            }else{
                list2.add(nums[i]);
            }
        }
        Collections.sort(list1);
        Collections.reverse(list1);
        Collections.sort(list2);
        for (int i = 0; i <list1.size() ; i++) {
            nums[i*2+1] =list1.get(i);
        }
        for (int i = 0; i <list2.size() ; i++) {
            nums[i*2] =list2.get(i);
        }
        return  nums;
    }
    public long smallestNumber(long num) {
        if(num==0) return   0;
        if(num>0) {
            String s = String.valueOf(num);
            char c[] = s.toCharArray();
            Arrays.sort(c);
            int i =0;
            while (i<s.length()&&c[i]=='0'){
                 i++;
            }
            char temp = c[i];
            c[i] ='0';
            c[0] =temp;
            String res = new String(c);
            return  Long.valueOf(res);

        }else{
            String s = String.valueOf(num);
            s =s.substring(1,s.length());
            char c[] = s.toCharArray();
            Arrays.sort(c);
            StringBuilder res =new StringBuilder();
            for (int i = c.length-1; i >=0 ; i--) {
                res.append(c[i]);
            }
            String r =res.toString();
            Long rs = Long.valueOf(r);
            return  -rs;
        }

    }
}
