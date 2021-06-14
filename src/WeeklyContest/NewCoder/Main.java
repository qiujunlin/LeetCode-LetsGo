package WeeklyContest.NewCoder;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        HashMap<String,HashSet<String>> map = new HashMap<>();
        for(int i=0;i<num;i++){
            String a = scanner.nextLine();
            String s[] = a.split(" ");
            if(!map.containsKey(s[0])){
                map.put(s[0],new HashSet<>());
                map.get(s[0]).add(s[1]);
                System.out.println("YES");
            }else{
                if(map.get(s[0]).contains(s[1])) System.out.println("NO");
                else {
                    System.out.println("YES");
                    map.get(s[0]).add(s[1]);
                }
            }


        }

    }
}
