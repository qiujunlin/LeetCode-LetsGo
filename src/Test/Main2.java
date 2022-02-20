package Test;


import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


    public class Main2   {


        public static void main(String[] args) throws InterruptedException {
            System.out.println(0.1+0.1);



//           int a[] = new int[]{2,3,5,1,4,9,7,6,8,321,321,543,765,2313,3213,76,5435,24,65,54};
//           int temp[] =new int[a.length];
//           new Main2().quicksort(a,0,a.length-1);
//            for (int i = 0; i < a.length; i++) {
//                System.out.print(a[i]+" ");
//            }
//            List<String>  l =new ArrayList<>();
//
//            String.join("", l);
//            System.out.println(Integer.MAX_VALUE);

        }
        void maopao(int a[]){
            for (int i = 0; i <a.length ; i++) {
                for (int j = i+1; j <a.length ; j++) {
                     if(a[j]<a[i]){
                         int temp =a[j];
                         a[j] =a[i];
                         a[i] =temp;
                     }
                }
            }
        }
        public String multiply(String num1, String num2) {
           if(num1.length()>num2.length()){
               String te = num1;num1 =num2;num2 =te;
           }
            int num[] =new int[num1.length()+num2.length()];
            for (int i = num1.length()-1; i >=0 ; i--) {
                int a = num1.charAt(i)-'0';
                for (int j = num2.length()-1; j >=0; j--) {
                     int b =num2.charAt(i)-'0';
                     int mul = a*b+num[i+j+1];
                     num[i+j+1] = mul%10;
                     num[i+j] =mul/10;
                }
            }
            StringBuilder s = new StringBuilder();
            for (int i = 0; i <num.length ; i++) {
                 if(i==0&&num[0]==0)continue;
                 s.append(num[i]);
            }
            return  s.toString();
        }
 // 1234 + 123
        private StringBuilder add(StringBuilder res, StringBuilder temp) {

            res = res.reverse();
            temp =temp.reverse();
            int len =Math.min(res.length(),temp.length());
            int pre =0;
            StringBuilder rs =new StringBuilder();
            for (int i = 0; i <len ; i++) {
                int a =  i>=res.length()?0:res.charAt(i)-'0';
                int b =  i>=temp.length()?0:temp.charAt(i)-'0';
                rs.append((a+b+pre)%10);
                pre =(a+b)%10;
            }
            rs.append(pre==0?"":pre);
            return  res.reverse();

        }

        void guibing(int a[] ,int temp[],int l ,int r){
            if(l>=r) return;
            int mid  = (l+r)/2;
            guibing(a,temp,l,mid);
            guibing(a,temp,mid+1,r);
            merge(a,temp,l,mid,r);
        }

        private void merge(int[] a, int[] temp, int l, int mid, int r) {
            for (int i = l; i <=r ; i++) temp[i] =a[i];
            int left =l;int right = mid+1;
            for (int i = l; i <=r ; i++) {
                if(left>mid) a[i] =temp[right++];
                else if(right>r) a[i] =temp[left++];
                else if(temp[left]<temp[right]) a[i] = temp[left++];
                else a[i] =temp[right++];
            }
            return;
        }

        void  quicksort(int a[],int l,int r){
            if(l>=r) return;
            int i =  part(a,l,r);
           // System.out.println(i);
            quicksort(a,l,i-1);
            quicksort(a,i+1,r);
        }

        private int part(int[] a, int l, int r) {
            int left = l;
            int right =r;
            while (left<right){
                while (left<right&&a[right]>a[l]) right--;
                while (left<right&&a[left]<=a[l]) left++;

                int temp = a[left];
                a[left] =a[right];
                a[right] =temp;
            }
            int temp = a[l];
            a[l] =a[left];
            a[left] =temp;
            return  left;
        }
        public List<Integer> majorityElement(int[] nums) {
              int a =0;int counta =0;
              int b =0;int countb =0;
              for(int n : nums){
                  if(n==a) {
                      counta++;
                      continue;
                  }
                  if(n==b){
                      countb++;continue;
                  }
                  if(counta==0){
                      a=n;
                      counta++;
                      continue;
                  }
                  if(countb==0){
                      b=n;
                      countb++;
                      continue;
                  }
                  counta--;
                  countb--;
              }
              int ca =0;
              int cb =0;
              for(int n:nums){
                  if(n==a)ca++;
                  else  if(n==b) cb++;
              }
              ArrayList<Integer>  l =new ArrayList<>();
              if(ca>=nums.length/3) l.add(a);
              if(cb>=nums.length/3) l.add(b);
        return  l;
        }
        public int[] topKFrequent(int[] nums, int k) {
             HashMap<Integer,Integer> map =new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            PriorityQueue<Integer>  queue =new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
            for(int a:map.keySet()){
                queue.offer(a);
                if(queue.size()>k) queue.poll();
            }

            int res[] =new int[k];
            for (int i = 0; i <k ; i++) {
                res[i] = queue.poll();
            }
            return  res;
        }

    }
