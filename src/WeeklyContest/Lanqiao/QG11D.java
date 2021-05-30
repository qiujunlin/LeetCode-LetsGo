package WeeklyContest.Lanqiao;

public class QG11D {
    public static void main(String[] args) {
        String s = "tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhfiadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqijgihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmad vrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl";
        char ch[] = s.toCharArray();
      //  System.out.println(ch.length);
        long res  =0;
        int len  =s.length();
        long dp[] =new long[len];
        dp[0] =1;
        for(int i=1;i<len;i++){
            dp[i] =1;
            for(int j=0;j<i;j++){
                if(ch[i]>ch[j]){
                    dp[i] +=dp[j];
                }else if(ch[i]==ch[j]){
                    dp[i] -= dp[j];
                }
            }
        }
        for(long a:dp) res+=a;
        System.out.println(res);
    }
}
