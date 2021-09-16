package leetcode;

/**
 * @Classname IncreasingDecreasingString1370
 * @Description:
 * @Date 2020/11/25 14:14
 * @Created by qiujunlin
 */
public class IncreasingDecreasingString1370 {
    public String sortString(String s) {
        int hash[]=new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        char res[]=new char[s.length()];
        int index=0;
        //int i=0;
        int flag=1;
        while(index!=s.length()){
            //int i=0;
            if(flag==1){
                int i=0;
                while(i<26){
                    if(hash[i]!=0){
                        res[index++]=(char)(i+'a');
                        hash[i]--;
                    }
                    i++;
                }
            }else{
                int j=25;
                while(j>=0){
                    if(hash[j]!=0){
                        res[index++]=(char)(j+'a');
                        hash[j]--;
                    }
                    j--;
                }


                // if(i==25||i==0) flag=-flag;
                //if(i==0||i==25) continue;
                //if()
                //i=i+flag;
            }
            flag=-flag;

        }
        return  String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingDecreasingString1370().sortString(
                "aaaabbbbcccc"));
    }
}
