package template;

import javax.swing.text.TabExpander;
import java.util.*;

/**
 * @Classname Sort
 * @Description:
 * @Date 2021/5/6 22:17
 * @Created by qiujunlin
 */
public class Sort {
    public static void main(String[] args) {
        int a[]= {2,453,32,6,87,23,9,32,1};
        int b[]=  new int[10000];
        for (int i = 10000-1; i >0; i--) {
            b[i] = i;
        }
        long s= System.currentTimeMillis();
        //shell(temp);
        quicksort(a,0,a.length-1);
        //Arrays.sort(a);
        long end =System.currentTimeMillis();
        System.out.println("time:"+(end-s));
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+" ");
        }
        //  System.out.println(a);
    }
    //希尔排序
    public  static  void  shell(Comparable[] a){
        int N  =a.length;
        int h=1;
        while (h<N/3) h=h*3+1;
        while (h>=1){
            for(int i=h;i<N;i++){
                for(int j=i;j>=h;j-=h){
                   if(a[j].compareTo(a[j-h])==-1){
                       Comparable temp =a[j];
                       a[j]=a[j-h];
                       a[j-h] =temp;
                   }
                }
            }
            h=h/3;
        }
    }
    //归并排序
    public  static  void guibing(Comparable a[]){
        int len  = a.length;
        Comparable temp[] = new Comparable[len];
        sort(a,temp,0,len-1);
    }

    private static void sort(Comparable[] a, Comparable[] temp, int start, int end) {
       if(start>=end) return;
       int mid = (start+end)/2;
       sort(a,temp,start,mid);
       sort(a,temp,mid+1,end);
       merge(a,temp,start,mid,end);
    }

    private static void merge(Comparable[] a, Comparable[] temp, int start, int mid, int end) {
        for(int i=start;i<=end;i++) temp[i]=a[i];
        int left=start;
        int right=mid+1;
        for(int i=start;i<=end;i++){
            if(left>mid) a[i]=temp[right++];
            else if(right>end) a[i] =temp[left++];
            else if(temp[left].compareTo(temp[right])==-1) a[i]=a[left++];
            else  a[i]=temp[right++];
        }
    }
    //快速排序
    public  static  void kuaishu(Comparable a[]){
        sortq(a,0,a.length-1);
    }

    private static void sortq(Comparable[] a, int l, int r) {
     if(l>=r) return;
     int mid = partition(a,l,r);
     sortq(a,l,mid-1);
     sortq(a,mid+1,r);
    }

    private static int partition(Comparable[] a, int l, int r) {
        int left =l;
        int right =r;
        while (true){
            while (a[++left].compareTo(a[l])<0) if(left==r) break;
            while (a[--right].compareTo(a[l])>0)  if(right==l) break;
            if(left>=right) break;
            Comparable temp = a[left];
            a[left] =a[right];
            a[right] =temp;
        }
        Comparable temp = a[l];
        a[l] =a[right];
        a[right] =temp;
        return      right;
    }
    private  static  int partition(int a[],int l ,int r){
        int left = l;
        int right = r;
        while (left<right){
            while (right>left&&a[right]>a[l]) right--;
            while (left<right&&a[left]<=a[l]) left++;
            if(left<right) {
                int temp = a[right];
                a[right] = a[left];
                a[left] = temp;
            }
        }

        int temp = a[left];
        a[left] = a[l];
        a[l] =temp;
        return  left;
    }
    private  static  void quicksort(int a[],int l ,int r){
         if(l>=r) return;
         int i =  partition(a,l,r);
         quicksort(a,l,i-1);
         quicksort(a,i+1,r);

    }
}
