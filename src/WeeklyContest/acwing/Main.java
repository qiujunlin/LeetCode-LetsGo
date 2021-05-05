package WeeklyContest.acwing;

import java.util.*;

/**
 * @Classname Main
 * @Description:
 * @Date 2021/5/5 21:53
 * @Created by qiujunlin
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num= scanner.nextLong();
        long day =  24*60*60*1000;
        long a = num%day/1000;
        long h = a/(60*60);
        long min= a%(60*60);
        long m = min/(60);
        long sec = min%(60);

        System.out.println(h+":"+min+":"+sec);
    }
}
