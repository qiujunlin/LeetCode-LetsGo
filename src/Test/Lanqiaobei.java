package Test;

import java.util.*;

public class Lanqiaobei {

    public int B(){
        int hash[] = new int[10];
        Arrays.fill(hash,2021);
        int num=1;
        while (true){
            int temp =num;
            while (num!=0){
                hash[num%10]--;
                if(hash[num%10]<0) return temp-1;
                num=num/10;
            }
            num  =temp+1;
        }
    }
    public static  long C(int a, int b){
        long res = 1;
        for(int i = a, j = 1; j <= b; i --, j ++){
            res = res * i / j;
            // 大于n已无意义，且防止爆Long
        }
        return res;
    }
    public int C(){
        int x = 20;
        int  y =21;
        return  1;

    }
    public void D(){
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        int count = 1;
        int maxnum=1;
        int max =1;
        while (max<num){
            max = (int) (max+Math.pow(3,count));
            count++;
        }
        System.out.println(count);

    }
public static  int H(){
   // Scanner sc=new Scanner(System.in);
    int num = 10000000;
    //int arr[] = new int[1000000000];
    //arr[0]=arr[1] =1;
    int a[] = new int[num];
    int b[] = new int[num];
    int layer =3;
    while (true){
        //int temp[] = new int[layer];
        for(int i=0;i<layer;i++){
            if(i==0||i==layer-1) b[i]=1;
            else b[i] = a[i-1]+a[i];
            if(b[i]==num) return  (layer-1)*(layer)/2+i+1;
        }
        layer++;
        int temp[] = a;
        a =b;
        b=temp;
    }

}


    public static void main(String[] args) {
      //  System.out.println(420*420);
        Random random = new Random();
        long start =System.currentTimeMillis();
        H();
        long end  =System.currentTimeMillis();
        System.out.println("运行时间:"+(end-start)+" 毫秒");
    }

}
