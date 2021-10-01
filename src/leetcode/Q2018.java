package leetcode;

/**
 * @description: test
 * @author: qiujunlin
 * @create: 2021-09-27 20:14
 */
public class Q2018 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
             if(judge(board[i],word)) return  true;
        }
        char board2[][]  = new char[board[0].length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board2[j][i] = board[i][j];
            }
        }
        for (int i = 0; i <board2.length ; i++) {
            if(judge(board2[i],word)) return  true;
        }
        return  false;
    }

    private boolean judge(char[] chars,String word) {
         String s   = new String(chars);
         String substring[] = s.split("#");
         for(String ss :  substring){
             if(ss.length()<word.length()) continue;
             int index  =  0;
             for (int i = 0; i <ss.length() ; i++) {
                 if(ss.charAt(i)==' ') index++; //  空格直接匹配
                 else if(ss.charAt(i)==word.charAt(index)) { // 是字母 相等 直接匹配
                       index++;
                  }else  {// 是字母 不相等  就重新匹配,并且找到下一个是空格的地方开始
                         while (i<ss.length()&&ss.charAt(i)!=' '){
                             i++;
                         }
                         index = 0;
                 }
                 if(index ==  word.length()&&(i==ss.length()-1||ss.charAt(i+1)==' ')) return  true;
             }
         }
         return false;
    }
}
