package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Q273 {
    String[] low = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] mid = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] high = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] it = {"Hundred","Thousand","Million","Billion"};

    public String numberToWords(int num) {
        StringBuffer res =new StringBuffer();
        ArrayList<String> list = new ArrayList<>();
        int count  =0;
        while (num!=0){
            int inter  = 0;
            inter += num%1000;
            num=num/1000;
            list.add(get(inter,count));
            count++;
        }
        Collections.reverse(list);
        return  String.join(" ",list);
    }

    private String get(int inter, int count) {
        ArrayList<String> res = new ArrayList<>();
        int bai  = inter/100;
        int ten =  inter%100/10;
        int ge = inter%10;
        if(bai!=0){ res.add(low[inter/100-1]);res.add(it[0]);}
        if(ten==1) {res.add(mid[inter%100-10]);}
        else if(ten>1){res.add(high[ten-2]);if(ge!=0) res.add(low[ge-1]);}
        else if(ten==0&&ge!=0){res.add(low[ge-1]);}
        if(count>0) res.add(it[count]);
        return  String.join(" " ,res);
    }

    public static void main(String[] args) {
     //   System.out.println(new Q273().numberToWords());
    }
}
