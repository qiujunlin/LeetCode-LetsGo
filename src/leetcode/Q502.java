package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description: IPO
 * @author: qiujunlin
 * @create: 2021-09-17 10:49
 */
public class Q502 {
    public static void main(String[] args) {

    }
    int maxWidth ;
    public List<String> fullJustify(String[] words, int maxWidth) {
        this.maxWidth = maxWidth;
        List<String> res   = new ArrayList();
        int i =0;
        while(i<words.length){
            int count  =0;
            int j  = i;
            int len =  0;
            while(j<words.length){

                if(j==words.length-1){
                    res.add(get(i,j,words));
                    i =  words.length;
                    break;
                }
                if(i==j){ // 如果是第一个
                    len += words[j].length();
                }else{
                    if(words[j].length()+len+1<=maxWidth){ //小于
                        len = len+1+words[j].length();
                    }else{
                        res.add(get(i,j-1,words));
                        i = j; // 不行
                        break;
                    }
                }
                j++;
            }
        }
        System.out.println(res);
        return res;
    }
    //len 所有单词
    String get(int  start ,int end,String words[]){
        if(start==end){
            int  c =  maxWidth -  words[start].length();
            while(c>0){ words[start]+=" "; c--;}
            return words[start];
        }
        StringBuffer s =  new StringBuffer();
        int count  =  end-start+1;//单词数量
        int len = 0; // 单词连起来总长度
        for(int i=start;i<=end;i++){
            len +=  words[i].length();
        }

        int  space  = maxWidth - len;
        int  a =  space%(count-1); //  多余的空格有多少个
        String s1 =  "";
        int  b =  space/(count-1);  // 每个间隔空格有多长
        while(b>0) {s1+=" ";b--;}

        for(int i = start;i<=end;i++){
            if(i==start) s.append(words[i]);
            else{
                s.append(s1);
                if(i-start<=a) s.append(" ");
                s.append(words[i]);
            }
        }
        return s.toString();


    }
}
