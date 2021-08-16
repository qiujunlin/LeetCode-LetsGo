package Test.bishi;

import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer,Integer> direct = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            int  d = scanner.next().charAt(0)=='L'?0:1;
            set.add(num);
            direct.put(num,d);
        }
        int l  =-1;
        HashMap<Integer,Integer> res = new HashMap<>();
        int t = 0;

    }
    public  int getmin(String s){
       int len  = s.length();
       StringBuilder sb  = new StringBuilder(s);
        for (int i = 0; i < len&&!isTrue(sb.toString()); i++) {
            sb.insert(len,s.charAt(i));
        }
        return sb.length()-len;

    }
    public  boolean isTrue(String s) {  //判断是否回文
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
               return  false;
            }
        }
        return true;
    }
    int res  = 0;


}
