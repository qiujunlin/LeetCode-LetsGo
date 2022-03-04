package template;

import java.util.ArrayList;
import java.util.List;

public class Mathtemp {
    public int LCM(int x ,int y){
        return  x*y/GCD(x,y);
    }
    public int GCD(int x,int y){
        int a = Math.min(x,y);
        int b = Math.max(x,y);
        while (b%a!=0){
            int c = b%a;
            b = a;
            a = c;
        }
        return  a;
    }
    //分解质因数 https://www.cnblogs.com/youxin/p/3232049.html
    List<Integer> getPrime(int num){
        List<Integer> list = new ArrayList<>();
        for(int i=2;i<=num;i++){
            while (i!=num){
                if(num%i==0) {
                    list.add(i);
                    num = num / i;
                }else{
                    break;
                }
            }
        }
        list.add(num);
        return  list;
    }

    double quickMul(double x, long  N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Mathtemp().getPrime(24));
    }
}
