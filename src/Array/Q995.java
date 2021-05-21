package Array;

import java.util.Deque;
import java.util.LinkedList;

public class Q995 {

    public int minKBitFlips(int[] A, int K) {
        //diff[i] 表示当前位置和上一个位置被翻转的次数的差值，
        // revcnt 表示当前位置被翻转的次数
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;

    }
    public int minKBitFlips2(int[] A, int K) {
        Deque<Integer> de = new LinkedList<>();
        int rs =0;
        for(int i=0;i<A.length;i++){
            if(de.size()>0&&i-de.peekFirst()>=K){
                de.pollFirst();
            }
            if((de.size()+A[i])%2==0){
                if(i+K-1>A.length-1) return -1;
                de.addLast(i);
                rs++;

            }

        }
        return rs;

    }

    public static void main(String[] args) {
         int a [] = new int[]{0,0,0,1,0,1,1,0};
         new Q995().minKBitFlips(a,3);
    }
}
