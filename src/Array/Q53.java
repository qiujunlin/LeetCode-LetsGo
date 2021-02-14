package Array;

import java.util.*;

/**
 * @Classname Q53
 * @Description:
 * @Date 2021/2/13 21:40
 * @Created by qiujunlin
 */
public class Q53 {

    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }

        @Override
        public String toString() {
            return "Status{" +
                    "lSum=" + lSum +
                    ", rSum=" + rSum +
                    ", mSum=" + mSum +
                    ", iSum=" + iSum +
                    '}';
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
       // System.out.println();
        Status s =  pushUp(lSub, rSub);

        return  s;
     }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);

        Status  s =  new Status(lSum, rSum, mSum, iSum);
       // System.out.println(s);
        return  s;
    }

    public static void main(String[] args) {
        int mod = 1000000007;
        long a = 100000;
        long b = a*(a+1)/2%mod;
        long e = a*a;
        long c = a*(a+1)/2;
        long d = c%mod;
        System.out.println(e);
        System.out.println(c);
        System.out.println(d);
        System.out.println(b);
       // System.out.println(new Q53().maxSubArray(a));
    }
}
