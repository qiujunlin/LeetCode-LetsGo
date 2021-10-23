package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q119 {

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> l = new ArrayList<>(rowIndex);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if(i==0||i==j){
                    l.set(i,0);
                }else{
                    l.set(i,l.get(i)+l.get(i-1));
                }
            }
        }
        return  l;
    }
}
