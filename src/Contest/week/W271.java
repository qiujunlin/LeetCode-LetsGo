package Contest.week;

import Test.Main;

import java.util.HashMap;
import java.util.TreeMap;

public class W271 {
    public int countPoints(String rings) {
        int nums[][] =  new int[10][3];
        for (int i = 0; i <rings.length() ; i+=2) {
            char c  =  rings.charAt(i);
            int  n =  rings.charAt(i+1)-'0';
            if(c=='R') {
                nums[n][0]++;
            }else if(c=='G'){
                nums[n][1]++;
            }else{
                nums[n][2]++;
            }
        }
        int res  =0;
        for (int i = 0; i < 10; i++) {
            if(nums[i][0]!=0&&nums[i][1]!=0&&nums[i][2]!=0) res++;
        }
        return  res;

    }
    public long subArrayRanges(int[] nums) {

        long res  =0;
        for (int i = 0; i <nums.length ; i++) {
            int max  =nums[i];
            int min  =nums[i];
            for (int j = i+1; j < nums.length; j++) {
                     min= Math.max(nums[j],max);
                     max= Math.min(nums[j],min);
                     res+=max-min;
            }
        }
        return  res;



    }
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {

        int indexa =0;int indexb =  plants.length-1;
        int a =capacityA;int b =capacityB;
        int res =0;
        while (indexa<indexb){
            if(indexa==indexb){
                if(a>=b){
                    if(plants[indexa]>a) res++;
                }else if(b>a){
                    if(plants[indexb]>b) res++;
                }
                break;
            }
             if(plants[indexa]>a) {
                 a = capacityA;
                 res++;
             }
             if(plants[indexb]>b){
                 b =capacityB;
                 res++;
             }
             a -= plants[indexa];
             b -= plants[indexb];
             indexa++;indexb--;
        }
        return  res;


    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {

        int len = fruits[fruits.length-1][0];
        int pre[] = new  int[len+1];
        int arr[] =  new int[len+1];
        for (int i = 0; i < fruits.length; i++) {
            arr[fruits[i][0]] =  fruits[i][1];
        }
        for (int i = 0; i <arr.length ; i++) {
            pre[i+1] = pre[i] +  arr[i];
        }
        int max =0;
        for (int length = 0; length <=k ; length++) {
             int l = Math.max(startPos-length*2,0);int r  =Math.min( startPos +length,len-1);
             max =Math.max(pre[r+1]-pre[l],max);
             l = Math.max(startPos-length,0); r  =Math.min( startPos +length*2,len-1);
            max =Math.max(pre[r+1]-pre[l],max);

        }
        return  max;


    }
}
