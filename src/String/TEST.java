package String;

import java.util.*;

public class TEST {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("文学","小说","历史","言情","科幻","悬疑");

        String string1 = String.join(" ",list1);

        System.out.println(string1);
    }

}
