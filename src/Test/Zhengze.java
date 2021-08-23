package Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Zhengze {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9%,:_@&~!=\\<\\>\\|\\[\\]\\{\\} /\\.\\+\\-\\*\\^\\?\\$]+$");
        Pattern pattern2 = Pattern.compile("^[A-Za-z0-9%,:_@&~!=\\<\\>\\|\\[\\]\\{\\} /\\.\\+\\-\\*\\^\\?\\s\\(\\)\\$]+$");
        Pattern pattern1 = Pattern.compile("^[0-9]+$");
        System.out.println(pattern2.matcher("noew() as daye  ").matches());
        String s = "10.3213";
        Object o = s;
    //    System.out.println(o instanceof  Number);
        System.out.println(getParams("tre"));

    }

    public static String[] getParams(String origin) {
        ArrayList<String> arrayList =new ArrayList<>();
        int k =0;
        char c = ' ';
        while (k<origin.length()){
            if((c=origin.charAt(k))!=' '){
                if(c=='\''){
                    int l  =k+1;
                    while (l<origin.length()&&origin.charAt(l)!='\''){
                        l++;
                    }
                    arrayList.add(origin.substring(k,l+1));
                    k =l+1;
                }else{
                    int l  =k+1;
                    while (l<origin.length()&&origin.charAt(l)!=' '){
                        l++;
                    }
                    arrayList.add(origin.substring(k,l));
                    k =l+1;
                }
            }else{
                k++;
            }

        }
        return  arrayList.toArray(new String[arrayList.size()]);

    }

}
