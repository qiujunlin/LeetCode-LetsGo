import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class test {
    @Test
    public  void test1(){
     List<Integer> lsit = new ArrayList<>();
     lsit.add(1);
     lsit.add(2);
     lsit.add(3);
     List<Integer> list2= new ArrayList<>(lsit);
     List<Integer> list3 = new ArrayList<>();
     list3.addAll(lsit);
     list3.set(1,200);
        Collections.addAll(lsit,9);
        List<Integer> list4 = new ArrayList<>();
        Collections.copy(list4,lsit);

     list2.set(1,100);
        System.out.println(lsit);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);


    }
}
