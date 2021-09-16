package leetcode;
import  java.util.*;

public class Q401 {
    List<String> res = new ArrayList<>();
    String s ="";
    public List<String> readBinaryWatch(int turnedOn) {

          for(int i=0;i<=turnedOn;i++){
              List<String> list1 = new ArrayList<>();
              List<String> list2 = new ArrayList<>();
             dfsh(i,4,list1,0);
             dfsm(turnedOn-i,0,6,list2);
             for(String a:list1){
                 for(String b:list2){
                     res.add(a+":"+b);
                 }
             }
          }
          return  res;

    }

    private void dfsm(int i, int sum, int index, List<String> list2) {
        if(sum>59) return;
        if(i<0) return;
        if(index==0) return;
        if(i==0) {
            list2.add(String.valueOf(i));
            return;
        }
        dfsm(i-1,sum+=Math.pow(2,index-1),index-1,list2);
        dfsm(i,sum,index-1,list2);
    }

    private void dfsh(int i, int index, List<String> list1,int sum) {
        if(i<0) return;
        if(index==0) return;
        if(sum>=11) return;
        if(i==0) {
             list1.add(String.valueOf(i));
             return;
         }
         dfsh(i-1,index-1,list1,sum+=Math.pow(2,index-1));
         dfsh(i,index-1,list1,sum);
    }

}
