package Al4.Graph;

import java.util.*;

/**
 * @Classname MaxPQ
 * @Description:
 * @Date 2021/4/25 23:28
 * @Created by qiujunlin
 */
public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq; // 基于堆的完全二叉树
    private int N = 0; // 存储于pq[1..N]中，pq[0]没有使用
    private Comparator<? super  Key> comparator;
    public MaxPQ(int maxN) {
        this.pq = (Key[]) new Comparable[maxN+1];
    }
    public  MaxPQ(Comparator<? super Key> comparator){
        this.pq = (Key[]) new Comparable[100+1];
        this.comparator =  comparator;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void insert(Key v)
    {
        pq[++N] = v;
        swim(N);
    }
    public Key delMax()
    {
        Key max = pq[1]; // 从根结点得到最大元素
        exch(1, N--); // 将其和最后一个结点交换
        pq[N+1] = null; // 防止对象游离
        sink(1); // 恢复堆的有序性
        return max;
    }
    private boolean less(int i, int j){
        if (comparator == null) {
            return  pq[i].compareTo(pq[j]) < 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }
    private void exch(int i, int j){
        Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
    }
    private void swim(int k){
        while (k>1&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }
    private void sink(int k){
        while (2*k<=N){
            int j = 2*k;
            if(j<N&&less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }

    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>((a,b)->b-a);
        for(int i=0;i<100;i++){
             pq.insert(i);
        }
        for(int i=0;i<10;i++){
            System.out.println(pq.delMax());
        }
    }
}
