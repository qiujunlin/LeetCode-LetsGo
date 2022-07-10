package Contest.week;

import java.util.HashSet;
import java.util.TreeSet;

public class SmallestInfiniteSet {
    HashSet<Integer> set =new HashSet<>();
    int min =1;
    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        int res =   min;
        set.add(min);
        while (set.contains(min)){
            min++;
        }
        return  res;
    }

    public void addBack(int num) {
        if(num<min) min =num;
        set.remove(num);
    }
}
