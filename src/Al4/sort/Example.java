package Al4.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class Example {
    public static void sort(Comparable[] a) { /* 请见算法2.1、算法2.2、算法2.3、算法2.4、算法2.5或算法2.7*/
        //选择
        int len = a.length;
        for(int i=0;i<len;i++){
            int min = i;
            for (int j=i+1;j<len;j++){
                if(!less(a[min],a[j])) min=j;
            }
            exch(a,i,min);
        }
    }
    public static void sort2(Comparable[] a) { /* 请见算法2.1、算法2.2、算法2.3、算法2.4、算法2.5或算法2.7*/
        //插入
        int len = a.length;
        for(int i=1;i<len;i++){
            //int temp = a[i];
            for(int j=i;j>0;j--){
                if(!less(a[i],a[i-1])) exch(a,j,j-1);
            }
        }

    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) { // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) { // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) { // 从标准输入读取字符串，将它们排序并输出
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}