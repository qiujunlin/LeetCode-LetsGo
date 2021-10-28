package leetcode;

import java.util.HashSet;

public class Q869 {
    public static void main(String[] args) {

    }
    public boolean reorderedPowerOf2(int n) {
        int i=1;
        while (i<= (1<<30)){
            if(judge(i,n)) return  true;
            i = i*2;
        }
        return  false;

    }

    private boolean judge(int i, int n) {
        int count [] = new int[10];
        while (i!=0){
            count[i%10]++;
            i = i/10;
        }
        while (n!=0){
            count[i%10]--;
            if(count[i%10]<0)  return  false;
            i = i/10;
        }
        return  true;
    }
}
