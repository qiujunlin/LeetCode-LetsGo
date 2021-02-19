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
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String ss : words){
            hashMap.put(ss,hashMap.getOrDefault(s,0)+1);
        }
        int len = words.length;
        int stride  =words[0].length();
        for(int i = 0;i< s.length()-len*stride;i++){
            for(int j = i;j<s.length()-len*stride;j+=stride){
                HashMap<String,Integer> hashMap1 = new HashMap<>();
                for(int k =0;k<len;k++) {
                    String sub = s.substring(j+k*stride,j+(k+1)*stride);
                    hashMap1.put(sub,hashMap1.getOrDefault(0,1)+1);
                }
                System.out.println(hashMap1);
                if(hashMap1.equals(hashMap)){
                    res.add(j);
                }
            }
        }
        return  res;

    }
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("word",1);
        hashMap.put("best",1);
        hashMap.put("good",2);
        HashMap<String,Integer> hashMap2 = new HashMap<>();
        hashMap.put("word",1);
        hashMap.put("best",1);
        hashMap.put("good",2);
        System.out.println(hashMap.equals(hashMap2));
        hashMap.size()
        System.out.println(hashMap.get("aaa"));
       // System.out.println(new Q53().maxSubArray(a));
    }
}
