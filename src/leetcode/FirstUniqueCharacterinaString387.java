package leetcode;

/**
 * @Description:
 * @Author: qiujunlin
 * @Date: 2020/12/24
 */
public class FirstUniqueCharacterinaString387 {
    public int firstUniqChar(String s) {
        char ch[] =s.toCharArray();
        int hash[] = new int[26];
        //  int pre=ch.length-1;
        for(int i=ch.length-1;i>=0;i--){
            hash[ch[i]-'a']++;
        }
        for(int i=0;i<=ch.length-1;i++){
            if(hash[ch[i]-'a']==1) return  i;
        }
        return -1;
    }
}
