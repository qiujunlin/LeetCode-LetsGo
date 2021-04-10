package WeeklyContest.LCCUP;

public class LCP12 {
    public int minTime(int[] time, int m) {
        int sum = 0;
        for(int a: time) sum+=a;
        int len  = time.length;
        int left  = 0;
        int right  =  sum;

        while (left<right){
            int mid  = (left+right)/2;
            boolean flag =  check(time,mid,m);
            if(flag) right = mid;
            else left =  mid+1;
        }
        return  left;

    }

    private boolean check(int[] time, int mid, int m) {
          //算法 贪心  判断连续n个一组  记录最大值 ，s剩下的值不能超过mid
        int count =0;//记录组数
        int max =  time[0];//维护最大值
        int sum =0;//记录和
        for(int i=1;i<time.length;i++){
            if(max<time[i]){
                sum -= max;
                max =  time[i];
                sum+=max;
            }else{
                sum+=time[i];
            }
            //如果大于mid
            if(sum>mid){
                count++;
                sum = 0;
                max = time[i];
            }
        }
        count++;
        return  count<=m;
    }

    public static void main(String[] args) {
        int test[] = new int[]{ 1,2,3,3,3};
        int test2[] = new int[]{999,999,999};
        int test3[] = new int[]{1,1};
        System.out.println(new LCP12().minTime(test,2));
    }

}
