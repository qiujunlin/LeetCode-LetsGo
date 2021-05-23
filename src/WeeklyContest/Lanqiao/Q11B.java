package WeeklyContest.Lanqiao;

import java.util.HashMap;

public class Q11B {
    public static void main(String[] args) {
        int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        for (int i = 1900; i <= 9999; i++) {
            for (int j = 1; j <= 12; j++) {
                int day = days[j];
                if (j == 2) {
                    if (judge(i)) day = 29;
                }
                for (int d = 1; d <= day; d++) {
                    if (hashtwo(i) || hashtwo(j) | hashtwo(d)) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }

    private static boolean hashtwo(int d) {
        while (d != 0) {
            if (d % 10 == 2) return true;
            d = d / 10;
        }
        return false;
    }

    public static boolean judge(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) return true;
        return false;
    }
}
