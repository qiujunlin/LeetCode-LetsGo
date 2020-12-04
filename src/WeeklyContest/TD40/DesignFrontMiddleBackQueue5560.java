package WeeklyContest.TD40;

import java.util.*;

/**
 * @Classname DesignFrontMiddleBackQueue5560
 * @Description:
 * @Date 2020/11/29 11:23
 * @Created by qiujunlin
 */
class FrontMiddleBackQueue {
    LinkedList<Integer>  list;
    public FrontMiddleBackQueue() {
        list = new LinkedList();
    }

    public void pushFront(int val) {
        list.addFirst(val);
    }

    public void pushMiddle(int val) {
        int index=list.size();
        list.add(index/2,val);
    }

    public void pushBack(int val) {
        list.addLast(val);
    }

    public int popFront() {
        if(list.size()==0) return -1;
        int res=list.getFirst();
        list.removeFirst();
        return res;
    }

    public int popMiddle() {
        if(list.size()==0) return -1;
        int res=0;
        if(list.size()%2==0){
            res= list.get(list.size()/2-1);
            list.remove(list.size()/2-1);}else{
            res=list.get(list.size()/2);
            list.remove(list.size()/2);
        }
        return res;
    }

    public int popBack() {
        if(list.size()==0) return -1;
        int res=list.getLast();
        list.removeLast();
        return res;
    }
}

