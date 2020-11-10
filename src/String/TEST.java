package String;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class TEST {
    public static void main(String[] args) {
     int a[]= new int[]{2,3,1,4,6};
       Arrays.sort(a,1,4);
        for (int s:
             a) {
            System.out.println(s);
        }
        System.out.println(a);


    }

}
