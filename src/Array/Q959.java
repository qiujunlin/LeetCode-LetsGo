package Array;

import java.util.*;

/**
 * @Classname Q959
 * @Description:
 * @Date 2021/2/13 16:46
 * @Created by qiujunlin
 */
public class Q959 {
    public int regionsBySlashes(String[] grid) {
        int len  = grid.length;
        int count =  4*len*len;
        Union u = new Union(count);
        //遍历每个方格
        for(int i = 0 ;i < len; i++){
            char ch[] =  grid[i].toCharArray();
            int k = 0;
            for(int j = 0; j < len ; j++){
                //计算ch的下标
                int index = i*len*4 + j*4;//计算每个小方格的下标
                if(ch[k] == ' '){
                    u.merge(index,index+1);
                    u.merge(index+1,index+2);
                    u.merge(index+2,index+3);
                    u.merge(index+3,index);
                }else if(ch[k] == '/'){
                   u.merge(index,index+1);
                   u.merge(index+2,index+3);
                }else if(ch[k] == '\\'){
                    u.merge(index+1,index+2);
                    u.merge(index+3,index);
                }
                if(i!=len-1){
                    u.merge(index+3,index+len*4+1);
                }
                if(j!=len-1){
                    u.merge(index+2,index+4);
                }
                k++;

            }
        }
    return u.count;
    }

    public static void main(String[] args) {
        String a[] = {"/\\", "\\/"};
        //String c = "\\";
       // System.out.println(c.length());

        System.out.println(new Q959().regionsBySlashes(a));
    }
}
class Union{
    int parent[];
    int count;
    public  Union(int len){
        parent = new int[len];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        count  = len;
    }
    public  void merge(int x,int y){
        int fx = find(x);
        int fy = find(y);
        if(fx != fy) {
            parent[fx] = fy;
            count--;
        }
        //parent[fx] = fy;
    }
    public int find(int x){
        return x == parent[x]?x : (parent[x] = find(parent[x]));
    }

}