package leetcode;

public class Q6 {
    public String convert(String s, int numRows) {
        StringBuffer stringBuffer[] = new StringBuffer[numRows];
        for (int i = 0; i <numRows ; i++) {
            stringBuffer[i] = new StringBuffer();
        }
        int flag =-1;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            stringBuffer[row].append(s.charAt(i));
            if(row==numRows-1||row==0) flag = -flag;
            row+=flag;
        }
        String res = "";
        for(StringBuffer st : stringBuffer) {
            res+=st.toString();
        }
        return  res;
    }
}
