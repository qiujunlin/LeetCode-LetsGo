package Contest.week;

import java.util.*;

public class SockPrice {
    static  class Node implements Comparable{
        int cur;
        int price;

        public Node(int cur, int price) {
            this.cur = cur;
            this.price = price;
        }

        @Override
        public int compareTo(Object o) {
            Node node =  (Node)o;
            return this.price-node.price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return cur == node.cur &&
                    price == node.price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cur, price);
        }
    }
    TreeSet<Node>  set= new TreeSet<>();
    HashMap<Integer,Node>  map= new HashMap();
    int max  =0;
    public SockPrice() {
       // map = new TreeMap<>();
    }
    public void update(int timestamp, int price) {
       // map.put(timestamp,price);
        Node node = new Node(timestamp,price);
        if(map.containsKey(timestamp)){
            set.remove(map.get(timestamp));
            set.add(node);
            map.put(timestamp,node);
        }else{
            map.put(timestamp,node);
            set.add(node);
        }
        max =Math.max(max,timestamp);
    }

    public int current() {
        return   map.get(max).price;
    }

    public int maximum() {
        return  set.last().price;
    }

    public int minimum() {
        return  set.first().price;

    }
}
