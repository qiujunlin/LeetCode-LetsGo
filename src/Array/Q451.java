package Array;

import java.util.Arrays;

public class Q451 {
    public String frequencySort(String s) {

         int hash[] = new int[123];
         Character ch[] = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
            ch[i] = s.charAt(i);
        }
        System.out.println(hash['a']);
        System.out.println(hash['b']);
        Arrays.sort(ch,(a,b)->(hash[b]==hash[a])?(a.compareTo(b)):hash[b]-hash[a]);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ch.length; i++) {
            stringBuffer.append(ch[i]);
        }
        return  stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q451().frequencySort("abab"));
    Character a = 'a';
    Character b ='a';
        System.out.println(a==b);
    }
}
