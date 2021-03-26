package Al4;

import java.util.*;

/**
 * @Classname Uniop
 * @Description:
 * @Date 2021/3/26 21:22
 * @Created by qiujunlin
 */
public class Union {
    int len ;
    int parent[];
    int count;
    public  Union(int len){
        this.len=len;
        this.count=len;
        parent =new int[len];
        for(int i=0;i<len;i++) parent[i] = i;
    }
    public  void  merge(int x,int y){
        int newx  =find(x);
        int newy = find(y);
        if(newx!=newy){
            parent[newx] =newy;
            count--;
        }
    }
    public  boolean isconnected(int x,int y){
        return find(x)==find(y);
    }
    public  int find(int x){
      return parent[x] == x?x:(parent[x]=find(parent[x]));
    }
}
