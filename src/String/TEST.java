package String;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class TEST {

    public static void main(String[] args) {
        System.out.println(new TEST().tree4(999999999));





    }

    public long tree4 (long n) {
        long res=0;
        int level=1;
        while(Math.pow(2,level)-1<n){
           level++;
        }

        int i=1;
        int num=1;
        while(i<level){
            for(int j=0;j<num;j++){
                res=res+i*(num+j);
            }
            i++;
            num*=2;
        }
        for(int j=0;j<n-Math.pow(2,level-1)+1;j++){
            res=res+level*(num+j);
        }

        return res%998244353;
    }


}
