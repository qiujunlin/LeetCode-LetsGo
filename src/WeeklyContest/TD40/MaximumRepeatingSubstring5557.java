package WeeklyContest.TD40;

import java.util.*;

/**
 * @Classname MaximumRepeatingSubstring5557
 * @Description:
 * @Date 2020/11/29 11:26
 * @Created by qiujunlin
 */
public class MaximumRepeatingSubstring5557 {
    public int maxRepeating(String sequence, String word) {
        int num = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb.toString())){
            num ++;
            sb.append(word);
        }
        return num;
    }
}
