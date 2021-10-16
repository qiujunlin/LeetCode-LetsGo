package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q118 {
    public List<List<Integer>> generate(int numRows) {
          List<List<Integer>> res=  new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if(i==0){
                list.add(1);
            }else if(i==1){
                list.add(1);list.add(1);
            }else{
                List<Integer> temp =  res.get(res.size()-1);
                list.add(1);
                for (int j = 1; j < temp.size()-1; j++) {
                    list.add(temp.get(i-1)+temp.get(i));
                }
                list.add(1);
            }
            res.add(list);
        }
        return  res;

    }
}
