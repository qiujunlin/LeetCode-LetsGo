package Test;


import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
       String s  ="汉";
       byte[] b = s.getBytes();
       for (int i = 0; i <b.length ; i++) {
            System.out.println(Integer.toHexString(Integer.valueOf(b[i])));
        }
        System.out.println(b.length);


    }


}
