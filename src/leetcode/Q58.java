package leetcode;

public class Q58 {
    public String countAndSay(int n) {
        StringBuilder s =  new StringBuilder() ;
        s.append(1);
        for (int i = 0; i <n ; i++) {
             StringBuilder temp = new StringBuilder();
             int index =1;char c = s.charAt(0);int count  =1;
             while (index<s.length()){
                 if(s.charAt(index)==s.charAt(index-1)){
                     count++;
                 }else{
                     temp.append(count);temp.append(c);
                     c = s.charAt(index);count =1;
                 }
             }
             temp.append(count);temp.append(c);
             s=temp;
        }
        return  s.toString();

    }

}
