package template.mianshi.bytedance;

import java.util.Arrays;

public class NotMoreThan {
    public static void main(String[] args) {
        NotMoreThan main =new NotMoreThan();
        int nums[] =new int[]{2,3,9};
        int nums2[] =new int[]{2,3,4};
        int res =     main.maxUum(nums2,33215);
        System.out.println(res);
    }
    public  int  maxUum(int nums[],int n){
         Arrays.sort(nums);
        char ch[] =String.valueOf(n).toCharArray();
        int c[] =new int[ch.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = ch[i]-'0';
        }
        int res =   dfs(nums,c,0,new int[c.length]);
        if(res==-1) {
            int rs[] =new int[c.length-1];
            for (int i = 0; i <rs.length ; i++) {
                rs[i] = nums[nums.length-1];
            }
            return  getRes(rs);
        }else{
            return  res;
        }

    }
    int dfs(int nums[],int  ch[],int i,int res[]){
        if(i==res.length){
            int n = getRes(res);
            return  n;
        }
         int n = ch[i];
         int index =getIndex(nums,n);
         if(index==-1) return  -1;
       // System.out.println(n);
        res[i] = nums[index];
        int rs = dfs(nums,ch,i+1,res);
        if(rs!=-1) return  rs;
        if(index==0) return  -1;
        index--;
        res[i] = nums[index];
        for (int j = i+1; j <res.length ; j++) {
            res[j] = nums[nums.length-1];
        }
        return  dfs(nums,ch,res.length,res);
    }

    private int getRes(int[] res) {
        int r =0;
        for (int i = 0; i <res.length ; i++) {
            r = r*10 + res[i];
        }
        return  r;
    }

    private int getIndex(int[] nums, int n) {
        int index  =-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=n){
                index =i;
            }else{
                break;
            }
        }
        return  index;
    }

}
