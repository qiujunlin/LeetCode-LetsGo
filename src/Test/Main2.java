package Test;

/*
FE65CDBA
2147483647
4268084666
 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("\"^[0-9a-zA-Z_]+$\"");
        System.out.println(pattern.matcher("second".substring(1)).matches());

    }

}
