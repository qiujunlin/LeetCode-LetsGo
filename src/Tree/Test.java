package Tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        LinkedList<Integer> queue2 = new LinkedList<>();
        queue2.removeLast();
        Collections.copy(queue2,queue);
        System.out.println(queue2);
    }
}
