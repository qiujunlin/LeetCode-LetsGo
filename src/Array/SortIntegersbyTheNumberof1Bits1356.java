package Array;

import java.util.*;

/**
 * @Classname SortIntegersbyTheNumberof1Bits1356
 * @Description:
 * @Date 2020/11/6 12:19
 * @Created by qiujunlin
 */
public class SortIntegersbyTheNumberof1Bits1356 {
    //第一次代码  速度超过百分之5
    public int[] sortByBits(int[] arr) {

        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums,(Integer a,Integer b)->{
            int res1=cout(a);
            int res12=cout(b);
            return res1==res12?a-b:res1-res12;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
    int cout(int n){
        int res=0;
        while(n!=0){
            if(n%2==1) res++;
            n = n/2;
        }
        return   res;
    }
    //版本2 使用Integer.bitCount(a)方法后性能 超过了百分之50
    public int[] sortByBits2(int[] arr) {
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<arr.length;i++){
        //   map.put(arr[i],cout(arr[i]));
        // }
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums,(Integer a,Integer b)->{
            int res1=Integer.bitCount(a);//使用了移位操作 就很快
            int res12=Integer.bitCount(b);
            return res1==res12?a-b:res1-res12;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
    //第三种 超级超级巧妙的方法 记住
    public int[] sortByBits3(int[] arr) {
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i] % 10000000;
        }
        return map;
    }


}
