package interview;



import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner  =new Scanner(System.in);
        int a = scanner.nextInt();
        int b =scanner.nextInt();
        int year  = scanner.nextInt();
        int month = scanner.nextInt();
        int day  = scanner.nextInt();
        String s = String.valueOf(year)+String.valueOf(month)+String.valueOf(day);
        long min=-1;
        long soure =Long.parseLong(s);
        int len1 =String.valueOf(year).length();
        int len2 =String.valueOf(month).length();
        int len3 =String.valueOf(day).length();
        for (int k = year; k <=100000 ; k++) {

            for (int i = month + 1; i <= a; i++) {
                for (int j = 1; j <= day; j++) {
                    String ss = String.valueOf(k) + String.valueOf(i) + String.valueOf(j);
                    if (judge(ss)) {
                        System.out.println(year + " " + i + " " + j);
                        break;
                    }
                }
            }
        }


    }

    private static boolean judge(String ss) {
        int l =0;int r =ss.length()-1;
        while (l<r){
            if(ss.charAt(l)== ss.charAt(r)) {
                l++;r--;
            }else{
                break;
            }
        }
        return   l==r;
    }

}