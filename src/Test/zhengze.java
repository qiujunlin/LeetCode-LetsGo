package Test;

import java.util.regex.Pattern;

public class zhengze {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9%,:_@&~!=\\<\\>\\|\\[\\]\\{\\} /\\.\\+\\-\\*\\^\\?\\$]+$");
        Pattern pattern2 = Pattern.compile("^\\'[A-Za-z0-9%,:_@&~!=\\<\\>\\|\\[\\]\\{\\} /\\.\\+\\-\\*\\^\\?\\$]\\'+$");

        System.out.println(pattern2.matcher("'dsad'").matches());
    }
}
