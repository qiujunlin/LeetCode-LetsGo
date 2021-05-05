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

 static class Node{
        double k;
        double b;

     public Node(double k, double b) {
         this.k = k;
         this.b = b;
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Node node = (Node) o;
         return Double.compare(node.k, k) == 0 &&
                 node.b-b< 0.1;
     }

     @Override
     public int hashCode() {
         return Objects.hash(k, b);
     }
 }
 public  static   void  Zhi(){
   int m =20;
   int n=21;
   int points[][]=  new int[420][2];
   int index =0;
   for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            points[index][0] =i;
            points[index][1] =j;
            index++;
        }
    }
    Set<Node> set = new HashSet<>();
    for(int i=0;i<points.length;i++){
        int point1[] = points[i];
        for(int j =i;j<points.length;j++){
            int point2[] =points[j];
            if(point1[0]!=point2[0]&&point1[1]!=point2[1]){
                double x1=point1[0];
                double y1=point1[1];
                double x2=point2[0];
                double y2=point2[1];
                double k =(y1-y2)/(x1-x2);
                double b= y2-k*x2;
                set.add(new Node(k,b));
            }
        }
    }
    int res =   m+n+set.size();
     System.out.println(res);

    }
    public static void main(String[] args) {
      //  System.out.println(420*420);
        Random random = new Random();
        long start =System.currentTimeMillis();
        Zhi();

        long end  =System.currentTimeMillis();
        System.out.println("运行时间:"+(end-start)+" 毫秒");
    }

}
