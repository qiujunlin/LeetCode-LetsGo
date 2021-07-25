package Contest.week.TD39;

/**
 * @Classname DefusetheBomb5550
 * @Description:
 * @Date 2020/11/15 13:57
 * @Created by qiujunlin
 */
public class DefusetheBomb5550 {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int res[]= new int[len];
        int a=k;
        for(int i=0;i<len;i++){
            k=a;
            if(a>0){
                for(int j=0;j<Math.abs(a);j++){
                    res[i]+=code[(i+k)%len];
                    k--;

                }
            }else if(a<0){
                for(int j=0;j<Math.abs(a);j++){
                    res[i]+=code[((i+k)>=0?i+k:(i+k)+len)];
                    k++;
                }
            }else if(a==0){
                res[i]=0;
            }
        }


        return res;

    }

}
