package Contest.week;

import java.util.HashMap;
import java.util.TreeMap;

public class StockPrice {
    TreeMap<Integer,Integer> map = new TreeMap<>();
    TreeMap<Integer,Integer> c = new TreeMap<>();

    public StockPrice() {


    }

    public void update(int timestamp, int price) {
         if(map.containsKey(timestamp)){
             c.put(map.get(timestamp),c.get(map.get(timestamp))-1);
             if(c.get(map.get(timestamp))==0) c.remove(c.get(timestamp));
             map.put(timestamp,price);
             c.put(price,c.getOrDefault(price,0)+1);
         }
    }

    public int current() {
      return   map.lastKey();
    }

    public int maximum() {
        return c.lastKey();
    }

    public int minimum() {
        return  c.firstKey();

    }
}
