import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn =new Scanner(System.in);
        int n =scn.nextInt();
        int m =scn.nextInt();
        StringBuilder s =new StringBuilder();
        for (int i = 0; i <n ; i++) {
            s.append("R");
        }
        s.append("P");
        for (int i = 0; i <m ; i++) {
            s.append("R");
        }
        System.out.println(s);






    }
}
