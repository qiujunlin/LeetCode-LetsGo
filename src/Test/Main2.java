package Test;


import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int nums[] = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    left[i] = Math.max(left[j] + 1, left[i]);
                }
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] >= nums[j]) {
                    right[i] = Math.max(right[j] + 1, right[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(left[i] + right[i] - 1, max);
        }
        System.out.println(max);

    }
    int nums [];
    public int[] shuffle() {
          Random random = new Random();
          int i =0;
          int res[] = new int[nums.length];
        for (int j = 0; j <res.length ;j++) {
              int index = random.nextInt()*(nums.length-j)+j;
              int temp =nums[index];
              nums[index] =nums[j];
              nums[j] =temp;
        }
        return  res;

    }


}
