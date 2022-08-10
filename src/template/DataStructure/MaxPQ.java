package template.DataStructure;

import java.util.Arrays;
import java.util.Random;

public class MaxPQ {

    int nums[] ;
    int len=-1 ;
    int maxlen ;
    public  MaxPQ(int len) {
        nums = new int[len];
    }
    public  void insert(int v){
        nums[++len] =  v;
        swim(nums,len);
    }
    public  int deleteMax(){
        int key  = nums[0];
        swap(nums,0,len);
        nums[len] =0; len--;
        sink(nums,0,len);
        return  key;

    }
    void sink(int nums[],int k,int len){
        while(k*2+1<=len){
            int n = k*2+1;
            if(n+1<=len&&nums[n]<nums[n+1]) n++;
            if(nums[n]<nums[k])  break;
            swap(nums,n,k);
            k=n;
        }
    }
    void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i]  =nums[j];
        nums[j] =temp;
    }
    void swim(int nums[],int k){
        while (k>0&&nums[k/2]<nums[k]){
            swap(nums,k/2,k);
            k=k/2;
        }
    }

    @Override
    public String toString() {
        return "MaxPQ{" +
                "nums=" + Arrays.toString(nums) +
                '}';
    }

    public static void main(String[] args) {
        Random random =new Random();
        MaxPQ maxPQ=new MaxPQ(100);
        for (int i = 0; i <100 ; i++) {
             maxPQ.insert(random.nextInt(100));
        }
        while (maxPQ.len!=0) {
            System.out.println(maxPQ.deleteMax());
        }
        System.out.println( maxPQ.toString());
    }
}
