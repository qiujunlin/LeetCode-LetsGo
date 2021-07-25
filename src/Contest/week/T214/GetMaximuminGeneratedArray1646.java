package Contest.week.T214;

/**
 * @Classname GetMaximuminGeneratedArray1646
 * @Description:
 * @Date 2020/11/15 13:54
 * @Created by qiujunlin
 */
public class GetMaximuminGeneratedArray1646 {
    public int getMaximumGenerated(int n) {
        if(n==0) return 0;
        int a[]= new int[n+1];
        a[0]=0;
        a[1]=1;
        for(int i=1;i<=n;i++){
            if(i*2>=2&&i*2<=n) {
                a[i*2]=a[i];
            }
            if((i*2+1)>=2&&(i*2+1)<=n){
                a[2*i + 1] = a[i] + a[i + 1];
            }
        }
        int max=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        return max;
    }
}
