package Contest.week.T215;

import java.util.*;

/**
 * @Classname DesignanOrderedStream
 * @Description:
 * @Date 2020/11/15 13:21
 * @Created by qiujunlin
 */
public class DesignanOrderedStream5601 {

    String a[];
    int ptr=0;
    public DesignanOrderedStream5601(int n) {
        a=new String[n];
    }

    public List<String> insert(int id, String value) {
        List<String> list  = new ArrayList<>();
        a[id-1]=value;
        while(ptr<a.length&&a[ptr]!= null){
            list.add(a[ptr++]);
        }
        return list;
    }
}
