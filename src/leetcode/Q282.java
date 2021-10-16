package leetcode;

import java.util.*;

public class Q282 {
    List<String> rs = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        StringBuilder s = new StringBuilder();
        dfs(0,num,0,target,0,s);
        return  rs;
    }

    void dfs(long sum, String num, int index, int target, long pre, StringBuilder res) {
        if (index == num.length()) {
            if (sum == target) {
                // if(res.length()==1&&sum==0&&)
                rs.add(res.toString());
            }
            return;
        }
        // + - *
        for (int i = index; i < num.length(); i++) {
            long a = Long.valueOf(num.substring(index, i + 1));
            if(num.charAt(index)=='0'&&i>index) return;
            if (index == 0) {
                res.append(a);
                dfs(a,num,i+1,target,a,res);
                res.delete(0,res.length());
            } else {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        res.append('+');
                        res.append(a);
                        dfs(sum + a, num, i + 1, target, a, res);
                    } else if (j == 1) {
                        res.append('-');
                        res.append(a);
                        dfs(sum - a, num, i + 1, target, -a, res);
                    } else {
                        res.append('*');
                        res.append(a);
                        dfs(sum - pre + pre * a, num,  i + 1,target, pre * a, res);
                    }
                    //System.out.println(res.toString());
                    res.delete(res.length() - (i-index+2), res.length());

                }
            }
        }

    }
}
