import template.MaxPQ;

import java.math.BigInteger;
import java.util.*;
public  class  Main{
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        while (a>0){
            String s = scanner.nextLine();
            int b = scanner.nextInt();
            scanner.nextLine();
            String c = scanner.nextLine();

            String str[] = c.split(" ");
            int hash[] =new int[26];
            for (int i = 0; i <s.length() ; i++) {
                hash[s.charAt(i)-'a']++;
            }
            Arrays.sort(str,(e,f)->{
                String s1 = (String)e;
                String s2 = (String)f;
                return  s1.length()-s2.length();
            });
            int res =0;
       //     System.out.println(str.length);
            for (int i = 0; i < str.length; i++) {
                boolean is =false;
                for (int j = 0; j <str[i].length() ; j++) {
                     if(--hash[str[i].charAt(j)-'a']<0) is =true;
                }
                if(is){
                    for (int j = 0; j <str[i].length() ; j++) {
                        ++hash[str[i].charAt(j)-'a'];
                    }
                }else{
                    res++;
                }
            }
            System.out.println(res);

        }
    }
}
