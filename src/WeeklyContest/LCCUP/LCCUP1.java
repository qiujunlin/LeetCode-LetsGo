package WeeklyContest.LCCUP;

public class LCCUP1 {
    public int storeWater(int[] bucket, int[] vat) {
       int res  =0 ;
       //寻找最小值
        for(int i=0;i<bucket.length;i++) if (bucket[i]==0&&vat[i]!=0) {
            bucket[i]++;
            res+=1;
        }

        for(int i=0;i<bucket.length;i++){

        }
    }

}
