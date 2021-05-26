package template;

import java.util.*;

/**
 * @Classname TreeArray
 * @Description:
 * @Date 2021/5/25 21:48
 * @Created by qiujunlin
 */
class  TreeArray{
    int tree[];
    int n ;
    public  TreeArray(int n){
        tree = new int[n+1];
        this.n = n;
    }
    public  void update(int x,int num){
        while (x<=n){
            tree[x]+=num;
            x+=lowbit(x);
        }
    }
    public  int query(int x){
        int res =0;
        while (x>0){
            res+=tree[x];
            x-=lowbit(x);
        }
        return  res;
    }
    public  int lowbit(int x){
        return  x&-x;

    }

}


